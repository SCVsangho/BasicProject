package project.dao;

public class CartImpl implements Cart{

	@Override
	public void insertMenuToCart() {
		Database.tb_cart.add(Database.tb_menu.get(index));
	}

	@Override
	public void removeMenuToCart() {
		// TODO Auto-generated method stub
		
	}

}
