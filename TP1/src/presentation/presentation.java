package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class presentation {

    public static void main(String[] args) {
        try {

            Scanner scanner=new Scanner(new File("C:/Users/HP/Documents/S4/JEE/TP1/config.txt"));

            String daoClassName=scanner.next();
            String metierClassName=scanner.next();

            Class cdao=Class.forName(daoClassName);
            Class cmetier=Class.forName(metierClassName);

            IDao dao=(IDao) cdao.newInstance();
            IMetier metier=(IMetier) cmetier.newInstance();

            Method meth=cmetier.getMethod("setDao",IDao.class);
            meth.invoke(metier,dao);
            System.out.println(metier.calcul());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
