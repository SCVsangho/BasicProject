package project.dao;

public interface UserCheck {
	
	/*아이디 체크 중복확인으로 인해 가입 제한*/
	public void checkedId();
	
	/*회원가입 실행*/
	public void addId();
	
	/*아이디 비밀번호 찾기*/
	public void findAcount();
	
	

}
