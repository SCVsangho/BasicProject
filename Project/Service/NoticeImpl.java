package project.service;

import java.util.ArrayList;
import java.util.Scanner;

import project.dao.NoticeAbill;
import project.dao.NoticeAbillImpl;
import project.vo.Database;
import project.vo.NoticeData;

public class NoticeImpl implements Notice {

	NoticeAbill noticeDao = new NoticeAbillImpl();
	NoticeData no = new NoticeData();

	@Override
	public void addNotice() {
		NoticeAbill na = new NoticeAbillImpl();
		Scanner sc = new Scanner(System.in);

		/* 데이터베이스에 공지사항 정보를 등록 */
		// 번호 등록

		// 제목 등록
		System.out.print("[공지사항 제목 등록] 제목 : ");
		String title = sc.nextLine();
		no.setTitle(title);

		// 내용 등록
		System.out.print("[공지사항 내용 등록] : ");
		String description = sc.nextLine();
		no.setDescription(description);

		// 저자 등록
		String author = "[[ADMIN]]";
		no.setAuthor(author);

		// 현재 시간 등록
		no.setTime(na.createdTime());

		/* 저장한 데이터베이스(no)를 tb_notice테이블에 저장 */
		na.insertNotice(no);

	}

	@Override
	public void removeNotice() {
		Scanner sc = new Scanner(System.in);
		ArrayList<NoticeData> tb_notice = new ArrayList<NoticeData>();
		
		viewNotice();
		System.out.print("삭제할 번호를 입력>");
		int number = sc.nextInt();
		tb_notice.remove(number-1);
	}

	@Override
	public void viewNotice() {
		  System.out.println("<<공지사항>>");
	      ArrayList<NoticeData> noticeList = noticeDao.noticeList();

	      System.out.println("====================================");
	      for (int i = 0; i < Database.tb_notice.size(); i++){
	         System.out.println("No. " + (i+1));
	         System.out.println("Title. " + no.getTitle());
	         System.out.println("Description. " + no.getDescription());
	         System.out.println("Author. " + no.getAuthor());
	         System.out.println("====================================");

		}
	}
}
