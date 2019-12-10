package net.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.action.Action;
import net.admin.action.ActionForward;

public class AdminFrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action =null;
		System.out.println(command);
		if(command.equals("/admin.ad")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/admin.jsp");
			
		}else if(command.equals("/movieAddAction.ad")) {
			action = new MovieAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.getMessage();
			}
		}else if(command.equals("/adminMember.ad")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/admin/adminMember.jsp");
		}else if(command.equals("/movieDeleteAction.ad")) {
			
		}else if(command.equals("/memberListAction.ad")) {
			
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.getMessage();
			}
			
		}else if(command.equals("/memberDeleteAction.ad")) {
			
		}
		
		
		
		if(forward !=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
	
}
