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





public class Controller {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		boolean isContinue = true;

		while (isContinue) {

			System.out.println("【 메뉴를 선택해주세요 】");
			System.out.println("1. 회원가입");
			//System.out.println("2.회원목록");
			System.out.println("2. 로그인");
			System.out.println("3. 아이디,비밀번호 찾기");
			System.out.println("4. 메뉴보기");
			System.out.println("5. 공지사항");
			System.out.println("메뉴에 해당하는 번호 입력 >");

			int menu = s.nextInt();

			FindAcount find = new FindAcountImpl();
			Notice notice= new NoticeImpl();
			Userlog user = new UserLogImpl();
			ViewMenu viewmenu = new ViewMenuImpl();
			
			/*case 2:
			// 회원목록
			user.userList();
			break;*/
			
			
			switch (menu) {
			case 1:
				// 회원가입
				user.newJoin();
				break;
			case 2:
				// 로그인
				user.login();
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
