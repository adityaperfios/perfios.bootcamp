
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
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
		 int avg = Integer.parseInt(totalRuns)/Integer.parseInt(matchesPlayed);
		 //out.println("Id : "+id+"Name: "+name+"Matches : "+matchesPlayed+"Runs: "+totalRuns+"Wickets: "+wicketsTaken+"Player type : "+playerType);
		 
		 PlayerDetails playerDetails=new PlayerDetails();
		 playerDetails.setId(Integer.parseInt(id));
		 playerDetails.setName(name);
		 playerDetails.setMatchesPlayed(Integer.parseInt(matchesPlayed));
		 playerDetails.setTotalRuns(Integer.parseInt(totalRuns));
		 playerDetails.setWicketsTaken(Integer.parseInt(wicketsTaken));
		 playerDetails.setPlayerType(playerType);
		 playerDetails.setAvg(avg);
		 PlayerDao playerDao = new PlayerDao();
		 int x = playerDao.savePlayer(playerDetails);
		 
		 if(x>0)
		 {
			 RequestDispatcher rd = request.getRequestDispatcher("register.html");
			 rd.include(request, response);
			 out.println("Registered Succesfully");
		 }
		 else
		 {
			 out.println("Invalid details");
		 }
		 
		 
		 
	}

}
