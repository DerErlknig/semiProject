package net.movieInfo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movieInfo.db.MovieInfoBean;
import net.movieInfo.db.MovieInfoDAO;

public class DetailInfoAction implements Action  {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		MovieInfoDAO infoDAO = new MovieInfoDAO();
		List infoList = new ArrayList();
		infoList = infoDAO.movieInfo();
		
		request.setAttribute("infoList", infoList);
		forward.setPath("/showDetailInfo.If");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
