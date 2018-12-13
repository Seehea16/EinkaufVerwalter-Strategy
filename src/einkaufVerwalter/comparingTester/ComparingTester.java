package einkaufVerwalter.comparingTester;

import einkaufVerwalter.comparing.EinzelpreisComparator;
import einkaufVerwalter.data.Einkauf;
import einkaufVerwalter.model.EinkaufModel;
import java.util.Collections;

public class ComparingTester
{
  public static void main(String[] args)
  {
    EinkaufModel model = new EinkaufModel();       
    System.out.println("Comparing Tester\n"
                     + "***************");
    System.out.format("Natural: \n  %8s |%6s |%6s |%6s\n",
                    "Artikel","Einzelp.","Menge","Gesamtp.");
    for(Einkauf e : model.getListe()) {
        System.out.format("%8s | %6s | %6s | %6s\n", e.getArtikel(), 
                e.getEinzelpreis()+"",e.getMenge()+"", e.getGesamtpreis()+"");
    }
    
    System.out.format("Compare.Einzelp.: \n  %8s |%6s |%6s |%6s\n",
                    "Artikel","Einzelp.","Menge","Gesamtp.");
    Collections.sort(model.getListe(), new EinzelpreisComparator());
    for(Einkauf e : model.getListe()) {
        System.out.format("%8s | %6s | %6s | %6s\n", e.getArtikel(), 
                e.getEinzelpreis()+"",e.getMenge()+"", e.getGesamtpreis()+"");
    }
  }
}
