package Presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class presentationAvecSpringXml {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("configurationSpring.xml");

        IMetier metier= (IMetier) context.getBean("metier"); // recupere l'objet qui a l'id metier depuis le fichier configurationSpring.xml

        System.out.println(metier.calcul());
    }
}
