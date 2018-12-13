package einkaufVerwalter.check;

import einkaufVerwalter.data.Einkauf;
import java.util.List;

public interface MengenStrategy {
    public abstract List<Einkauf> check(Iterable<Einkauf> model);
}
