package project.vo;

import java.util.Date;

public class ReviewData {
	
	int number;
	
	String title;
	String description;
	String author;		 // 현재 로그인 된 아이디를 강제로 저장
	String time;		// 작성 시 yyyy.MM.dd : hh.mm
	Date timeS;

	/*
	 * ====================================================================================
	 */
	

	public int getNumber() {
		return number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getTimeS() {
		return timeS;
	}

	public void setTimeS(Date today) {
		this.timeS = today;
	}

}


