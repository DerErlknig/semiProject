package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	DataSource ds;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDAO() {
		try{
			Context initCtx=new InitialContext();
			   Context envCtx=(Context)initCtx.lookup("java:comp/env");
			   ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
			  
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	public int userLogin(String id, String pw) throws SQLException{
		String sql=null;
		int x=-1;
		
		try{
			con = ds.getConnection();
			sql="select MEM_PW from MEMBER where MEM_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String memberpw=rs.getString("MEM_PW");
				
				if(memberpw.equals(pw)){
					if(id.equals("admin")) {
						x=2;
					}else {x=1;}
				}else{
					x=0;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return x;
	}
	
	public boolean insertMember(MemberBean mb) throws SQLException{
		String sql=null;
		boolean result = false;
			
		try{
			con = ds.getConnection();
			sql="insert into member values "+
				"(?,?,?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mb.getMEM_ID());
			pstmt.setString(2, mb.getMEM_NAME());
			pstmt.setString(3, mb.getMEM_PW());
			pstmt.setString(4, mb.getMEM_ADDRESS());
			
			SimpleDateFormat transDate = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date date1 = transDate.parse(mb.getMEM_BIRTH()+" 00:00:00.0");
			java.sql.Date date2 = new java.sql.Date(date1.getTime());
			
			pstmt.setDate(5, date2);
			pstmt.setString(6, mb.getMEM_GENDER());
			pstmt.setString(7, mb.getMEM_TEL());

			
			pstmt.executeUpdate();
			
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		
		return result;
	}
	
}
