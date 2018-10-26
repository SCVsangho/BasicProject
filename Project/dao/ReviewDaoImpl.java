package project.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import project.vo.Database;
import project.vo.NoticeData;
import project.vo.ReviewData;
import project.vo.UserData;

public class ReviewDaoImpl implements ReviewDao {

	@Override
	public String createdTime() {
		Date today = new Date();
		ReviewData t1 = new ReviewData();
		t1.setTimeS(today);

		return changedTime(today);

	}
	
	//지역 메서드
	private String changedTime(Date today) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return sdf.format(today);
	}

	@Override
	//로그인 한 아이디로 작성자 강제 저장
	public void saveAutor() {
		ReviewData loginId = new ReviewData();
		loginId.setAuthor(Database.loginUser.getId());       
//
//		UserData id = new UserData();
//		ReviewData loginId = new ReviewData();
//		
//		loginId.setAuthor(id.getId());
							
	}

	@Override
	public void writeRight() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void autoNumberSet() {
	
		ReviewData number = new ReviewData();
		for(int i = 0; i < Database.tb_review.size() + 1; i++){
			if( i < Database.tb_review.size()) {
				number.setNumber(i);
				System.out.println("번호가 추가되었습니다.");
		
			}
		}
	}
	
	@Override
	public void insertReview(ReviewData review) {
		Database.tb_review.add(review);
	}

}
