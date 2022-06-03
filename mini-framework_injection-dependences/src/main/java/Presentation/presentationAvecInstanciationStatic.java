package Presentation;

import Presentation.dao.DaoImpl;
import Presentation.metier.MetierImpl;

public class presentationAvecInstanciationStatic {
    public static void main(String[] args) {
        DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl();
        metier.setDao(dao);
        System.out.println(metier.calcul());
    }
}
