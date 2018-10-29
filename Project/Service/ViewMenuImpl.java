package project.service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import project.controller.Controller;
import project.dao.MenuView;
import project.dao.MenuViewImpl;
import project.dao.PayDaoImpl;
import project.vo.Database;
import project.vo.MenuData;

public class ViewMenuImpl implements ViewMenu {

	MenuView menuDao = new MenuViewImpl();

	@Override
	public void addMenu() {

		Scanner s = new Scanner(System.in);
		MenuData menu = new MenuData();

		System.out.println("[[ 1.추가  || 2.취소  ]]");
		String answer = s.nextLine();

		if (answer.equals("1")) {

			System.out.println("******[[ 추가 할 메뉴를 입력해주세요 ]]******");
			System.out.print(" [[ 메뉴 이름 ]] : ");
			menu.setMenuName(s.nextLine());
			System.out.print(" [[ 메뉴 가격 ]] : ");
			menu.setMenuPrice(s.nextInt());
			System.out.print(" [[ 메뉴 설명 ]] : ");
			menu.setContents(s.next());

			System.out.println();

			MenuData menuCheck = menuDao.checkedMenu("name", menu.getMenuName());
			if (menuCheck == null) {
				/* 메뉴 삽입 */

				menuDao.insertMenu(menu);
			} else {
				/* 메뉴 중복 */
				System.out.println("******[[ 이미 존재하는 메뉴 입니다.  ]]******");
			}
		} else {
			Controller.staratProgram();
		}
	}

	@Override
	public void viewMenu() {
		System.out.println("******[[  메뉴  ]]******");
		ArrayList<MenuData> menuList = menuDao.menuList();

		int i = 0;

		for (MenuData menu : menuList) {
			System.out.println("((" + (i + 1) + "))" + "~-~-~-~-~-~-~-~-~-~-");
			System.out.println("[이름]	: " + menu.getMenuName());
			System.out.println("[가격]	: " + menu.getMenuPrice());
			System.out.println("[설명]	: " + menu.getContents());
			System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
			i++;
		}

	}

	@Override
	public void removeMenu() {
		Scanner s = new Scanner(System.in);
//		ArrayList<NoticeData> tb_menu = new ArrayList<NoticeData>();
		System.out.println("[[ 1.삭제  ||  2.취소  ]]");
		String answer = s.nextLine();
		if (answer.equals("1")) {
			viewMenu();
			System.out.print("삭제할 메뉴 번호를 입력>> ");

			int delNo = s.nextInt();
			if (delNo <= Database.tb_menu.size()) {
				Database.tb_menu.remove(delNo - 1);
			} else {
				System.out.println("******[[  존재하지 않는 메뉴입니다.  ]]******");
			}
		} else {
			Controller.staratProgram();
		}
	}

	@Override
	public void viewBroughtList() {

		int receiptSize = Database.tb_cart.size();

		String[] txtMenu = new String[receiptSize];
		int[] txtPrice = new int[receiptSize];

		for (int i = 0; i < receiptSize; i++) {
			txtMenu[i] = Database.tb_cart.get(i).getMenuName();
			txtPrice[i] = Database.tb_cart.get(i).getMenuPrice();
		}

		System.out.println("******[[ 주 문 내 역  ]]******\n\n\n\n");
		System.out.println(" ***" + Database.loginUser.getName() + " 님이 결제하신 내역 입니다. ***\n\n\n");
		System.out.println("====================================\n\n");

		for (int i = 0; i < receiptSize; i++) {
			System.out.println("결제품목  : " + txtMenu[i] + "         " + txtPrice[i] + "\n");

		}
		System.out.println("====================================\n");
		System.out.println("------------결제금액  : " + PayDaoImpl.receiptPrice + "\n");
		System.out.println("====================================\n");
		;
		System.out.println("이름 : " + Database.loginUser.getName() + "\t");
		System.out.println("계정 : " + Database.loginUser.getId() + "\n");
		System.out.println("번호 : " + Database.loginUser.getTel() + "\n");

	}
}
