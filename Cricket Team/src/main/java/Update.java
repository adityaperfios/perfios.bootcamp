
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();
		 String id = (String)request.getParameter("id");
		 String name = (String)request.getParameter("name");
		 String matchesPlayed = (String)request.getParameter("matchesPlayed");
		 String totalRuns = (String)request.getParameter("totalRuns");
		 String wicketsTaken =(String)request.getParameter("wicketsTaken");
		 String playerType =(String)request.getParameter("playerType");
		 PlayerDetails playerDetails=new PlayerDetails();
		 playerDetails.setId(Integer.parseInt(id));
		 playerDetails.setName(name);
		 playerDetails.setMatchesPlayed(Integer.parseInt(matchesPlayed));
		 playerDetails.setTotalRuns(Integer.parseInt(totalRuns));
		 playerDetails.setWicketsTaken(Integer.parseInt(wicketsTaken));
		 playerDetails.setPlayerType(playerType);
		 //out.println("Id : "+id+"Name: "+name+"Matches : "+matchesPlayed+"Runs: "+totalRuns+"Wickets: "+wicketsTaken+"Player type : "+playerType);
		 
		 PlayerDao playerDao = new PlayerDao();
		 int x = playerDao.updatePlayer(playerDetails);
		 if(x>0)
		 {
			 RequestDispatcher rd = request.getRequestDispatcher("update.html");
			 rd.include(request, response);
			 out.println("Updated Succesfully");
		 }
		 else
		 {
			 out.println("Invalid details");
		 }
		 
	}

}
