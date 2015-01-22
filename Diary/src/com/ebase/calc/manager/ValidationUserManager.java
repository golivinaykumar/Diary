package com.ebase.calc.manager;

import com.ebase.pojo.User;

public class ValidationUserManager {
	
	
	
	public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
	public boolean isEmptyData(User checkEmpty){
		if(!checkEmpty.getUsername().equals(null) && !checkEmpty.getFirstName().equals(null) && !checkEmpty.getEmail().equals(null)){
			return true;
		}
		return false;
			
	}

}
