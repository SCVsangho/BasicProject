package project.service;

import java.util.ArrayList;
import java.util.Scanner;

import project.dao.MenuView;
import project.dao.MenuViewImpl;
import project.vo.Database;
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
		System.out.println("<<MENU>>");
		ArrayList<MenuData> menuList = menuDao.menuList();

		int i = 0;

		for (MenuData menu : menuList) {
			System.out.println("[[" + (i + 1) + "]]" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Menu Name   : " + menu.getMenuName());
			System.out.println("Menu Price  : " + menu.getMenuPrice());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			i++;
		}

	}

	@Override
	public void removeMenu() {
		Scanner s = new Scanner(System.in);
//		ArrayList<NoticeData> tb_menu = new ArrayList<NoticeData>();

		viewMenu();
		System.out.print("삭제할 메뉴 번호를 입력>");

		int delNo = s.nextInt();
		if (delNo <= Database.tb_menu.size()) {
			Database.tb_menu.remove(delNo - 1);
		} else {
			System.out.println("존재하지 않는 메뉴입니다.");
		}
	}

}
