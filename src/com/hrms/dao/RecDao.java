package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrms.bean.Recruit;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RecDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public RecDao(){
		dbutil=new DateBaseUtil();
	}
	
	
	/**
	 * addRec() - 向数据库中增加一个新的招聘信息
	 * @param name
	 * @param sex
	 * @param recruittype
	 * @param education
	 * @param workexp
	 * @param detainfo
	 */
	public void addRec( String name, String sex, String recruittype, 
			String education, String workexp, String detainfo){
		String sql="insert into hrrecruit(name,sex,recruittype,education,workexp,detainfo) values(?,?,?,?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, sex);
			pstat.setString(3, recruittype);
			pstat.setString(4, education);
			pstat.setString(5, workexp);
			pstat.setString(6, detainfo);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}
	
	
	/**
	 * getRecruit() - 查询数据库中所有的应聘信息
	 * @return - ArrayList<Recruit> recs
	 */
	public ArrayList<Recruit> getRecruit(){
		ArrayList<Recruit> recs=new ArrayList<Recruit>();
		Recruit rec=null;
		String sql="select * from hrrecruit";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				rec=new Recruit(rs.getInt("recruitid"),rs.getString("name"),rs.getString("sex"),rs.getString("recruittype")
						,rs.getString("education"),rs.getString("workexp"),rs.getString("detainfo"),rs.getInt("status"));
				recs.add(rec);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat,rs);
		}
		return recs;
	}
	
	/**
	 * updateRecById() - 通过id来更新应聘人的录用状态
	 * @param recruitid
	 * @param status
	 */
	public void updateRecById(Integer recruitid,Integer status) {
		String sql="update hrrecruit set status=? where recruitid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			if(status==0) {
				pstat.setInt(1, 1);
			} else {
				pstat.setInt(1, 0);
			}
			pstat.setInt(2, recruitid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}		
	}

	
	/**
	 * removeRecById() - 通过id来删除相关的信息
	 * @param recruitid
	 */
	public void removeRecById(Integer recruitid){
		String sql="delete from hrrecruit where recruitid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, recruitid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}

}