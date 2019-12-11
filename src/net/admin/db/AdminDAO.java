package net.admin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminDAO {
	DataSource ds;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AdminDAO(){
		try{
			Context initCtx=new InitialContext();
			   Context envCtx=(Context)initCtx.lookup("java:comp/env");
			   ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
			  
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	public int insertMovie(MovieInfoBean movie) {
		int result = 0;
		int num =0;
		String sql ="";
		try {
			con = ds.getConnection();
			sql="insert into movie values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, movie.getMOV_TITLE());
			pstmt.setDate(2, movie.getMOV_DATE());
			pstmt.setInt(3, movie.getMOV_TIME());
			pstmt.setString(4, movie.getMOV_RATING());
			pstmt.setString(5, movie.getMOV_STORY());
			pstmt.setString(6, movie.getMOV_POSTER());
			result = pstmt.executeUpdate();
			
			sql="insert into staff values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movie.getMOV_TITLE());
			pstmt.setString(2, movie.getMOV_DIRECTOR());
			pstmt.setString(3, movie.getMOV_ACTOR());
			result = pstmt.executeUpdate();
			
			sql="insert into movie_feeling values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movie.getMOV_TITLE());
			pstmt.setString(2, movie.getMOV_FEEL());
			result = pstmt.executeUpdate();
			
			sql="insert into movie_location values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movie.getMOV_TITLE());
			pstmt.setString(2, movie.getMOV_LOC());
			result = pstmt.executeUpdate();
			
			sql="insert into movie_genre values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movie.getMOV_TITLE());
			pstmt.setString(2, movie.getMOV_GENRE());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return result;
		
	}
	
	public OptionBean optionAdmin() {
		List genre = new ArrayList();
		List location = new ArrayList();
		List feeling = new ArrayList();
		String sql = "";
		OptionBean options = new OptionBean();
		try {
			con = ds.getConnection();
			sql = "select * from genre";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				genre.add(rs.getString(1));
			}
			sql = "select * from location";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				location.add(rs.getString(1));
			}
			sql = "select * from feeling";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				feeling.add(rs.getString(1));
			}
			options.setGenreOptionList(genre);
			options.setLocOptionList(location);
			options.setFeelOptionList(feeling);
			
			return options;
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
	
	public List selectMember() {
		List list = new ArrayList();
		
		
		String sql = "";
		
		try {
			con = ds.getConnection();
			sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				MemberBean memBean = new MemberBean();
				
				memBean.setMEM_ID((rs.getString("MEM_ID")));
				memBean.setMEM_NAME(rs.getString("MEM_NAME"));
				memBean.setMEM_PW(rs.getString("MEM_PW"));
				memBean.setMEM_ADDRESS(rs.getString("MEM_ADDRESS"));
				memBean.setMEM_BIRTH(rs.getString("MEM_BIRTH"));
				memBean.setMEM_GENDER(rs.getString("MEM_GENDER"));
				memBean.setMEM_TEL(rs.getString("MEM_TEL"));
			
				list.add(memBean);
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
	
}
