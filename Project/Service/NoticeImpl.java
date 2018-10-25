package project.service;

import java.util.Scanner;

import project.dao.NoticeAbill;
import project.dao.NoticeAbillImpl;
import project.vo.NoticeData;

public class NoticeImpl implements Notice {

	@Override
	public void addNotice() {
		NoticeAbill na= new NoticeAbillImpl();
		Scanner sc = new Scanner(System.in);
		NoticeData no = new NoticeData();
		

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
		System.out.print("[공지사항 작성자 등록] : ");
		String author = sc.nextLine();
		no.setAuthor(author);
		
		// 현재 시간 등록
		na.createdTime();
		
	}

	@Override
	public void removeNotice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewNotice() {
		// TODO Auto-generated method stub
		
	}


}
