package project.service;

import java.util.Scanner;

import project.vo.Database;
import project.vo.MenuData;

public class CartInImpl implements CartIn {

	@Override
	public void insertCart() {
		CartDao c1 = new CartIDaoImpl();
		ViewMenu viewM = new ViewMenuImpl();

//		viewM.viewMenu(); 
		boolean flag = false;

		while (!flag) {
			Scanner s = new Scanner(System.in);
			System.out.println("[[ 선택 :번호입력  || 종료  :0번 입력 ]]");
			System.out.print("메뉴를 선택해주세요.");
			int selectMenu = s.nextInt(); 
			if (selectMenu == 0) {
				flag = true;
			} else {
				int indexValue = selectMenu - 1;
													
													
				// pay.indexValue.add(indexValue); 
				c1.insertMenuToCart(indexValue);
			}
		}

	}

	@Override
	public void removeCart() {
		
		Scanner s = new Scanner(System.in);

		cartPrint();
		System.out.print("삭제할 메뉴의 번호를 입력해주세요.");

		int cartDelNo = s.nextInt();
		if (cartDelNo <= Database.tb_cart.size()) {
			Database.tb_cart.remove(cartDelNo - 1);
		} else {
			System.out.println("존재하지 않는 메뉴입니다.");
		}

	}

	@Override
	public void cartPrint() {
		
		int sum = 0;
		
		for(int i = 0 ; i < Database.tb_cart.size(); i++){
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("매뉴  이름  :" + Database.tb_cart.get(i).getMenuName());
			System.out.println("매뉴  가격  :" + Database.tb_cart.get(i).getMenuPrice());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			sum += Database.tb_cart.get(i).getMenuPrice();
		}
		System.out.println("총 결제할 금액 :" + sum);

	}

}
