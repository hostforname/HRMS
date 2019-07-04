package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrms.bean.Train;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TraDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public TraDao(){
		dbutil=new DateBaseUtil();
	}
	
	
	/**
	 * addTra() - 向数据库插入一条培训信息
	 * @param traer
	 * @param tratl
	 * @param tratm
	 * @param traad
	 * @param tradi
	 */
	public void addTra(String traer, String tratl, String tratm, 
			String traad, String tradi){
		String sql="insert into hrtrain(trainer,traintitle,traintime,trainaddr,detainfo) values(?,?,?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, traer);
			pstat.setString(2, tratl);
			pstat.setString(3, tratm);
			pstat.setString(4, traad);
			pstat.setString(5, tradi);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}
	
	
	/**
	 * getTrain() - 从数据库中获取所有培训信息
	 * @return - ArrayList<Train> tras
	 */
	public ArrayList<Train> getTrain(){
		ArrayList<Train> tras=new ArrayList<Train>();
		Train tra=null;
		String sql="select * from hrtrain";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				tra=new Train(rs.getInt("trainid"),rs.getString("trainer"),rs.getString("traintitle"),rs.getDate("traintime")
						,rs.getString("trainaddr"),rs.getString("detainfo"));
				tras.add(tra);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat,rs);
		}
		return tras;
	}
	
	/**
	 * removeDepById() - 根据ID移除培训信息
	 * @param traid
	 */
	public void removeTraById(Integer traid){
		String sql="delete from hrtrain where trainid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, traid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}

}