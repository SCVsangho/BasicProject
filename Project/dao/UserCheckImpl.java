package project.dao;

import java.util.ArrayList;
import java.util.Scanner;

import project.controller.Controller;
import project.vo.Database;
import project.vo.UserData;

public class UserCheckImpl implements UserCheck {

	@Override
	public UserData checkedId(String key, String value) {
		for (int i = 0; i < Database.tb_user.size(); i++) {
			UserData person = Database.tb_user.get(i);

			if (key.equals("ID")) {
				if (person.equals(value)) {
					return person;
				}

			}

		}
		return null;
	}

	@Override
	public void addId(UserData person) {
		Database.tb_user.add(person);

	}

	@Override
	public void findAcount() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<UserData> selectUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifiedPersnalInpo() {
		System.out.println("1. [주소 변경]");
		System.out.println("2. [전화번호 변경]");
		System.out.println("3. [나가기]");
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();

		switch (input) {
		case 1:
			// 주소변경
			Scanner s1 = new Scanner(System.in);

			System.out.println("변경 할 주소를 입력해주세요.");
			String changeAddress = s1.nextLine();

			System.out.println("입력하신 주소 [[ " + changeAddress + " ]] 로 변경하시겠습니까? ");
			System.out.println(" [[ Y. 변경  || N. 취소 ]]");
			System.out.print("입력해주세요. (Y/N) >>");
			String input2 = s1.nextLine();
			if (input2.equals("Y") || input2.equals("y")) {
				Database.loginUser.setAddress(changeAddress);
				System.out.println("주소 변경이 완료되었습니다.");
				Controller.staratProgram();
			} else {
				System.out.println("변경이 취소 되었습니다.");
				modifiedPersnalInpo();
			}
			break;
		case 2:
			// 핸드폰번호 변경
			Scanner s2 = new Scanner(System.in);

			System.out.println("변경 할 전화번호를 입력해주세요.");
			String changeTel = s2.nextLine();

			System.out.println("입력하신 전화번호 [[ " + changeTel + " ]] 로 변경하시겠습니까? ");
			System.out.println(" [[ Y. 변경  || N. 취소 ]]");
			System.out.print("입력해주세요. (Y/N) >>");
			String input3 = s2.nextLine();
			if (input3.equals("Y") || input3.equals("y")) {
				Database.loginUser.setTel(changeTel);
				System.out.println("전화번호 변경이 완료되었습니다.");
				Controller.staratProgram();
			} else {
				System.out.println("변경이 취소 되었습니다.");
				modifiedPersnalInpo();
			}
			break;
		case 3:
			// 나가기
			break;
		default:
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			modifiedPersnalInpo();
		}
	}

}
