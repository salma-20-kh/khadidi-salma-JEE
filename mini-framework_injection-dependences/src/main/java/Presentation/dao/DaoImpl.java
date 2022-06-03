package Presentation.dao;

import framework.Annotations.Component;

@Component("dao") // le parametre dao c'est pour utiliser Qualifier("dao")
public class DaoImpl implements IDao {

    @Override
    public double getValue() {
        // TODO Auto-generated method stub
        System.out.println("Version Base de données");
        return 5;
    }

}
