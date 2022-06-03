package Presentation.metier;

import Presentation.dao.IDao;
import Presentation.metier.IMetier;
import framework.Annotations.Autowired;
import framework.Annotations.Component;
import framework.Annotations.Qualifier;

@Component()
public class MetierImpl implements IMetier {

    // injection via Autowired
    @Autowired //pour recuperer l'objet de type DaoImpl

    @Qualifier("dao")//est utilié lorsu'on a plusieurs classes qui implementent la meme interface
    // le parametre dao dans Qualifier est le meme nom qu'on a dans Component("dao) de la clasee DaoImpl

    //@Qualifier("dao2")
    // le parametre dao2 dans Qualifier est le meme nom qu'on a dans Component("dao2) de la clasee DaoImpl2
    private IDao Dao;

    public MetierImpl() {
    }

    //injection via le constructeur
    public MetierImpl(IDao dao) {
        Dao = dao;
    }



    @Override
    public double calcul() {
        double nb = Dao.getValue();
        return 2 * nb;
    }

    public IDao getDao() {
        return Dao;
    }

    public void setDao(IDao dao) {
        this.Dao = dao;
    }


}
