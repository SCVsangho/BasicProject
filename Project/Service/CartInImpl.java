package project.service;

import java.util.Scanner;

import project.controller.Controller;
import project.dao.CartDao;
import project.dao.CartDaoImpl;
import project.vo.Database;

public class CartInImpl implements CartIn {

	@Override
	public void insertCart() {
		CartDao c1 = new CartDaoImpl();
		ViewMenu viewM = new ViewMenuImpl();

		System.out.println("******[[ 장바구니 담기 ]]******");

		viewM.viewMenu();
		boolean flag = false;

		while (!flag) {
			Scanner s = new Scanner(System.in);

			System.out.println("[[ 1.담기  ||  2.취소  ]]");
			String answer = s.nextLine();
			if (answer.equals("1")) {
				System.out.println("[[ 선택 : 번호입력  ||  종료 : 0번 입력 ]]");
				System.out.print("ANSWER >>");
				int selectMenu = s.nextInt();
				if (selectMenu == 0) {
					flag = true;
				} else {
					int indexValue = selectMenu - 1;
					System.out.println(Database.tb_menu.get(indexValue).getMenuName() + " (이)가 장바구니에 추가되었습니다.");
					PayImpl.indexValue.add(indexValue);
					c1.insertMenuToCart((int) indexValue);
				}
			} else {
				Controller.staratProgram();
			}
		}

	}

	@Override
	public void removeCart() {
		CartDao c1 = new CartDaoImpl();
		ViewMenu viewM = new ViewMenuImpl();
		Scanner s = new Scanner(System.in);

		System.out.println("[[ 1.삭제  ||  2.취소  ]]");
		String answer = s.nextLine();
		if (answer.equals("1")) {

			System.out.println("******[[ 장바구니 삭제 ]]******");

			viewM.viewMenu();
			boolean flag = false;

			while (!flag) {

				System.out.println("[[ 선택 : 번호입력  ||  종료 : 0번 입력 ]]");
				System.out.print("ANSWER >>");
				int selectMenu = s.nextInt();
				if (selectMenu == 0) {
					flag = true;
				} else {
					int indexValue = selectMenu - 1;
					System.out.println(Database.tb_cart.remove(indexValue) + " (이)가 장바구니에서 삭제되었습니다.");
				}
			}
	}else

	{
		Controller.staratProgram();
	}
}

	@Override
	public void cartPrint() {
		int resultP = 0;
		System.out.println("******[[ " + Database.loginUser.getId() + "님의 장바구니 ]]******");
		for (int i = 0; i < Database.tb_cart.size(); i++) {
			System.out.println("--((" + (i + 1) + "))-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("[메뉴이름]  : " + Database.tb_cart.get(i).getMenuName());
			System.out.println("[메뉴가격]  : " + Database.tb_cart.get(i).getMenuPrice());
			resultP += Database.tb_cart.get(i).getMenuPrice();

		}
		System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
		System.out.println("총 " + Database.tb_cart.size() + "개");
		System.out.println("전체 예정결제금액  : " + resultP + "원");

	}

}
