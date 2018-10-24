package project.dao;


import project.vo.Database;
import project.vo.UserData;

public class UserCheckImpl implements UserCheck {

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
	public void addId() {
		// TODO Auto-generated method stub
		
	}
	
	public void findAcount(){
		
	}

}
