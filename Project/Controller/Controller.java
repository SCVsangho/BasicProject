package project.controller;

import java.util.Scanner;

import project.service.CartIn;
import project.service.CartInImpl;
import project.service.FindAcount;
import project.service.FindAcountImpl;
import project.service.Notice;
import project.service.NoticeImpl;
import project.service.Pay;
import project.service.PayImpl;
import project.service.Review;
import project.service.ReviewImpl;
import project.service.UserLogImpl;
import project.service.Userlog;
import project.service.ViewMenu;
import project.service.ViewMenuImpl;
import project.vo.Database;

public class Controller {

	public static void main(String[] args) {

		staratProgram();
	}

	public static void staratProgram() {
		
		FindAcount find = new FindAcountImpl();
		Notice notice = new NoticeImpl();
		Userlog userlog = new UserLogImpl();
		ViewMenu viewmenu = new ViewMenuImpl();
		Userlog user1og = new UserLogImpl();
		CartIn cartin = new CartInImpl();
		Review review = new ReviewImpl();
		Pay pay = new PayImpl();

		Scanner s = new Scanner(System.in);

		boolean isContinue = true;

		while (isContinue) {
			if (UserLogImpl.adminMode) {

				isContinue = true;

				while (isContinue) {

					System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
					System.out.println("【 Welcome To -JUSEYO- |ADMIN MODE| 】");
					System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
					System.out.println("1. |회원목록|");
					System.out.println("2. |회원삭제|");
					System.out.println("3. |메뉴추가|");
					System.out.println("4. |메뉴삭제|");
					System.out.println("5. |공지사항추가|");
					System.out.println("6. |공지사항삭제|");
					System.out.println("7. |리뷰보기|");
					System.out.println("8. |리뷰삭제|");
					System.out.println("9. |관리자모드 해제|");
					System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
					System.out.print(" [[ANSWER]]>>");

					int menu = s.nextInt();

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
						// 메뉴추가
						viewmenu.addMenu();
						break;
					case 4:
						// 메뉴삭제
						viewmenu.removeMenu();
						break;
					case 5:
						// 공지사항추가
						notice.addNotice();
						break;
					case 6:
						// 공지사항삭제
						notice.removeNotice();
						break;
					case 7:
						// 리뷰보기
						review.viewReview();
						break;
					case 8:
						// 리뷰삭제
						review.removeReview();
						break;
					case 9:
						// 관리자모드 해제
						userlog.outManagement();
						break;
					default:
						System.out.println("******[[ 프로그램이 종료되었습니다. ]]******");
						isContinue = false;
						break;

					}
				}
			} else {

				if (Database.loginUser == null) { // 초기화면

					System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
					System.out.println("【 Welcome To -JUSEYO- 】");
					System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
					System.out.println("1. |회원가입|");
					System.out.println("2. |로그인|");
					System.out.println("3. |아이디,비밀번호 찾기|");
					System.out.println("4. |메뉴보기|");
					System.out.println("5. |공지사항|");
					System.out.println("6. |리뷰|");
					System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
					System.out.print(" [[ANSWER]]>>");

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
						viewmenu.viewMenu();
						break;
					case 5:
						// 공지사항
						notice.viewNotice();
						break;
					case 6:
						// 리뷰
						review.viewReview();
						break;
					case 101100111:
						// 관리자모드
						UserLogImpl.adminMode = true;
						break;
					default:
						System.out.println("프로그램이 종료되었습니다.");
						isContinue = false;
						break;

					}

				} else if (Database.loginUser != null) { // 로그인 모드
					
					System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
					System.out.println("【 Welcome To -JUSEYO- 】 + |Login|" + Database.loginUser.getId());
					System.out.println("~~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
					System.out.println("1. |로그아웃|");
					System.out.println("2. |공지사항|");
					System.out.println("3. |메뉴보기|");
					System.out.println("4. |장바구니 담기|");
					System.out.println("5. |장바구니 삭제|");
					System.out.println("6. |장바구니 목록|");
					System.out.println("7. |리뷰 작성하기|");
					System.out.println("8. |리뷰|");
					System.out.println("9. |개인정보| ");
					System.out.println("10.|결제하기| ");
					System.out.println("11.|환불신청| ");
					System.out.println("12.|주문내역| ");
					System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
					System.out.print(" [[ANSWER]]>>");

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
					case 7:
						// 리뷰작성
						review.writeReview();
						break;
					case 8:
						// 리뷰보기
						review.viewReview();
						break;
					case 9:
						// 개인정보
						userlog.persnalinpo();
						break;
					case 10:
						// 결제하기
						pay.pay();
						break;
					case 11:
						// 환볼요청
						pay.returnpay();
						break;
					case 12:
						// 주문내역
						viewmenu.viewBroughtList();
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
}
