package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrms.bean.Rewpun;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RewDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public RewDao(){
		dbutil=new DateBaseUtil();
	}
	
	
	/**
	 * addRew() - 向数据库中添加一条奖惩信息
	 * @param rewtl
	 * @param rewty
	 * @param rewmo
	 * @param rewdi
	 */
	public void addRew(String rewtl, Integer rewty, Integer rewmo, 
			String rewdi){
		String sql="insert into hrrewpun(rewpuntitle,rewpuntype,rewpunmount,detainfo) values(?,?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, rewtl);
			pstat.setInt(2, rewty);
			pstat.setInt(3, rewmo);
			pstat.setString(4, rewdi);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}
	
	/**
	 * getRewpun() - 从数据库中获取所有奖惩信息
	 * @return - ArrayList<Rewpun> rews
	 */
	public ArrayList<Rewpun> getRewpun(){
		ArrayList<Rewpun> rews=new ArrayList<Rewpun>();
		Rewpun rew=null;
		String sql="select * from hrrewpun";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				rew=new Rewpun(rs.getInt("rewpunid"),rs.getString("rewpuntitle"),rs.getInt("rewpuntype"),rs.getInt("rewpunmount")
						,rs.getDate("rewpuntime"),rs.getString("detainfo"));
				rews.add(rew);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat,rs);
		}
		return rews;
	}
	
	/**
	 * removeRewById() - 通过id来删除对应的奖惩信息
	 * @param rewid
	 */
	public void removeRewById(Integer rewid){
		String sql="delete from hrrewpun where rewpunid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, rewid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}

}