package Presentation.dao;


import framework.Annotations.Component;

@Component("dao2")
public class DaoImpl2 implements IDao {
    @Override
    public double getValue() {

        System.out.println("Version Capteurs");
        return 6;
    }
}
