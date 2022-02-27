package metier;

import dao.IDao;

public class MetierImpl implements IMetier{
    private IDao dao;

    @Override
    public double calcul() {
        double nb=dao.getValue();
        return 2*nb;
    }

    public IDao getDao() {
        return dao;
    }
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
