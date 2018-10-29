package project.service;

import java.util.ArrayList;
import java.util.Scanner;

import project.controller.Controller;
import project.dao.ReviewDao;
import project.dao.ReviewDaoImpl;
import project.vo.Database;
import project.vo.ReviewData;

public class ReviewImpl implements Review {
	ReviewDao reviewDao = new ReviewDaoImpl();

	@Override
	public void writeReview() {
		System.out.println("******[[ 리뷰 등록 ]]******");
		Scanner s = new Scanner(System.in);
		System.out.println("[[ 1.등록  ||  2.취소  ]]");
		String answer = s.nextLine();
		if (answer.equals("1")) {
		ReviewData review = new ReviewData();

		// 리뷰번호 저장
		reviewDao.autoNumberSet();
//		review.getNumber();
		// 제목
		System.out.print("[제목] : ");
		String title = s.nextLine();
		review.setTitle(title);

		// 내용 저장
		System.out.print("[내용] : ");
		String write = s.nextLine();
		review.setDescription(write);

		// 작성자 강제 등록!!
		review.setAuthor(reviewDao.saveAutor());

		// 일자 변환!!
		review.setTime(reviewDao.createdTime());

		// 저장한 데이터베이스(review)를 tb_review테이블에 저장
		reviewDao.insertReview(review);
		} else {
			Controller.staratProgram();
		}
	}

	@Override
	public void removeReview() {

		System.out.println("******[[ 리뷰 삭제 ]]******");
		Scanner s = new Scanner(System.in);

		viewReview();
		System.out.println("삭제할 번호 입력>> ");

		int delReview = s.nextInt();
		if (delReview < Database.tb_review.size()) {
			Database.tb_review.remove(delReview+1);
		} else {
			System.out.println("존재하지 않는 리뷰입니다.");
		}

	}

	@Override
	public void viewReview() {

//		ArrayList<ReviewData> ReviewList = new ArrayList<ReviewData>();
//		System.out.println("===============================================");
//		for (ReviewData review : ReviewList) {
		
		for(int i = 0 ; i < Database.tb_review.size(); i++) {
			ReviewData re = new ReviewData();
			System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
			System.out.println("[번호]   : " + (i+1));
			System.out.println("[제목]   : " + Database.tb_review.get(i).getTitle());
			System.out.println("[내용]   : " + Database.tb_review.get(i).getDescription());
			System.out.println("[작성자]  : " + Database.tb_review.get(i).getAuthor());
			System.out.println("[작성일]	: " + Database.tb_review.get(i).getTime());
			System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");

		}
	}

}