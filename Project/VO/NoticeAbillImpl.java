package project.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import project.vo.NoticeData;

public class NoticeAbillImpl implements NoticeAbill {

	@Override
	public void createdNumber() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createdTime() {

		Date today = new Date();
		NoticeData t1 = new NoticeData();
		t1.setTimeS(today);
		
		System.out.println(changedTime(today));
		

	}

	private String changedTime(Date today) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return sdf.format(today);
		
	}
}
