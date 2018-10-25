package project.controller;

import java.util.Scanner;

import project.service.FindAcount;
import project.service.FindAcountImpl;
import project.service.Notice;
import project.service.NoticeImpl;
import project.service.UserLogImpl;
import project.service.Userlog;
import project.service.ViewMenu;
import project.service.ViewMenuImpl;

public class Controller {

	
		boolean isContinue = true;

		while (isContinue) {

			System.out.println("【 메뉴를 선택해주세요 】");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 아이디,비밀번호 찾기");
			System.out.println("4. 메뉴보기");
			System.out.println("5. 공지사항");
			System.out.println("메뉴에 해당하는 번호 입력 >");

			int menu = s.nextInt();

			FindAcount find = new FindAcountImpl();
			Notice notice= new NoticeImpl();
			Userlog userlog = new UserLogImpl();
			ViewMenu viewmenu = new ViewMenuImpl();
				
			switch (menu) {
			case 1:
				// 회원가입
				userlog.newJoin();
				break;
			case 2:
				// 로그인
				userlog.login();
				break;		
			case 3:
				//아이디, 비밀번호 찾기
				find.findAcount();
				break;
			case 4:
				//메뉴보기
				viewmenu.addMenu();
				break;
			case 5:
				// 공지사항
				notice.notice();
				break;
			default:
				System.out.println("프로그램이 종료되었습니다.");
				isContinue = false;
				break;

			}

		}
		
	}
}
