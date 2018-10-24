package project.service;

import java.util.ArrayList;
import java.util.Scanner;

import project.dao.UserCheck;
import project.dao.UserCheckImpl;
import project.vo.UserData;

public class UserLogImpl implements Userlog {

	UserCheck userCheck = new UserCheckImpl();

	@Override
	public void newJoin() {
		System.out.println("[-------회원가입 -------]");
	}

	@Override
	public void login() {
		FindAcount find = new FindAcountImpl();
		Notice notice = new NoticeImpl();
		Userlog user = new UserLogImpl();
		ViewMenu viewmenu = new ViewMenuImpl();

		Scanner s1 = new Scanner(System.in);

		System.out.println("[------- 로그인  -------]");
		
		//if()
		
		
		boolean want = true;

		while (want) {
			System.out.println("1. 로그아웃");
			System.out.println("2. 공지사항");
			System.out.println("3. 메뉴보기");
			System.out.println("4. 장바구니");
			System.out.println("원하시는 메뉴 입력하세요.>");

			int click = s1.nextInt();

			switch (click) {
			case 1:
				// 로그아웃
				user.logOut();
				break;
			case 2:
				// 공지사항
				notice.viewNotice();
				break;
			case 3:
				// 메뉴보기
				viewmenu.viewMenu();
				break;
			case 4:
				// 장바구니
				user.logOut();
				break;
			}
		}

	}

	@Override
	public void logOut() {
		System.out.println("[-------로그아웃 되었습니다-------]");
	}

	@Override
	public void userList() {
		System.out.println("[-------회원목록 -------]");
		ArrayList<UserData> userList = userCheck.selectUser();

		System.out.println("====================================");
		for (UserData user : userList) {
			System.out.println("ID  : " + user.getId());
			System.out.println("name  : " + user.getName());
			System.out.println("====================================");
		}

	}
}
