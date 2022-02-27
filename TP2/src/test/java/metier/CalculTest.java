package metier;

import org.junit.Assert;
import org.junit.Test;

public class CalculTest {

    private calcul calcul;

    @Test // pour faite un test unitaire
    public void test(){
        calcul=new calcul();
        double a=5;
        double b=9;
        double res=calcul.somme(a,b);
        double expected=14;
        Assert.assertTrue(res==expected);
    }
}
