package project.dao;

import java.util.ArrayList;

import project.vo.Database;
import project.vo.MenuData;

public class MenuViewImpl implements MenuView {

	@Override
	public MenuData checkedMenu(String key, String value) { 
		for (int i = 0; i < Database.tb_menu.size(); i++) { 
			MenuData me = Database.tb_menu.get(i);			
			if (key.equals("name")) {						
				if (me.getMenuName().equals(value)) {		
					return me;
				}
			}
		}

		return null;
	}

	@Override
	public void removeMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertMenu(MenuData menu) {
		Database.tb_menu.add(menu);		
	}

	@Override
	public ArrayList<MenuData> menuList() {
		return Database.tb_menu;
	}

}
