package net.movieInfo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movieInfo.db.MovieInfoBean;
import net.movieInfo.db.MovieInfoDAO;

public class DetailShowAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		MovieInfoDAO infoDAO = new MovieInfoDAO();
		MovieInfoBean infoBean = new MovieInfoBean();
		
		infoBean = infoDAO.DetailInfo(request.getParameter("mov_title"));
		request.setAttribute("info", infoBean);
		forward.setPath("");
		forward.setRedirect(false);
		
		
		return forward;
		
	}
	
}
