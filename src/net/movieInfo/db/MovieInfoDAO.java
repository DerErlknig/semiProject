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
		return "서울";
	}
	
	
	
	public List movieList() {
		List itemList = new ArrayList();
		String sql = "select ";
		
		try {
			con = ds.getConnection();
			
			
			
			
			
			
			rs = pstmt.executeQuery();
		}catch(Exception ex) {
			
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
