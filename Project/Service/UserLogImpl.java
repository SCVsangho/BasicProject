package project.service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import project.controller.Controller;
import project.dao.UserCheck;
import project.dao.UserCheckImpl;
import project.vo.Database;
import project.vo.UserData;

public class UserLogImpl implements Userlog {

	Scanner s = new Scanner(System.in);
	UserCheck userCheck = new UserCheckImpl();
	UserData person = new UserData();

	public static int admin = 101100111;
	public static boolean adminMode = false;

	@Override
	public void newJoin() {

		System.out.println("[-------회원가입 -------]");

		joinName();

		joinId();

		joinPass();

		joindAddress();

		joinTel();

		userCheck.addId(person);

		System.out.println(Database.tb_user.get(0));
	}

	private void joinTel() {
		System.out.print("전화번호 : ");
		String telInput = s.nextLine();
		Pattern telm = Pattern.compile("^[0-9]*$");

		Matcher telCheck = telm.matcher(telInput);
		if (telCheck.matches()) {
			System.out.println("전화번호 입력이 완료되었습니다.");
			person.setTel(telInput);
		} else {
			System.out.println("전화번호가 올바르지 않습니다. 다시 입력해주세요.");
			joinTel();
		}
	}

	private void joindAddress() {
		System.out.print("주소(도/시/구) : ");
		String addInput = s.nextLine();
		System.out.print("상세주소 : ");
		String addInput2 = s.nextLine();

		System.out.println("[[!![주소가 정확하지 않으면 Delivery System에 불이익을 받을 수 있습니다]!!]]");
		System.out.println("입력하신 주소가 [" + addInput + " " + addInput2 + "] 가 맞으십니까?");
		System.out.println("네 맞습니다[[Y]] ||  다시 입력할게요[[N]]");
		String sc = s.nextLine();

		if (sc.equals("Y") || sc.equals("y")) {
			System.out.println("주소가 정상적으로 입력되었습니다.");
			person.setAddress(addInput + " " + addInput2);
		} else {
			joindAddress();
		}
	}

	private void joinPass() {
		/* 비밀번호 등록 */
		System.out.print("비밀번호  :  ");
		String pswdInput = s.nextLine();
		Pattern pass = Pattern.compile("(?=.*[?@!%*?&])[a-zA-Z0-9!@#$%^&*()_+|]{8,20}");
		Matcher passCheck = pass.matcher(pswdInput);
		if (passCheck.matches()) {
			System.out.print("비밀번호 확인 :  ");
			String tmp = s.nextLine();
			if (pswdInput.equals(tmp)) {
				System.out.println("비밀번호가가 정상적으로 입력되었습니다.");
				person.setPassWord(pswdInput);
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
				joinPass();
			}

		} else {
			System.out.println("비밀번호 형식이 올바르지 않습니다. 다시 입력해주세요.");
			joinPass();
		}
	}

	private void joinId() {
		System.out.print("아이디  :  ");
		String idInput = s.nextLine();

		Pattern id = Pattern.compile("^[a-zA-Z0-9]*${6,20}");
		Matcher idcheck = id.matcher(idInput);

		if (idcheck.matches()) { // 중복검사
			UserData userCh = userCheck.checkedId("ID", person.getId());
			if (userCh == null) {
				person.setId(idInput);
				System.out.println("아이디가 정상적으로 입력되었습니다.");
			} else {
				System.out.println("종복된 아이디입니다. 다시 입력해주세요");
				joinId();
			}
		}

	}

	private void joinName() {
		/* 이름 등록 */
		System.out.print("이름 : ");
		String nameInput = s.nextLine();

		Pattern name = Pattern.compile("[\\w\\SW]{2,20}");
		Matcher nameCheck = name.matcher(nameInput);

		if (nameCheck.matches()) {
			System.out.println("이름이 정상적으로 입력되었습니다");
			person.setName(nameInput);
		} else {
			System.out.println("이름 형식이 올바르지 않습니다. 다시 입력해주세요.");
			joinName();
		}
	}

	@Override
	public void login() {

		System.out.print("ID : ");
		String id = s.nextLine();
		System.out.print("Password : ");
		String password = s.nextLine();

			for (int i = 0; i < Database.tb_user.size(); i++) {
				UserData user1 = Database.tb_user.get(i);

				if (user1.getId().equals(id)) {
					if (user1.getPassWord().equals(password)) {
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("[System] 로그인 되었습니다.");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						Database.loginUser = user1;
					} else {
						System.out.println("[Err!!]로그인 정보가 올바르지 않습니다.");
					}
				}
			}
		}

	@Override
	public void logOut() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("[System] 로그아웃 되었습니다.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Database.loginUser = null;
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

	@Override
	public void userListRemove() {
		System.out.println("[-------회원목록 삭제-------]");

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
				// 메뉴추가
				viewmenu.addMenu();
				break;
			case 4:
				// 메뉴삭제
				viewmenu.removeMenu();
				break;
			default:
				System.out.println("프로그램이 종료되었습니다.");
				isContinue = false;
				break;

			}
		}
	}

	@Override
	public void outManagement() {
		Database.loginUser = null;
		adminMode = false;
		Controller.staratProgram();

	}
}
