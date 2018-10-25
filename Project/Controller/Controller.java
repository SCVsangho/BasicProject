package Controller;

import java.util.Scanner;

import Service.FindAcount;
import Service.FindAcountImpl;
import Service.Notice;
import Service.NoticeImpl;
import Service.UserLogImpl;
import Service.Userlog;
import Service.ViewMenu;
import Service.ViewMenuImpl;
import Service.cartin;
import Service.cartinImpl;
import VO.Database;

public class Controller {

	public static void main(String[] args) {

		FindAcount find = new FindAcountImpl();
		Notice notice = new NoticeImpl();
		Userlog userlog = new UserLogImpl();
		ViewMenu viewmenu = new ViewMenuImpl();
		Userlog user1og = new UserLogImpl();
		cartin cartin = new cartinImpl();

		Scanner s = new Scanner(System.in);

		boolean isContinue = true;

		while (isContinue) {
			if (Database.loginUser == null) { //초기화면

				System.out.println("【   메뉴를 선택해주세요   】");  
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("3. 아이디,비밀번호 찾기");
				System.out.println("4. 메뉴보기");
				System.out.println("5. 공지사항");
				System.out.println("메뉴에 해당하는 번호 입력 >>");

				int menu = s.nextInt();

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
					// 아이디, 비밀번호 찾기
					find.findAcount();
					break;
				case 4:
					// 메뉴보기
					viewmenu.addMenu();
					break;
				case 5:
					// 공지사항
					notice.viewNotice();
					break;
				default:
					System.out.println("프로그램이 종료되었습니다.");
					isContinue = false;
					break;

				}

			}

			else if (Database.loginUser != null) { //로그인 모

				System.out.println("1. 로그아웃");
				System.out.println("2. 공지사항");
				System.out.println("3. 메뉴보기");
				System.out.println("4. 장바구니 담기");
				System.out.println("5. 장바구니 삭제");
				System.out.println("6. 장바구니 목록 ");			
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
					// 장바구니 담기
					cartin.insertCart();
					break;
				case 5:
					// 장바구니 삭제 
					cartin.removeCart();
					break;
				case 6:
					// 장바구니 목록
					cartin.cartPrint();
					break;
				default:
					System.out.println("프로그램이 종료되었습니다.");
					isContinue = false;
					break;
				}
			}
		}
	}
}
