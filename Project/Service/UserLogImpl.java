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
		UserCheck userCheck = new UserCheckImpl();
		Scanner s = new Scanner(System.in);
		
		UserData person = new UserData();
		
		System.out.println("[-------회원가입 -------]");
		System.out.println("회원가입을 시작합니다.");
		
		// 이름 입력
		boolean flag = false;
		while (!flag) {

			System.out.print("이름 : ");
			String nameInput = s.nextLine();

			Pattern name = Pattern.compile("[\\w\\SW]{2,20}");
			Matcher nameCheck = name.matcher(nameInput);
			
			if (nameCheck.matches()) {
				System.out.println("이름이 정상적으로 입력되었습니다");
				person.setName(s.nextLine());
				flag = true;
				
			} else {
				System.out.println("이름 형식이 올바르지 않습니다. 다시 입력해주세요.");
//				 newJoin(); // 재귀호출  -> 사용 안함
			}
		}

		// 아이디, 비밀번호 입력
//		flag = false;
//		while(!flag){
//			
//			System.out.print("아이디  :  ");
//			String idInput = s.nextLine();
////			UserData userCheck = userCheck.checkedId("ID", person.getId());
//			
//			Pattern id = Pattern.compile("[a-zA-Z0-9]\\w{6,20}");
//			Matcher idcheck = id.matcher(idInput);
//			
//			if (idcheck.matches()) {		//중복검사
//				UserData usercheck = userCheck.checkedId("ID", person.getId());
//				if(userCheck == null){
//					
//					System.out.println("아이디가 정상적으로 입력되었습니다.");
//					person.setId(s.nextLine());
//					userCheck.addId(person);		// 수정필요 (오류나는 이유를 모르겠음)
//					flag = true;
//					
//				} else {
//					System.out.println("종복된 아이디입니다. 다시 입력해주세요");
//				}
//				
//			}
//		}
				
		flag = false;
		while(!flag){
					
			if (!flag) {
				
				System.out.print("비밀번호  :  ");
				String pswdInput = s.nextLine();
				Pattern pass = Pattern.compile("(?=.*[?@!%*?&])[a-zA-Z0-9!@#$%^&*()_+|]{8,20}");
				Matcher passCheck = pass.matcher(pswdInput);
				if (passCheck.matches()) {
					System.out.print("비밀번호 확인 :  ");
					String tmp = s.nextLine();
					if(pswdInput.equals(tmp)){
						System.out.println("비밀번호가가 정상적으로 입력되었습니다.");
						person.setPassWord(s.nextLine());
						flag = true;
					}
					
						
				} else {
					System.out.println("비밀번호 형식이 올바르지 않습니다. 다시 입력해주세요.");
				}
			}
		}
		
		

		// 주소 입력
		//(^[ㄱ-ㅎ가-힣]*$^[a-zA-Z]*$^[0-9]*$){10,50} >> 주소 정규식 원본(수정필요)
		flag = false;
		while(!flag){
			
			System.out.print("주소 : ");
			String addInput = s.nextLine();
			
			Pattern add1 = Pattern.compile("(?=.*[?@!%*?&])[a-zA-Z0-9!@#$%^&*()_+|]{8,20}");
			Matcher addCheck = add1.matcher(addInput);
			
			if (addCheck.matches()) {
				System.out.println("주소가 정상적으로 입력되었습니다.");
				person.setAddress(s.nextLine());
				flag = true;
				
			} else {
				System.out.println("주소 형식이 올바르지 않습니다. 다시 입력해주세요.");
			}
		}

		// 전화번호 입력
		flag = false;
		while(!flag){
			System.out.print("전화번호 : ");
			String telInput = s.nextLine();
			
			Pattern tel = Pattern.compile("0\\d{1,2}-\\d{3,4}-\\d{3,4}");
			Matcher telCheck = tel.matcher(telInput);
			if (telCheck.matches()) {
				System.out.println("전화번호 입력이 완료되었습니다.");
				person.setTel(s.nextLine());
				flag = true;
				
			} else {
				System.out.println("전화번호가 올바르지 않습니다. 다시 입력해주세요.");
			}
		}
		
		
		System.out.println("회원가입이 완료되었습니다.");
	
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

		System.out.println("[------- 로그인  -------]");

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

	@Override  //회원목록 삭제
	public void userListRemove() {
		System.out.println("[-------회원목록 삭제-------]");
		
	}
	}
