package net.movieInfo.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.movieInfo.action.Action;
import net.movieInfo.action.ActionForward;

public class MovieInfoFrontController extends HttpServlet  {
	private static final long serialVersionUID = 1L;

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
	
		if(command.equals("/listInfo.If")) {
			action = new listInfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.getMessage();
			}
		}else if(command.equals("/showListInfo.If")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/info/movieList.jsp");
			
		}else if(command.equals("/search/serchMovie.If")) {
			action = new SearchMovieAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/serchMovie.If")) {
			action = new SearchMovieAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/selectMovie.If")) {
			action = new SelectMovieAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/movieDetail.If")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/info/movieDetailInfo.jsp");
			
		}  
		
			/*
			 * else if(command.equals("/weather.If")) { action = new WeatherAction(); try {
			 * forward = action.execute(request, response); } catch (Exception e) {
			 * e.getMessage(); } }
			 */
	
		
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
