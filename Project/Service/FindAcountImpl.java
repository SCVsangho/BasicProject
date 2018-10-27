package project.service;

import java.util.Scanner;

import project.controller.Controller;
import project.vo.Database;
import project.vo.UserData;

public class FindAcountImpl implements FindAcount {

	@Override
	public void findAcount() {
		String name;
		String id;
		String tel;

		boolean flag = false;

		Scanner s = new Scanner(System.in);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("[[ 1. 아이디 찾기  ||  2. 비밀번호 찾기  ||  0. 나가기]]");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("ANSWER >>");

		String sc = s.nextLine();

		if (sc.equals("1")) {

			while (!flag) { // 아이디 찾기
				System.out.println("이름 입력 : ");
				name = s.nextLine();
				System.out.println("전화번호 입력 : ");
				tel = s.nextLine();

				for (int i = 0; i < Database.tb_user.size(); i++) {
					UserData user = Database.tb_user.get(i);
					if (user.getName().equals(name) && user.getTel().equals(tel)) {
						System.out.println("아이디 : " + user.getId());
						flag = true;
					} else {
						System.out.println("등록되지 않은 정보입니다.");
					}
				}
			}
		} else if (sc.equals("2")) {

			// 비밀번호 찾기
			while (!flag) {
				System.out.println("이름 입력 : ");
				name = s.nextLine();
				System.out.println("아이디 입력 : ");
				id = s.nextLine();
				System.out.println("전화번호 입력 : ");
				tel = s.nextLine();

				for (int i = 0; i < Database.tb_user.size(); i++) {
					UserData user = Database.tb_user.get(i);
					if (user.getName().equals(name) && user.getId().equals(id) && user.getTel().equals(tel)) {
						System.out.println("패스워드 : " + user.getPassWord());
						flag = true;
					} else {
						System.out.println("등록되지 않은 정보입니다.");
					}
				}

			}
		}
		 else if (sc.equals("0")) {
			 Controller.staratProgram();
			 
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

		}

	}
}
