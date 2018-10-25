package project.service;

import java.util.ArrayList;
import java.util.Scanner;

import project.dao.UserCheck;
import project.dao.UserCheckImpl;
import project.vo.UserData;

public class UserLogImpl implements Userlog {
	Scanner s = new Scanner(System.in);

	@Override
	public void newJoin() {
		System.out.println("[-------회원가입 -------]");

		// 회원가입
		UserData user = new UserData();
		System.out.println("아이디 : ");
		user.setId(s.nextLine());
		System.out.println("비밀번호 : ");
		user.setPassWord(s.nextLine());
		System.out.println("이름 : ");
		user.setName(s.nextLine());
	}

	@Override
	public void login() {

		UserData user = new UserData();
		Notice notice = new NoticeImpl();
		Userlog user1og = new UserLogImpl();
		ViewMenu viewmenu = new ViewMenuImpl();
		cartin cartin = new cartinImpl();
		

		System.out.println("[------- 로그인  -------]");

		boolean menu = true;

		if (!user.setId == equals("admin")) {
			user1og.management();
		}

		while (menu) {
			System.out.println("1. 로그아웃");
			System.out.println("2. 공지사항");
			System.out.println("3. 메뉴보기");
			System.out.println("4. 장바구니");
			System.out.println("원하시는 메뉴 입력하세요.>");

			int click = s.nextInt();

			switch (click) {
			case 1:
				// 로그아웃
				user1og.logOut();
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
				cartin.insertCart();
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

	}

	@Override
	public void management() {
		System.out.println("[------관리자모드-------]");
		

		boolean isContinue = true;

		while (isContinue) {

			System.out.println("【--관리자모드-- 】");
			System.out.println("1. 회원목록");
			System.out.println("2. 회원삭제");
			System.out.println("3. 메뉴추가");
			System.out.println("4. 메뉴삭제");
			System.out.println("메뉴에 해당하는 번호 입력 >");

			int menu = s.nextInt();

			Userlog userlog = new UserLogImpl();
			ViewMenu viewmenu = new ViewMenuImpl();
			
				
			switch (menu) {
			case 1:
				// 회원목록
				userlog.userList();
				break;
			case 2:
				// 회원삭제
				userlog.userListRemove();
				break;		
			case 3:
				//메뉴추가
				viewmenu.addMenu();
				break;
			case 4:
				//메뉴삭제
				viewmenu.removeMenu();
				break;
			default:
				System.out.println("프로그램이 종료되었습니다.");
				isContinue = false;
				break;

		}
	}
	}

	@Override  //회원목록 삭제
	public void userListRemove() {
		System.out.println("[-------회원목록 삭제-------]");
		
	}
	}
