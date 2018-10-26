package project.dao;

import java.util.ArrayList;

import project.vo.UserData;

public interface UserCheck {
	
	/*아이디 체크 중복확인으로 인해 가입 제한*/
	public UserData checkedId(String key, String value);
	
	/*회원가입 실행*/
	public void addId(UserData person);
	
	/*아이디 비밀번호 찾기*/
	public void findAcount();
	
	public ArrayList<UserData> selectUser();

	

}
