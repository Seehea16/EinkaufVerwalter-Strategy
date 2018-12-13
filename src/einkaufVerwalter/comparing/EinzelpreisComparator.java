package einkaufVerwalter.comparing;

import einkaufVerwalter.data.Einkauf;
import java.util.Comparator;

public class EinzelpreisComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if(((Einkauf)o1).getArtikel().equals(((Einkauf)o2).getArtikel())) {
            return -((Einkauf)o1).getEinzelpreis().compareTo(((Einkauf)o2).getEinzelpreis());
        } else {
            return ((Einkauf)o1).getArtikel().compareTo(((Einkauf)o2).getArtikel());
        }
    }
}
