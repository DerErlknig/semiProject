package net.movieInfo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import net.movieInfo.db.MovieInfoBean;
import net.movieInfo.db.MovieInfoDAO;

public class WeatherAction implements Action {
//날씨 파싱
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MovieInfoBean info = new MovieInfoBean();
		MovieInfoDAO infoDAO = new MovieInfoDAO();
		ActionForward forward = new ActionForward();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		List movieList = new ArrayList();
		
		try {
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = f.newDocumentBuilder();
			Document xmlDoc = null;
			
			String userLoc =infoDAO.getLoc(id);
			String locID = "";
			
			if(userLoc.equals("서울")) {
				locID = "1168066000";//강남구 기준
			}else if(userLoc.equals("경기도")) {
				locID = "4182025000";//가평군 기준
			}else if(userLoc.equals("강원도")) {
				locID = "4215061500";//강릉기준
			}else if(userLoc.equals("충청북도")) {
				locID = "4313053500";//충주 기준
			}else if(userLoc.equals("충청남도")) {
				locID = "4423040000";//논산 기준
			}else if(userLoc.equals("전라북도")) {
				locID = "4579031000";//고창군
			}else if(userLoc.equals("전라남도")) {
				locID = "4611056500";//목포기준
			}else if(userLoc.equals("경상북도")) {
				locID = "4711334000";//포항기준
			}else if(userLoc.equals("경상남도")) {
				locID = "4831034000";//거제
			}else if(userLoc.equals("제주도")) {
				locID = "5013025300";
			}
			
			String uri = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone="+userLoc;
			System.out.println(uri);
			xmlDoc = parser.parse(uri);
			
			NodeList rssLoc = xmlDoc.getElementsByTagName("data");			
			NodeList rssData = rssLoc.item(0).getChildNodes();
			
			for(int i=0;i<rssData.getLength();i++) {

					if(rssData.item(i).getNodeName().equals("wfKor")) {
						String weather = rssData.item(i).getTextContent();
						System.out.println(weather);
						movieList = infoDAO.weatherSelect();
					}

			}
	
			
		}catch(Exception ex) {
		}
		
		request.setAttribute("boardlist", movieList);
		forward.setRedirect(false);
 		forward.setPath("-");
		
		return forward;
	}
	
}
