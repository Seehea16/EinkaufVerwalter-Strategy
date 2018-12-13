package einkaufVerwalter.checkTester;

import einkaufVerwalter.check.IsGenauMenge;
import einkaufVerwalter.data.Einkauf;
import einkaufVerwalter.model.EinkaufModel;
import einkaufVerwalter.model.EinkaufSpaltenNamen;

public class StrategyTester {
    public static void main(String[] args) {
        try {
            EinkaufModel model = new EinkaufModel();
            
            // Context definieren
            model.setMengenStrategy(new IsGenauMenge());
            System.out.format("Strategy Tester\n***************\n%7s | %11s | %5s | %11s\n", 
                    EinkaufSpaltenNamen.ARTIKEL.getText(),
                    EinkaufSpaltenNamen.EINZELPREIS.getText(),
                    EinkaufSpaltenNamen.MENGE.getText(),
                    EinkaufSpaltenNamen.GESAMTPREIS.getText());
            for(Einkauf e : model.checkMenge()) {
                System.out.format("%7s | %11s | %5s | %11s\n", e.getArtikel(), 
                        e.getEinzelpreis()+"",e.getMenge()+"", e.getGesamtpreis()+"");
            }
        } catch(Exception e) {
            System.err.println("Main-Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
