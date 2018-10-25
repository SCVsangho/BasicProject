package project.service;

public interface Userlog {
	
	//회원가입 [[created class 'NewJoinimpl']]
	public void newJoin();
		
	//로그인 [[created class 'LogInimpl']]
	public void login();
	
	//로그아웃 [[created class 'LogOutImpl']]
	public void logOut();
	
	//회원리스트 출력 [[created class 'UserListImpl']]
	public void userList();
	
	//회원리스트삭제
	public void userListRemove();
	
	//관리자모드 
	public void management();
	
	
}
