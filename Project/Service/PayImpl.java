package project.service;

import java.util.ArrayList;
import java.util.Scanner;

import project.controller.Controller;
import project.dao.PayDao;
import project.dao.PayDaoImpl;
import project.vo.Database;
import project.vo.Item;
import project.vo.MenuData;

public class PayImpl implements Pay {

	public static ArrayList<Integer> indexValue = new ArrayList<>();
	
	int money;
	public int resultPrice = 0;
	boolean checkMoney = false;
	Scanner s = new Scanner(System.in);

	@Override
	public void pay() {

		PayDao pp = new PayDaoImpl();
		MenuData menu = new MenuData();
		resultPrice = 0;
		checkMoney = false;
	
		for (int i = 0; i < Database.tb_cart.size(); i++) { // 장바구니 목록
			int index = indexValue.get(i);
			System.out.println(Database.tb_cart.get(indexValue.get(index)).getMenuName());
			System.out.println(Database.tb_cart.get(indexValue.get(index)).getMenuPrice());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		
		int cartSize = Database.tb_cart.size();
		
		for (int i = 0; i < cartSize; i++) {
			int indexint = indexValue.get(i);
			this.resultPrice += Database.tb_menu.get(indexint).getMenuPrice();
		}
		System.out.println("******[[  총 결제금액 : " + resultPrice + "원 입니다. ]]******");

		Scanner sc = new Scanner(System.in);
		System.out.println("결제를 하시겠습니까?");
		System.out.println("[[ Y. 결제  ||  N.취소 ]]");
		String inputSc = s.nextLine();

		if (inputSc.equalsIgnoreCase("Y")) { // 결제 여부
			System.out.println("결제를 진행합니다.");

			System.out.print(" 받은 금액 입력 >> ");
			money = sc.nextInt(); // 돈 입력
			checkMoney = this.money < this.resultPrice;
		} else {
			System.out.println("결제를 취소합니다.");
			Controller.staratProgram();
		}

		if (checkMoney)

		{ // 돈이 적으면 //true
			System.out.println("돈이 부족합니다.");

		} else { // 돈이 많으면 false
			this.money -= this.resultPrice;// 메뉴 가격을 더한 값 뺸다.
			System.out.println("거스름 돈 : " + money);

			for (int i = 0; i < indexValue.size(); i++) { // 주문내역에 결제한 내용을 추가
				int indexint = indexValue.get(i);
				
				Database.item.add(Database.tb_cart.get(indexint).getMenuName());
				
			}
			PayDaoImpl.receiptPrice = this.resultPrice;
			pp.receipt();

			for (int i = 0; i < Database.tb_cart.size();) {
				Database.tb_cart.remove(i); //
			}

		}

	}
	@Override
	public void returnpay() { // 환불하기
		
		Database dd = new Database();
		System.out.println("환불하시 겠습니까?");
		System.out.println("[[ Y. 결제  ||  N.취소 ]]");

		String sc = s.nextLine();

		if (sc.equalsIgnoreCase("Y")) { // 결제 여부
			System.out.println("******[[ 결제취소 ]]******");

			for (int i = 0; i < indexValue.size(); i++) {

				if (! Database.item.get(i).equals(null)) {
					money += resultPrice;// 메뉴 가격을 더한 값 뺸다.
					System.out.println(Database.item.get(i) + "을/를  환불하였습니다.");
						Database.tb_cart = new ArrayList<>();

				} else {
					System.out.println("주문하신 내역이 없습니다.");
					break;
				}
			}

		} else if (sc.equalsIgnoreCase("N")) {
			System.out.println("환불을 취소합니다.");
			Controller.staratProgram();
		}
		Controller.staratProgram();
	}
}
