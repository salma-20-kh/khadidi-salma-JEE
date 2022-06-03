package Presentation;

import Presentation.metier.IMetier;
import framework.Injector;

import java.lang.reflect.InvocationTargetException;

public class presentationAvecSpringAnnotation {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Injector context = new Injector("services");
        IMetier metier= (IMetier) context.getObject();
        System.out.println(metier.calcul());
    }
}
