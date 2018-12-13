package einkaufVerwalter.data;

public class Einkauf implements Comparable {
    private final Double menge, einzelpreis, gesamtpreis;
    private final String artikel;

    public Einkauf(String artikel, Double einzelpreis, Double menge) {
        this.menge = menge;
        this.einzelpreis = einzelpreis;
        this.artikel = artikel;
        this.gesamtpreis = this.calcGesamtpreis(einzelpreis, menge);
    }

    public Einkauf() {
        this.einzelpreis = 0.0;
        this.menge = 0.0;
        this.gesamtpreis = 0.0;
        this.artikel = "artikel";
    }

  @Override
  public String toString()
  {
    return String.format("%10s | %6.2f | %6.2f | %6.2f",
                artikel,
                einzelpreis,
                menge,
                gesamtpreis);
  }
/*** TODO PLF:
     * @param preis
     * @param menge
     * @return  **/
  public static Double calcGesamtpreis(Double preis, Double menge) {
      return preis * menge;
  }

    public Double getMenge() {
        return menge;
    }

    public Double getEinzelpreis() {
        return einzelpreis;
    }

    public String getArtikel() {
        return artikel;
    }

    public Double getGesamtpreis() {
        return gesamtpreis;
    }

    @Override
    public int compareTo(Object o) {
        if(this.artikel.equals(((Einkauf)o).artikel)) {
            return this.gesamtpreis.compareTo(((Einkauf)o).gesamtpreis);
        } else {
            return this.artikel.compareTo(((Einkauf)o).artikel);
        }
    }
}

