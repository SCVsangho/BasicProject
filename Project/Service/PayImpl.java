package project.service;

import java.util.ArrayList;
import java.util.Scanner;
import project.dao.PayDao;
import project.dao.PayDaoImpl;
import project.vo.Database;
import project.vo.MenuData;

public class PayImpl implements Pay {
	PayDao pp = new PayDaoImpl();
	MenuData menu = new MenuData();
	ArrayList<Integer> indexValue = new ArrayList<>();
	ArrayList<Integer> item = new ArrayList<>();

	int money;
	int[] sumPrice = new int[indexValue.size()];
	int resultPrice = 0;

	Scanner s = new Scanner(System.in);

	@Override
	public void pay() {

		for (int i = 0; i < Database.tb_cart.size(); i++) { // 장바구니 목록
			System.out.println(indexValue.get(i));
		}

		System.out.println("결제를 하시겠습니까?");
		System.out.println("네 [y], 아니요 [n]을 누르세요 ");
		String sc = s.nextLine();

		if (sc.equalsIgnoreCase("Y")) { // 결제 여부
			System.out.println("결제를 진행합니다.");

			System.out.println("돈을 지불해주세요 >> ");
			money = s.nextInt(); // 돈 입력

			if (money < menu.getMenuPrice()) { // 돈 지불
				System.out.println("돈이 부족합니다.");
				return;
			}

			for (int i = 0; i < indexValue.size(); i++) {
				sumPrice[i] = Database.tb_menu.get(indexValue.get(i))
						.getMenuPrice();
				resultPrice += sumPrice[i];
			}
			money -= resultPrice;// 메뉴 가격을 더한 값 뺸다.
			System.out.println("남은돈: " + money);

			item.addAll(indexValue);
			System.out.println(indexValue + "을 주문하셨습니다.");

			pp.receipt(); // 영수증 출력
		}

		else if(sc.equalsIgnoreCase("N")) {
			System.out.println("결제를 취소합니다.");

		}
	}

	@Override
	public void returnpay() { // 환불하기
		System.out.println("환불하시 겠습니까?");
		System.out.println("네 [y], 아니요 [n]을 누르세요 ");

		String sc = s.nextLine();

		if (sc.equalsIgnoreCase("Y")) { // 결제 여부
			System.out.println("환불해드리겠습니다.");

			for (int i = 0; i < indexValue.size(); i++) {
				if (item.remove(indexValue)) {
					money += resultPrice;// 메뉴 가격을 더한 값 뺸다.
					System.out.println(indexValue + "을/를  환불하였습니다.");
				} else {
					System.out.println("주문하신 음식이 없습니다.");
				}
			}
		} else if(sc.equalsIgnoreCase("N")) {
			System.out.println("취소합니다.");
		}
	}
}
