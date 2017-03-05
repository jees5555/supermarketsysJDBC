package com.github.jees5555.supermarketsysJDBC.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
static{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}

public static Connection getConnection(){
	String url="jdbc:mysql://localhost:3306/db_supermarket?useSSL=true";
	String user="root";
	String password="123456";
	Connection conn=null;
	try {
		conn = DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return conn;
}
public static Connection getConnection(boolean b){
	Connection conn=null;
	try {
		conn = JDBCUtil.getConnection();
		conn.setAutoCommit(b);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return conn;
}

public static Statement getStatement(Connection conn){
	Statement st =null;
	try {
		st= conn.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return st;
}

public static PreparedStatement getPreparedStatement(Connection conn,String sql){
	PreparedStatement ps =null;
	try {
		ps= conn.prepareStatement(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return ps;
}


public static void close(ResultSet rs,Statement st,Connection conn){
	if(rs!=null){
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(st!=null){
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


public static void close(Statement st,Connection conn){
	if(st!=null){
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
	if(rs!=null){
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(ps!=null){
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

public static void close(PreparedStatement ps,Connection conn){
	if(ps!=null){
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

}
