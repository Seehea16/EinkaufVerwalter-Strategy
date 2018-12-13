package einkaufVerwalter.check;

import einkaufVerwalter.data.Einkauf;
import java.util.ArrayList;
import java.util.List;

public class IsGenauMenge implements MengenStrategy {
    @Override
    public List<Einkauf> check(Iterable<Einkauf> model) {
        List<Einkauf> listNew = new ArrayList<>();
        for(Einkauf e : model) {
            Double menge = e.getMenge();
            Double nachkomma = menge - Math.floor(menge);
            if(nachkomma == 0) {
                listNew.add(e);
            }
        }
        return listNew;
    }
}
