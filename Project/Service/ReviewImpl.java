package project.service;

import java.util.ArrayList;
import java.util.Scanner;

import project.dao.ReviewDao;
import project.dao.ReviewDaoImpl;
import project.vo.Database;
import project.vo.ReviewData;

public class ReviewImpl implements Review{
	ReviewDao reviewDao = new ReviewDaoImpl();

	@Override
	public void writeReview() {
		System.out.println("[---------리뷰 등록----------]");
		Scanner s = new Scanner(System.in);
		ReviewData review = new ReviewData();
		

		//리뷰번호 저장
		reviewDao.autoNumberSet();
//		review.getNumber();

		//내용 저장
		System.out.println("내용 : ");
		String write = s.nextLine();
		review.setDescription(write);
		
		//작성자 강제 등록!!
		reviewDao.saveAutor();
	
		//일자 변환!!
		review.setTime(reviewDao.createdTime());
		
		//저장한 데이터베이스(review)를 tb_review테이블에 저장
		reviewDao.insertReview(review);
	}

	@Override
	public void removeReview() {
		
		System.out.println("[--------리뷰 삭제-------]");
		Scanner s = new Scanner(System.in);
		
		viewReview();
		System.out.println("삭제할 번호 입력>");
		
		int delReview = s.nextInt();
		if(delReview <= Database.tb_review.size()){
			Database.tb_review.remove(delReview);
		}else {
			System.out.println("존재하지 않는 리뷰입니다.");
		}
		
	}

	@Override
	public void viewReview() {
		
	ArrayList<ReviewData> ReviewList = new ArrayList<ReviewData>();
		System.out.println("===============================================");
		for (ReviewData review : ReviewList) {
			System.out.println("리뷰 번호  : " + review.getNumber());
			System.out.println("리뷰 내용   : " + review.getDescription());
			System.out.println("작성자  : " + review.getAuthor());
			System.out.println("작성일 : " + review.getTime());
			System.out.println("===============================================");
		
			/*int number;
			String description;
			String author;		 // 현재 로그인 된 아이디를 강제로 저장
			String time;		// 작성 시 yyyy.MM.dd : hh.mm
			Date timeS; */
	}
	}

}
