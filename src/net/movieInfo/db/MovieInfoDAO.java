package net.movieInfo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MovieInfoDAO {
	DataSource ds;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MovieInfoDAO() {
		try{
			Context initCtx=new InitialContext();
			   Context envCtx=(Context)initCtx.lookup("java:comp/env");
			   ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
			  
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	public String getLoc(String id) throws SQLException{
		
		String sql = "";
		
		try {
			con = ds.getConnection();
			sql = "select MEM_ADDRESS from member where MEM_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
					
			return rs.getString("MEM_ID");
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return null;
	}
	
	
	
	public List movieInfo() {
		List list = new ArrayList();
		
		
		String sql = "";
		
		try {
			con = ds.getConnection();
			sql = "select * from movie";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				MovieInfoBean infoBean = new MovieInfoBean();
				
				infoBean.setMOV_TITLE(rs.getString("MOV_TITLE"));
				infoBean.setMOV_DATE(rs.getDate("MOV_DATE"));
				infoBean.setMOV_TIME(rs.getInt("MOV_TIME"));
				infoBean.setMOV_RATING(rs.getString("MOV_RATING"));
				infoBean.setMOV_STORY(rs.getString("MOV_STORY"));
				infoBean.setMOV_POSTER(rs.getString("MOV_POSTER"));
				
				list.add(infoBean);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return null;
	}
	
	public List weatherSelect() {
		String sql = "select movie from member where MOVIE_WEATHER=?";
		
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		}catch(Exception ex) {
			
		}
		return null;
	}
}
