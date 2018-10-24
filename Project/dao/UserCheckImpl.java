package project.dao;

import java.util.ArrayList;
import java.util.HashMap;

public class UserCheckImpl implements UserCheck {

	@Override
	public void checkedId() {

		ArrayList<HashMap<String, String>> join = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> person = new HashMap<String, String>();
		for (int i = 0; i < 50; i++) {
			person.put("ID", "id" + i);
			person.put("PW", "pw" + i);
			person.put("ADD", "add" + i);
			person.put("PHONE", "phone" + i);

		}
		join.add(person);

	}

	@Override
	public void addId() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findAcount() {
		// TODO Auto-generated method stub

	}

}
