package einkaufVerwalter.model;

import einkaufVerwalter.check.MengenStrategy;
import einkaufVerwalter.data.Einkauf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class EinkaufModel extends AbstractTableModel {
    private List<Einkauf> liste;
    private MengenStrategy mengenStrategy;

    public EinkaufModel() {
        this.liste = new ArrayList<>();
        this.addTestdaten();
        Collections.sort(this.liste);
    }

    private void addTestdaten() {
        liste.add(new Einkauf("Milch", 1.15, 5.0));
        liste.add(new Einkauf("Käse", 1.99, 1.5));
        liste.add(new Einkauf("Milch", 0.95, 2.0));
    }

    public List<Einkauf> getListe() {
        return this.liste;
    }
    
    @Override
    public int getRowCount() {
        return this.liste.size();
    }

    @Override
    public int getColumnCount() {
        return EinkaufSpaltenNamen.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Einkauf e = liste.get(rowIndex);
        
        EinkaufSpaltenNamen enumIndex = EinkaufSpaltenNamen.values()[columnIndex];
        switch(enumIndex) {
            case ARTIKEL: return e.getArtikel();
            case EINZELPREIS: return String.format("%.2f", e.getEinzelpreis());
            case MENGE: return String.format("%.2f", e.getMenge());
            case GESAMTPREIS: return String.format("%.2f", e.getGesamtpreis());
            default: return "?";
        }
    }

    @Override
    public String getColumnName(int column) {
        return EinkaufSpaltenNamen.values()[column].getText();
    }

    public void setMengenStrategy(MengenStrategy mengenStrategy) {
        this.mengenStrategy = mengenStrategy;
    }
    
    public List<Einkauf> checkMenge() throws Exception {
        if(this.mengenStrategy == null) {
            throw new Exception("Mengen - Filter definieren!");
        }
        return this.mengenStrategy.check(this.liste);
    }

    public void add(Einkauf einkauf) {
        this.liste.add(einkauf);
        Collections.sort(this.liste);
        this.fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Einkauf eAlt = this.liste.get(rowIndex);

        String artikelAlt = eAlt.getArtikel();
        Double einzelPAlt = eAlt.getEinzelpreis();
        Double mengeAlt = eAlt.getMenge();
        EinkaufSpaltenNamen enumIndex = EinkaufSpaltenNamen.values()[columnIndex];
        try {
            switch(enumIndex) {
                case ARTIKEL: artikelAlt = aValue+"";
                              break;
                case EINZELPREIS: einzelPAlt = Double.parseDouble(String.format("%s", aValue).replace(",", "."));
                                  break;
                case MENGE: mengeAlt = Double.parseDouble(String.format("%s", aValue).replace(",", "."));
                            break;
            }

            Einkauf eNeu = new Einkauf(artikelAlt, einzelPAlt, mengeAlt);
            this.change(rowIndex, eNeu);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Bitte nur Zahlen eingeben!", 
                    "Fehler", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == EinkaufSpaltenNamen.GESAMTPREIS.ordinal()) {
            return false;
        }
        return true;
    }
    
    public void change(int index, Einkauf e) {
        this.liste.set(index, e);
        Collections.sort(this.liste);
        this.fireTableDataChanged();
        
    }
}
