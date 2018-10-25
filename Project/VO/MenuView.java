package project.dao;

import java.util.ArrayList;

import project.vo.MenuData;

public interface MenuView {
	
	
	/*중복값이 있는지 없는지 확인*/
	MenuData checkedMenu(String key, String value);
	
	/*중복값이 없다면 ArrayList<MenuData>에 데이터 삽입*/
	void insertMenu(MenuData menu);
	
	/*ArrayList<MenuData>에 등록된 매뉴 삭제*/
	void removeMenu();
	
	public ArrayList<MenuData> menuList();	

}
