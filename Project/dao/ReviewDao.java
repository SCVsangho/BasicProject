package project.dao;

import project.vo.NoticeData;
import project.vo.ReviewData;

public interface ReviewDao {
	
	
	// 현재 시간을 생성 
	String createdTime();
	
	
	// 작성자를 현재 로그인 한 아이디로 강제 저장
	void saveAutor();
	
	// 작성할 수 있는 권한을 부여 => 로그인 시 작성 가능
	void writeRight();

	// 번호 자동 저장
	void autoNumberSet();
	
	//리뷰 데이터베이스에 저장
	void insertReview(ReviewData review);
	
}
