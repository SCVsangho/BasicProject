package project.dao;

public interface CartDao {

	/*고객이 선택하는 ArrayList<MenuData>의 데이터 중 1개를 ArrayList Cart에 데이터 삽입 */
	public void insertMenuToCart(int index);
	
	/*고객이 선택하는 ArrayList<MenuData>의 데이터 중 1개를 ArrayList Cart에 데이터에서 삭제*/
	public void removeMenuToCart();
	
}
