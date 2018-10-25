package project.vo;

import java.util.Date;

public class NoticeData {

	int number;
	String title;
	String description;
	String author;
	String time;
	Date timeS;

	/*
	 * =============================================================================
	 * =======
	 */

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getTime(String time) {
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
