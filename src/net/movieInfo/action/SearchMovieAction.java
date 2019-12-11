package net.movieInfo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.movieInfo.db.MovieInfoBean;
import net.movieInfo.db.MovieInfoDAO;

public class SearchMovieAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
   		
		MovieInfoDAO movieDAO = new MovieInfoDAO();
	   	MovieInfoBean movieData = new MovieInfoBean();
	   	
	   	List list = new ArrayList();
	   	list = movieDAO.searchMovie(request.getParameter("query"));
	   	
	   	request.setAttribute("list", list);
	   	
	   	ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
	   	forward.setPath("./movie/bbb.jsp");
	   	
	   	return forward;
	   	
	}
	
}
