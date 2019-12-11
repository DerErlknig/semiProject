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
		id = "ccc";//더미
		String sql = "";
		
		try {
			con = ds.getConnection();
			sql = "select MEM_ADDRESS from member where MEM_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
					
			return rs.getString("MEM_ADDRESS");
		
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
	
	
	
	public List movieList() {
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
	
public List searchMovie(String movieName) {
		
		List list = new ArrayList();
		String sql ="";
		try {
			con = ds.getConnection();
			sql = "select mov_title, mov_poster from movie where mov_title like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movieName);
			
			rs= pstmt.executeQuery();
			System.out.println("OK");
			while(rs.next()) {
				MovieInfoBean mb = new MovieInfoBean();
				mb.setMOV_TITLE(rs.getString("mov_title"));
				System.out.println(rs.getString("mov_title"));
				mb.setMOV_POSTER(rs.getString("mov_poster"));
				
				list.add(mb);
			}
			
			return list;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return null;
		
		
	}

public MovieInfoBean DetailInfo(String title) {	
	String sql = "";
	
	try {
		con = ds.getConnection();
		sql = "select m.MOV_TITLE, MOV_DATE, MOV_DATE, MOV_TIME,MOV_RATING, MOV_STORY, MOV_POSTER, DIRECTOR, ACTORS, LOCATION, GENRE, FEELING "
				+"from MOVIE m, STAFF s, MOVIE_FEELING f, MOVIE_GENRE g, MOVIE_LOCATION l where m.MOV_TITLE = s.MOV_TITLE"
				+" and m.MOV_TITLE = f.MOV_TITLE and m.MOV_TITLE = g.MOV_TITLE and m.MOV_TITLE=l.MOV_TITLE and m.MOV_TITLE = ?";
		//이너 조인을 사용한 검색
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,title);
		rs = pstmt.executeQuery();

			MovieInfoBean infoBean = new MovieInfoBean();
		if(rs.next()){
			infoBean.setMOV_TITLE(rs.getString("MOV_TITLE"));
			System.out.println(rs.getString("MOV_TITLE"));
			infoBean.setMOV_DATE(rs.getDate("MOV_DATE"));
			infoBean.setMOV_TIME(rs.getInt("MOV_TIME"));
			infoBean.setMOV_RATING(rs.getString("MOV_RATING"));
			infoBean.setMOV_STORY(rs.getString("MOV_STORY"));
			infoBean.setMOV_POSTER(rs.getString("MOV_POSTER"));
			infoBean.setMOV_DIRECTOR(rs.getString("DIRECTOR"));
			infoBean.setMOV_ACTOR(rs.getString("ACTORS"));
			infoBean.setMOV_LOC(rs.getString("LOCATION"));
			infoBean.setMOV_GENRE(rs.getString("GENRE"));
			infoBean.setMOV_FEEL(rs.getString("FEELING"));
		}
		return infoBean;
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
