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

		System.out.println("******[[ 회원가입 ]]******");

		joinName();

		joinId();

		joinPass();

		joindAddress();

		joinTel();

		userCheck.addId(person);

		person = new UserData();

	}

	private void joinTel() {
		System.out.println(" [ - ] 을 제외한 숫자로만 입력해주세요.");
		System.out.println();
		System.out.print("[전화번호] : ");
		String telInput = s.nextLine();
		Pattern telm = Pattern.compile("^[0-9]*$");

		Matcher telCheck = telm.matcher(telInput);
		if (telCheck.matches()) {
			System.out.println("전화번호 입력이 완료되었습니다.");
			System.out.println();
			person.setTel(telInput);
		} else {
			System.out.println("전화번호가 올바르지 않습니다. 다시 입력해주세요.");
			joinTel();
		}
	}

	private void joindAddress() {
		System.out.print("[주소(도/시/구)] : ");
		String addInput = s.nextLine();
		System.out.print("[상세주소] : ");
		String addInput2 = s.nextLine();

		System.out.println("******[[ 주소가 정확하지 않으면 Delivery System에 불이익을 받을 수 있습니다 ]]******");
		System.out.println("******[[입력하신 주소가 [" + addInput + " " + addInput2 + "] 가 맞으십니까?");
		System.out.println("[[ Y. 입력완료  ||  N. 입력취소 ]]");
		String sc = s.nextLine();

		if (sc.equals("Y") || sc.equals("y")) {
			System.out.println();
			System.out.println("주소가 정상적으로 입력되었습니다.");
			person.setAddress(addInput + " " + addInput2);
			System.out.println();
		} else {
			joindAddress();
		}
	}

	private void joinPass() {
		/* 비밀번호 등록 */
		System.out.println("******[[  최소 8글자 이상, 특수문자를 1개 이상 필수로 기재하세요.  ]]******");
		System.out.print("[비밀번호]  :  ");
		String pswdInput = s.nextLine();
		Pattern pass = Pattern.compile("(?=.*[?@!%*?&])[a-zA-Z0-9!@#$%^&*()_+|.,]{8,20}");
		Matcher passCheck = pass.matcher(pswdInput);
		if (passCheck.matches()) {
			System.out.println("******[[  동일한 비밀번호를 입력해주세요.  ]]******");
			System.out.print("[비밀번호 확인] :  ");
			String tmp = s.nextLine();
			if (pswdInput.equals(tmp)) {
				System.out.println("비밀번호가가 정상적으로 입력되었습니다.");
				person.setPassWord(pswdInput);
				System.out.println();
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
		System.out.println("******[[  특수문자를 제외한 영문과 숫자, 6자리 이상으로 생성해주세요.  ]]******");
		System.out.print("[아이디]  :  ");
		String idInput = s.nextLine();

		Pattern id = Pattern.compile("^[a-zA-Z0-9]*${6,20}");
		Matcher idcheck = id.matcher(idInput);

		if (idcheck.matches()) { // 중복검사
			UserData userCh = userCheck.checkedId("ID", idInput);
			if (userCh == null) {
				person.setId(idInput);
				System.out.println("아이디가 정상적으로 입력되었습니다.");
				System.out.println();
			}
		} else {
			System.out.println("종복된 아이디입니다. 다시 입력해주세요");
			joinId();
		}
	}

	private void joinName() {
		/* 이름 등록 */
		System.out.print("[이름] : ");
		String nameInput = s.nextLine();

		Pattern name = Pattern.compile("[\\w\\SW]{2,20}");
		Matcher nameCheck = name.matcher(nameInput);

		if (nameCheck.matches()) {
			System.out.println("이름이 정상적으로 입력되었습니다");
			person.setName(nameInput);
			System.out.println();
		} else {
			System.out.println("이름 형식이 올바르지 않습니다. 다시 입력해주세요.");
			joinName();
		}
	}

	@Override
	public void login() {

		System.out.print("[   ID   ] : ");
		String id = s.nextLine();
		System.out.print("[Password] : ");
		String password = s.nextLine();

		for (int i = 0; i < Database.tb_user.size(); i++) {

			if (Database.tb_user.get(i).getId().equals(id)) {
				if (Database.tb_user.get(i).getPassWord().equals(password)) {
					Database.loginUser = Database.tb_user.get(i);
					System.out.println("******[[ 환영합니다" + Database.loginUser.getId() + "님 ]]******");
					break;
					
				}

			}else {
				System.out.println("******[[  로그인 정보가 올바르지 않습니다.  ]]******");
			}

		}
		
	}

	@Override
	public void logOut() {
		System.out.println("******[[  로그아웃 되었습니다.  ]]******");
		Database.loginUser = null;
		for (int i = 0; i < Database.tb_cart.size();) {

			Database.tb_cart.remove(i);
		}
	}

	@Override
	public void userList() {
		System.out.println("******[[  회원목록  ]]******");

		UserData user = new UserData();

		System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
		for (int i = 0; i < Database.tb_user.size(); i++) {
			user = Database.tb_user.get(i);
			System.out.println("[No]    : " + (i + 1));
			System.out.println("[ID]    : " + user.getId());
			System.out.println("[name]  : " + user.getName());
			System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
		}
	}

	@Override
	public void userListRemove() {
		System.out.println("******[[  회원삭제/탈퇴  ]]******");
		System.out.println();
		Scanner s = new Scanner(System.in);
		Userlog userlog = new UserLogImpl();

		userlog.userList();
		System.out.print("삭제할 회원 번호를 입력>> ");

		int delUser = s.nextInt();
		if (delUser <= Database.tb_user.size()) {
			Database.tb_user.remove(delUser - 1);
			System.out.println("******[[  " + delUser + "번 회원 삭제 완료  ]]******");
		} else {
			System.out.println("******[[  존재하지 않는 회원입니다.  ]]******");
		}
	}

	@Override
	public void management() {
		System.out.println("******[[  관리자모드  ]]******");

		boolean isContinue = true;

		while (isContinue) {

			System.out.println("1. |회원목록|");
			System.out.println("2. |회원삭제|");
			System.out.println("3. |메뉴추가|");
			System.out.println("4. |메뉴삭제|");
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

	@Override
	public void persnalinpo() {
		System.out.println("******[[  개인정보  ]]******");
		System.out.println(" [이름]		: " + Database.loginUser.getName());
		System.out.println(" [ID] 		: " + Database.loginUser.getId());
		System.out.println(" [TEL]		: " + Database.loginUser.getTel());
		System.out.println(" [ADDRESS]	: " + Database.loginUser.getAddress());
		System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
		System.out.println("[[ 1. 개인정보 수정  ||  2.나가기 ]]");
		System.out.print("메뉴 입력 >>");
		int input = s.nextInt();
		switch (input) {
		case 1:
			userCheck.modifiedPersnalInpo();
			break;
		case 2:
			Controller.staratProgram();
		}
	}
}
