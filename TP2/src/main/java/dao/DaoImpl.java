package dao;

import org.springframework.stereotype.Component;

@Component("dao") // le parametre dao c'est pour utiliser Qualifier("dao")
public class DaoImpl implements IDao{

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 5;
	}

}
