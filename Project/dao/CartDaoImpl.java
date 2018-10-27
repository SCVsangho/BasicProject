package project.dao;


import java.util.ArrayList;

import project.vo.Database;

public class CartDaoImpl implements CartDao{
	@Override
	public void insertMenuToCart(int index) {
		Database.tb_cart.add(Database.tb_menu.get(index));
		
		
		
		
	}

	@Override
	public void removeMenuToCart() {
		// TODO Auto-generated method stub
		
	}

}
