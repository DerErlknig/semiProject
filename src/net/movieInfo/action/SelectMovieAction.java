package net.movieInfo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movieInfo.db.MovieInfoBean;
import net.movieInfo.db.MovieInfoDAO;

public class SelectMovieAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		MovieInfoDAO infoDAO = new MovieInfoDAO();
		MovieInfoBean info = new MovieInfoBean();
		
		info = infoDAO.DetailInfo(request.getParameter("title"));
		
		request.setAttribute("movieInfo", info);
		forward.setPath("/movieDetail.If");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
