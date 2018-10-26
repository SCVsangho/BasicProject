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
		// TODO Auto-generated method stub

	}

	@Override
	public void cartPrint() {
		// TODO Auto-generated method stub

	}

}
