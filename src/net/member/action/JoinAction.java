package net.member.action;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");		
		MemberDAO memberdao=new MemberDAO();
		MemberBean dto=new MemberBean();
		ActionForward forward=null;

		dto.setMEM_ID(request.getParameter("mem_id"));
		dto.setMEM_PW(request.getParameter("mem_pass"));
		dto.setMEM_NAME(request.getParameter("mem_name"));
		dto.setMEM_ADDRESS(request.getParameter("mem_address"));
		dto.setMEM_BIRTH(request.getParameter("mem_birthday"));		
				
		String tel = request.getParameter("mem_phone1")+"-"
						+request.getParameter("mem_phone2")+"-"
						+request.getParameter("mem_phone3");
		
		dto.setMEM_TEL(tel);
		dto.setMEM_GENDER(request.getParameter("mem_gender"));
		memberdao.insertMember(dto);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('회원가입에 성공하였습니다.');");
		out.println("location.href='./loginform.me';");
		out.println("</script>");			
		out.close();	
		return forward;
		
	}
	
}
