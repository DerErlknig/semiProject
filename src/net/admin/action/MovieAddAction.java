package net.admin.action;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.admin.db.AdminDAO;
import net.admin.db.MovieInfoBean;

public class MovieAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		AdminDAO adminDAO = new AdminDAO();
		MovieInfoBean info = new MovieInfoBean();
		
		String realPath = "";
		String savePath = "/poster";
		int maxSize = 5 * 1024 * 1024;
		realPath = request.getSession().getServletContext().getRealPath(savePath);
		
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			SimpleDateFormat transDate = new SimpleDateFormat("yyyy-mm-dd");

			java.util.Date date1 = transDate.parse(multi.getParameter("movie_date"));
			java.sql.Date date2 = new java.sql.Date(date1.getTime());
			
			info.setMOV_GENRE(multi.getParameter("movie_genre"));
			info.setMOV_TITLE(multi.getParameter("movie_name"));
			info.setMOV_RATING(multi.getParameter("movie_rating"));
			info.setMOV_TIME(Integer.parseInt(multi.getParameter("movie_time")));
			info.setMOV_DATE(date2);
			info.setMOV_STORY(multi.getParameter("movie_story"));
			info.setMOV_POSTER(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			
			int result=adminDAO.insertMovie(info);
			
			if(result<=0){
	   			System.out.println("정보 등록 실패");
	   			return null;
	   		}
	   		System.out.println("정보 등록 완료");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./admin.ad");
	   		return forward;
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return forward;
	}

}
