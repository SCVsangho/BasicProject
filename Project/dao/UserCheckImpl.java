package project.dao;

import java.util.ArrayList;
import java.util.HashMap;

import project.vo.Database;
import project.vo.UserData;

public class UserCheckImpl implements UserCheck {

	@Override
	public void checkedId() {
		ArrayList<HashMap<String, String>> join = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String> person = new HashMap<String, String>();
		for(int i = 0; i < 50; i++){
			person.put("ID", "id" + i);
			person.put("PW", "pw" + i);
			person.put("ADD", "add" + i);
			person.put("PHONE", "phone" + i);
			
		}
		join.add(person);
		
			
		

	}
	
	//아이디 중복 확인
	public UserData selectPerson(String key, String value) {	
		for(int i = 0; i < Database.tb_user.size(); i++){
			UserData person = Database.tb_user.get(i);
			
			if(key.equals("ID")){
				if(person.getId().equals(value)){
					return person;
				}

			}
		}
		return null;
	}

	@Override
	public void addId() {
		// TODO Auto-generated method stub

	}

}
