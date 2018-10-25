package project.service;

import project.dao.PayDao;
import project.dao.PayDaoImpl;

public class PayImpl implements Pay {

	PayDao pp = new PayDaoImpl();
			
	@Override
	public void pay() {
		boolean flag;
		
		
		
		flag = true;
	if(flag) {
		pp.receipt();
	}
	}

	@Override
	public void returnpay() {
		// TODO Auto-generated method stub

	}

}
