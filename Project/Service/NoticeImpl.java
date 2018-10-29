package project.service;

import java.util.ArrayList;
import java.util.Scanner;

import project.controller.Controller;
import project.dao.NoticeAbill;
import project.dao.NoticeAbillImpl;
import project.vo.Database;
import project.vo.NoticeData;

public class NoticeImpl implements Notice {

	NoticeAbill noticeDao = new NoticeAbillImpl();

	@Override
	public void addNotice() {
		NoticeAbill na = new NoticeAbillImpl();
		Scanner sc = new Scanner(System.in);
		NoticeData no = new NoticeData();
		
		System.out.println("[[ 1.추가  ||  2.취소  ]]");
		String answer = sc.nextLine();

		if (answer.equals("1")) {

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
		} else {
			Controller.staratProgram();
		}

	}

	@Override
	public void removeNotice() {

		Scanner s = new Scanner(System.in);

		System.out.println("******[[ 공지사항 삭제 ]]******");

		System.out.println("[[ 1.삭제  ||  2.취소  ]]");
		String answer = s.nextLine();

		if (answer.equals("1")) {

			System.out.println("삭제할 번호 입력>> ");

			int delNotice = s.nextInt();
			if (delNotice < Database.tb_notice.size()) {
				Database.tb_notice.remove(delNotice + 1);
				System.out.println("공지사항 [[ " + Database.tb_notice.get(delNotice).getTitle() + " ]]을/를 삭제하였습니다.");
			}
		}else {
			Controller.staratProgram();
		}
	}

	@Override
	public void viewNotice() {
		System.out.println("<<공지사항>>");
		ArrayList<NoticeData> noticeList = noticeDao.noticeList();

		System.out.println("====================================");
		for (int i = 0; i < Database.tb_notice.size(); i++) {
			System.out.println("No. " + (i + 1));
			System.out.println("Title. " + Database.tb_notice.get(i).getTitle());
			System.out.println("Description. " + Database.tb_notice.get(i).getDescription());
			System.out.println("Author. " + Database.tb_notice.get(i).getAuthor());
			System.out.println("====================================");

		}
	}
}
