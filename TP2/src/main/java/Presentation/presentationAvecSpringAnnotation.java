package Presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class presentationAvecSpringAnnotation {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("dao", "metier");// on doit préciser le nom des packages qui doit scanner
        // il va scanner les packages dao et metier
        IMetier metier = context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
