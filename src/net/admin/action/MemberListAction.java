package net.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.db.AdminDAO;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		AdminDAO admin = new AdminDAO();
		List memberList = new ArrayList();
		memberList = admin.selectMember();
		request.setAttribute("memberList", memberList);
		forward.setPath("/adminMember.ad");
		forward.setRedirect(false);
		return forward;
	}
	
}
