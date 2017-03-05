package com.github.jees5555.supermarketsysJDBC.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.jees5555.supermarketsysJDBC.dao.UserDao;
import com.github.jees5555.supermarketsysJDBC.entity.User;
import com.github.jees5555.supermarketsysJDBC.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	public User login(String userName, String userPassword) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select *,count(*) from user where userName=? "+
		"and userPassword=?";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			ps.setString(1,userName);
			ps.setString(2, userPassword);
			rs=ps.executeQuery();
			User user =null;
			while(rs.next()){
				int count=rs.getInt("count(*)");
				if(count==0){
					return null;
				}else{
					user =new User();
				 	user.setUserId(rs.getInt("userId"));
				 	user.setUserName(rs.getString("userName"));
				 	user.setUserRole(rs.getInt("userRole"));
				 	
				}
			   }
			return user;
			}catch( SQLException e){
				e.printStackTrace();
				return null;
			}finally{
				JDBCUtil.close(rs, ps, conn);
			}
		
	}
   @Override
	public List<User> getObjectList(String userName,String arg2) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select * from user where 1=1 ";
		if(userName!=null&&!userName.equals("")){
			sql =sql +"and userName like '%"+userName+"%' ";
		}
		sql=sql+"ORDER BY userId ASC";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			List<User>list=new ArrayList<User>();
			rs=ps.executeQuery();
			while(rs.next()){
				User u=new User();
				u.setUserId(rs.getInt("userId"));
				u.setUserName(rs.getString("userName"));
				u.setUserSex(rs.getInt("userSex"));
				u.setUserAge(rs.getInt("userAge"));
				u.setUserTel(rs.getLong("userTel"));
				u.setUserAddress(rs.getString("userAddress"));
				u.setUserRole(rs.getInt("userRole"));
				list.add(u);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
	}
    
   @Override
	public User getObject(String userId) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select * from user where userId="+userId;
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			User u = new User();
			rs=ps.executeQuery();
			while(rs.next()){
				u.setUserId(rs.getInt("userId"));
				u.setUserName(rs.getString("userName"));
				u.setUserSex(rs.getInt("userSex"));
				u.setUserAge(rs.getInt("userAge"));
				u.setUserTel(rs.getLong("userTel"));
				u.setUserAddress(rs.getString("userAddress"));
				u.setUserRole(rs.getInt("userRole"));
			}
			return u;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
	}
   
   @Override
	public String isObjectExistById(String userId) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select count(*) from user where userId="+userId;
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			String msg =null;
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("count(*)")==0){
					msg="false";
				}else{
					msg="true";
				}
			}
		return msg;
		}catch(SQLException e){
			e.printStackTrace();
			return "error";
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
	}
	public String isUserExistByName(String userName) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select count(*) from user where userName='"+userName+"'";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			String msg =null;
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("count(*)")==0){
					msg="false";
				}else{
					msg="true";
				}
			}
		return msg;
		}catch(SQLException e){
			e.printStackTrace();
			return "error";
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
	}
    @Override
	public void addObject(User u) {
		Connection conn =JDBCUtil.getConnection();
		String sql="insert into user (userId,userName,userPassword,userSex,"
				+ "userAge,userTel,userAddress,userRole) "
				+ "values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		try{
			ps.setInt(1, u.getUserId());
			ps.setString(2, u.getUserName());
			ps.setString(3, u.getUserPassword());
			ps.setInt(4, u.getUserSex());
			ps.setInt(5, u.getUserAge());
			ps.setLong(6, u.getUserTel());
			ps.setString(7, u.getUserAddress());
			ps.setInt(8, u.getUserRole());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(ps, conn);
		}
		
	}



	public String getUserPassword(String userId) {
		Connection conn =JDBCUtil.getConnection();
		String sql="select * from user where userId="+userId;
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		ResultSet rs =null;
		try{
			rs=ps.executeQuery();
			String userPassword=null;
			while(rs.next()){
				userPassword=rs.getString("userPassword");
			}
			return userPassword;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
	}

	public void updateUserPassword(int userId, String userPassword) {
		Connection conn =JDBCUtil.getConnection();
		String sql="update user set userPassword=? where userId=?";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		try{
			ps.setString(1, userPassword);
			ps.setInt(2, userId);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(ps, conn);
		}
		
	}
	@Override
	public void updateObject(String id, User u) {
		Connection conn =JDBCUtil.getConnection();
		String sql="update user set userId=?,userName=?,userSex=?,userAge=?,"
				+ "userTel=?,userAddress=?,userRole=? where userId=?";
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		try{
			ps.setInt(1, u.getUserId());
			ps.setString(2, u.getUserName());
			ps.setInt(3, u.getUserSex());
			ps.setInt(4, u.getUserAge());
			ps.setLong(5, u.getUserTel());
			ps.setString(6, u.getUserAddress());
			ps.setInt(7, u.getUserRole());
			ps.setString(8, id);
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(ps, conn);
		}
		
	}
	@Override
	public void deleteObject(String id) {
		Connection conn =JDBCUtil.getConnection();
		String sql="delete from user where userId="+id;
		PreparedStatement ps =JDBCUtil.getPreparedStatement(conn, sql);
		try{
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(ps, conn);
		}
		
	}

}
