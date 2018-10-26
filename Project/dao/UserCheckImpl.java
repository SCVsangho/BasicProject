package project.dao;

import java.util.ArrayList;


import project.vo.Database;
import project.vo.UserData;

public class UserCheckImpl implements UserCheck {

	@Override

		public UserData checkedId(String key, String value) {
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
	public void addId(UserData person) {
		Database.tb_user.add(person);

	}

	@Override
	public void findAcount() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<UserData> selectUser() {
		// TODO Auto-generated method stub
		return null;
	}



}
