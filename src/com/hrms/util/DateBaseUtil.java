package com.hrms.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DateBaseUtil {
	//?useUnicode=true&characterEncoding=UTF-8	如果不加这一段话，向数据库里更新数据中文会变成？？
	String url="jdbc:mysql://127.0.0.1/hr?useUnicode=true&characterEncoding=UTF-8";
	String user="root";
	String password="123123";

	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("驱动加载失败！");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn=null;
		try {
			conn=(Connection) DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			System.out.println("111");
			e.printStackTrace();
		}
		return conn;
	}

	
	public void closeConnection(Connection conn, 
			PreparedStatement pstat, 
			ResultSet rs){
		try{
			closeDBObject(rs);
		}catch(SQLException e){}finally{
			try{
				closeDBObject(pstat);
			}catch(SQLException e){}finally{
				try{
					closeDBObject(conn);
				}catch(SQLException e) { }
			}
		}
	}
	
	public void closeConnection(java.sql.Connection conn, java.sql.PreparedStatement pstat) {
		try{
			closeDBObject(pstat);
		}catch(SQLException e){}finally{
			try{
				closeDBObject(conn);
			}catch(SQLException e) { }
		}	
	}
	
	private void closeDBObject(java.sql.Connection conn) throws SQLException{
		if(conn!=null){
			conn.close();
		}
	}
	
	private void closeDBObject(java.sql.PreparedStatement pstat) throws SQLException{
		if(pstat!=null){
			pstat.close();
		}
	}
	
	private void closeDBObject(ResultSet rs) throws SQLException{
		if(rs!=null){
			rs.close();
		}
	}

	
}
