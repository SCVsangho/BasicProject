package project.service;

import java.util.Scanner;

import project.vo.Database;
import project.vo.MenuData;

public class CartInImpl implements CartIn {

	@Override
	public void insertCart() {
		ViewMenu viewM = new ViewMenuImpl();
		// 메뉴리스트 호출

		Scanner s = new Scanner(System.in);

		boolean flag = false;
		while (!flag) {
			System.out.println("메뉴를 선택해주세요.");
			viewM.viewMenu();
			String addMenu = s.nextLine();

			for (int i = 0; i < Database.tb_menu.size(); i++) {
				MenuData menu = Database.tb_cart.get(i);
				if (menu.equals(addMenu)) {

//					insertMenuToCart(); // 맞는지 모르겠어요. 메서드만 적혀있더라구요.
//					.set 필요?
					System.out.println("장바구니에 메뉴가 저장되었습니다.");

					System.out.println("메뉴선택을 계속 하시겠습니까?");
					System.out.println("계속하려면 [y], 그만하려면 [n]을 누르세요 ");
					String sc = s.nextLine();

					if (sc.equals("Y") || sc.equals("y")) {
						System.out.println("메뉴 선택을 계속합니다.");
						insertCart();

					} else {
//						insertMenuToCart(); //필요한지 모르겠어요. 저장이 한번 더 되는거같은데 좀 헷갈려요. 
//						.set 필요? 
						System.out.println("장바구니를 저장하고 종료합니다.");
						// insertMenuToCart();가 필요없으면 "장바구니를 종료합니다."
						flag = true;
					}

				} else {
					System.out.println("이 메뉴는 없는 메뉴입니다. 다시 입력해주세요.");
					insertCart();
				}

			}
			// 실행 돌리면 메뉴선택에서 입력값 받아도 안넘어갑니다.
			// if문에 문제가 있는거 같은데 파악이 안되서 수정 못하고 있습니다.
			// 학원가서 수정할게요.
		}

	}

	@Override
	public void removeCart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cartPrint() {
		// TODO Auto-generated method stub

	}

}
