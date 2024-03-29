package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberDAO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		MemberDAO memberdao=new MemberDAO();
		HttpSession session=request.getSession();
		
		String id=request.getParameter("mem_id");
		String pass=request.getParameter("mem_pass");	

		int check=memberdao.userLogin(id, pass);

		if(check==1) {
			forward.setRedirect(true);
			forward.setPath("./main_page.jsp"); 
			session.setAttribute("id", id);
			return forward;
		}else if(check==2) {
			forward.setRedirect(true);
			forward.setPath("./admin/admin.jsp"); 
			return forward;
		}else if(check==0) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return null;
		
	}
	
}
