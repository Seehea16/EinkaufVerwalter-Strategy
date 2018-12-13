package einkaufVerwalter.model;

public enum EinkaufSpaltenNamen {
    ARTIKEL("Artikel"),
    EINZELPREIS("Einzelpreis"),
    MENGE("Menge"),
    GESAMTPREIS("Gesamtpreis");
    
    private String text;

    private EinkaufSpaltenNamen(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
