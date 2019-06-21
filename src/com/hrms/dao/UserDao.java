package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UserDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public UserDao(){
		dbutil=new DateBaseUtil();
	}
	
	/**
	 * isLogin(String username, String userwd) - �ж��û���¼
	 * @param username - �û���
	 * @param userpwd - ����
	 * @return true[��½�ɹ�]/false[��½ʧ��]
	 */
	public boolean isLogin(String username, String userpwd){
		String sql="select * from hruser where username=? and userpwd=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, username);
			pstat.setString(2, userpwd);
			rs=pstat.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat, rs);
		}
		return false;
	}
	
}
