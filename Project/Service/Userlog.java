package project.service;

public interface Userlog {
	
	//회원가입
	void join(); //추상메소드 
	
	//회원 전체 리스트 출력 
	void userList();//추상메소드 
	
	//로그인
	void login();
	
	//아이디 비번찾기
	void IdPass();
	
	//메뉴보기 
	void Menu();
	
	//공지사항
	void Notice();
}
