package project.dao;

import java.util.ArrayList;

import project.vo.NoticeData;

public interface NoticeAbill {
	
	/*공지사항 고유넘버 생성*/
	void createdNumber();
	
	
	/*공지사항 등록 시간 생성*/
	String createdTime();
	
	void insertNotice(NoticeData notice);
	
	ArrayList<NoticeData> noticeList();

}
