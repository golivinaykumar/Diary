package com.ebase.calc.manager;

import com.ebase.calc.dao.UserDAO;
import com.ebase.pojo.User;

public class UserManager {
	UserDAO userDAOManager = null;
	ValidationUserManager validate;
	public boolean signUp(User signupData){
		userDAOManager = new UserDAO();
		validate = new ValidationUserManager();
		String username = signupData.getUsername();
		if(validate.isEmptyData(signupData) && validate.isValidEmailAddress(signupData.getEmail())){
		if(userDAOManager.checkUser(username)){
			
			return userDAOManager.signUp(signupData);
		}else{
			System.out.println("signup mgr 1");
			return false;
		}
		}
		else {
			System.out.println("signup mgr 2");
			return false;
		}
		
	}
	public boolean checkUser(String username){
		userDAOManager = new UserDAO();
		return userDAOManager.checkUser(username);
	}
	public boolean loginManager(String username,String password){
		userDAOManager = new UserDAO();
		if(!username.isEmpty() && !password.isEmpty()){
		return userDAOManager.login(username, password);
		}else{
			System.out.println("manager");
			return false;
		}
			
		
	}
	public User getUserDetailsManager(String username){
		userDAOManager = new UserDAO();
		if(!username.isEmpty()){
		return userDAOManager.getUserDetails(username);
		}else{
			return null;
		}
		
		
		
	}
	public boolean updateUserManager(User updateDetails){
		userDAOManager = new UserDAO();
		validate = new ValidationUserManager();
		if(validate.isEmptyData(updateDetails) && validate.isValidEmailAddress(updateDetails.getEmail())){
		return userDAOManager.updateUser(updateDetails);
		}else{
			return false;
		}
		
	}
	public boolean changePasswordManager(String username,String oldPassword,String newPassword,String newpassword2){
		userDAOManager = new UserDAO();
		if(!username.equals(null) && !oldPassword.equals(null) && !newPassword.equals(null) && newPassword.equals(newpassword2) ){
			return userDAOManager.changePassword(username, oldPassword, newpassword2);
		}else{
			return false;
		}
	}
}
