package project.vo;


public class MenuData {

	String menuName;
	int menuPrice;
	String contents;
	
	/*====================================================================================*/
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "메뉴이름  : " + menuName + "\n메뉴가격  : " + menuPrice;
	}

}
