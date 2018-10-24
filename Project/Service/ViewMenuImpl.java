package project.service;

import java.util.ArrayList;
import java.util.Scanner;

import project.dao.MenuView;
import project.dao.MenuViewImpl;
import project.vo.MenuData;

public class ViewMenuImpl implements ViewMenu {
	
	MenuView menuDao = new MenuViewImpl();
	
	@Override
	public void addMenu() {

		Scanner s = new Scanner(System.in);
		MenuData menu = new MenuData();

		System.out.print(" [Admin Mode] Add Menu Name : ");
		menu.setMenuName(s.nextLine());
		System.out.print(" [Admin Mode] Price Of This Menu : ");
		menu.setMenuPrice(s.nextInt());

		MenuData menuCheck = menuDao.checkedMenu("name", menu.getMenuName());
		if (menuCheck == null) {
			/* 메뉴 삽입 */
			menuDao.insertMenu(menu);
		} else {
			/* 메뉴 중복 */
			System.out.println("이미 존재하는 메뉴 입니다.");
		}
	}

	@Override
	public void viewMenu() {
		ArrayList<MenuData> menuList = menuDao.menuList();

		System.out.println("===============================================");
		for (MenuData menu : menuList) {
			System.out.println("Menu Name   : " + menu.getMenuName());
			System.out.println("Menu Price  : " + menu.getMenuPrice());
			System.out.println("===============================================");

		}

	}
}
