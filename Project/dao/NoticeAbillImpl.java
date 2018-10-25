package project.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import project.vo.Database;
import project.vo.NoticeData;

public class NoticeAbillImpl implements NoticeAbill {

	@Override
	public void createdNumber() {
		
		/* Not Defined */
		System.out.println("번호가 추가되었습니다.");

	}

	@Override
	public String createdTime() {

		Date today = new Date();
		NoticeData t1 = new NoticeData();
		t1.setTimeS(today);

		return changedTime(today);

	}

	/* 지역 메소드 */
	private String changedTime(Date today) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return sdf.format(today);

	}

	@Override
	public void insertNotice(NoticeData notice) {
		Database.tb_notice.add(notice);
	}
}
