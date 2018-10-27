package project.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import project.vo.Database;
import project.vo.ReviewData;

public class ReviewDaoImpl implements ReviewDao {
	public static ReviewData loginId = new ReviewData();
	
	
	@Override
	public String createdTime() { 
		Date today = new Date(); 
		ReviewData t1 = new ReviewData();
		t1.setTimeS(today);
		
		return changedTime(today);

	}

	// 지역 메서드
	private String changedTime(Date today) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return sdf.format(today);
	}

	@Override
	// 로그인 한 아이디로 작성자 강제 저장
	public String saveAutor() {
		if(Database.loginUser != null) {
			return (Database.loginUser.getId());
		} else {
			return "비회원";
		}
		
		
//		loginId.setAuthor(Database.loginUser.getId());
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
	public int autoNumberSet() {

		for (int i = 0; i < Database.tb_review.size() + 1; i++) {
			if (i < Database.tb_review.size()) {
				return (int)(i+1);

			}
		}
		return 0;
	}

	@Override
	public void insertReview(ReviewData review) {
		Database.tb_review.add(review);
	}

}