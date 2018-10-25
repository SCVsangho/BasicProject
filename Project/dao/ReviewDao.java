package project.dao;

public interface ReviewDao {
	
	
	// 현재 시간을 생성 
	void createdTime();
	
	
	// 작성자를 현재 로그인 한 아이디로 강제 저장
	void saveAutor();
	
	// 작성할 수 있는 권한을 부여 => 로그인 시 작성 가능
	void writeRight();
	
	
	

}
