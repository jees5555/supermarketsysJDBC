package com.github.jees5555.supermarketsysJDBC.biz;

import java.util.List;

import com.github.jees5555.supermarketsysJDBC.dao.impl.UserDaoImpl;
import com.github.jees5555.supermarketsysJDBC.entity.User;

public class UserBiz {

	public User login(String userName, String userPassword) {
		UserDaoImpl ud = new UserDaoImpl();
		return ud.login(userName,userPassword);
		
	}

	public List<User> getUserList(String userName) {
		UserDaoImpl ud = new UserDaoImpl();
		return ud.getObjectList(userName,null);
	}

	public User getUser(String userId) {
		UserDaoImpl ud = new UserDaoImpl();
		return ud.getObject(userId);
	}

	public String isUserExist(String userId,String userName) {
		UserDaoImpl ud = new UserDaoImpl();
		String msg1=ud.isObjectExistById(userId);
		String msg2=ud.isUserExistByName(userName);
		if(msg1.equals("error")||msg2.equals("error")){
			return "error";
		}else if(msg1.equals("true")&&msg2.equals("false")){
			return "true1";
		}else if(msg1.equals("false")&&msg2.equals("true")){
			return "true2";
		}else if(msg1.equals("true")&&msg2.equals("true")){
			return "true3";
		}else{
			return "false";
		}
	}

	public void addUser(User u) {
		UserDaoImpl ud = new UserDaoImpl();
		ud.addObject(u);
		
	}

	public void updateUser(String userIdOld, User u) {
		UserDaoImpl ud = new UserDaoImpl();
		ud.updateObject(userIdOld,u);
		
	}

	public void deleteUser(String userId) {
		UserDaoImpl ud = new UserDaoImpl();
		ud.deleteObject(userId);
		
	}

	public String checkUserPassword(String userId, String userPassword) {
		UserDaoImpl ud = new UserDaoImpl();
		String userPassword1=ud.getUserPassword(userId);
		if(userPassword1==null){
			return "error";
		}else if(userPassword.equals(userPassword1)){
			return "true";
		}else{
			return "false";
		}
	}

	public void updateUserPassword(int userId, String userPassword) {
		UserDaoImpl ud = new UserDaoImpl();
		ud.updateUserPassword(userId,userPassword);
		
	}

}
