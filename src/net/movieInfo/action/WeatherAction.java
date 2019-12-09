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
			
			if(userLoc.equals("서울")||userLoc.equals("경기도")) {
				locID = "109";
			}else if(userLoc.equals("강원도")) {
					locID = "105";
			}else if(userLoc.equals("충청북도")) {
					locID = "131";
			}else if(userLoc.equals("충청남도")) {
				locID = "133";
			}else if(userLoc.equals("전라북도")) {
				locID = "146";
			}else if(userLoc.equals("전라남도")) {
				locID = "156";
			}else if(userLoc.equals("경상북도")) {
				locID = "143";
			}else if(userLoc.equals("경상남도")) {
				locID = "159";
			}else if(userLoc.equals("제주도")) {
				locID = "184";
			}
			
			String uri = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId="+locID;
			System.out.println(uri);
			xmlDoc = parser.parse(uri);
			
			NodeList rssLoc = xmlDoc.getElementsByTagName("location");			
			NodeList rssData = rssLoc.item(0).getChildNodes();
			
			for(int i=0;i<rssData.getLength();i++) {
				
				NodeList rssInfo = rssData.item(i).getChildNodes();
				for(int j=0;j<rssInfo.getLength();j++) {
					if(rssInfo.item(j).getNodeName().equals("tmEf")) {
						System.out.println(rssInfo.item(j).getTextContent());
					}
					if(rssInfo.item(j).getNodeName().equals("wf")) {
						System.out.println(rssInfo.item(j).getTextContent());
						movieList = infoDAO.weatherSelect();
					}
				}
			}
	
			
		}catch(Exception ex) {
		}
		
		request.setAttribute("boardlist", movieList);
		forward.setRedirect(false);
 		forward.setPath("");
		
		return forward;
	}
	
}
