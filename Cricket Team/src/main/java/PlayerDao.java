

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class PlayerDao {
	public Statement getStatement() {
        Connection con = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SPORTS?autoReconnect=true&useSSL=false", "root", "password");
            st= con.createStatement();
            //return con;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }
	
	 public int savePlayer(PlayerDetails playerDetails) {
         String sql= null;
         try {
             sql = "insert into cricket values(" + playerDetails.getId() + ",'" + playerDetails.getName() + "','" + playerDetails.getMatchesPlayed() +
            		 "','" + playerDetails.getTotalRuns() +"','" + playerDetails.getWicketsTaken() +"','" + playerDetails.getPlayerType() +"','"+playerDetails.getAvg()+ "')";
             //st = getConnection().createStatement();
             return getStatement().executeUpdate(sql);
         }
         catch (Exception e)
         {
             e.printStackTrace();
             return 0;

         }
         //return st.executeUpdate(sql);
 }
	 public int updatePlayer(PlayerDetails playerDetails) {
         try
         {
             String sql = "update cricket set id = '"+playerDetails.getId()+"',name='"+playerDetails.getName()+"',matchesPlayed='"
         +playerDetails.getMatchesPlayed()+"',totalRuns='"+playerDetails.getTotalRuns()+"',wicketsTaken='"+playerDetails.getWicketsTaken()+
         "',playerType='"+playerDetails.getPlayerType()+"' where id='"+playerDetails.getId()+"'" ;
             return getStatement().executeUpdate(sql);
         }
         catch (Exception e)
         {
             e.printStackTrace();
             return 0;
         }
 } 
	 public List<PlayerDetails> getAllPlayers()
	   {
	       List<PlayerDetails> playerList = new ArrayList<PlayerDetails>();
	      
	       try
	       {
	           String sql= "select * from cricket";
	           ResultSet rs = getStatement().executeQuery(sql);
	           while ((rs.next()))
	           {
	               PlayerDetails playerDetails=new PlayerDetails();
	               playerDetails.setId(rs.getInt(1));
	               playerDetails.setName(rs.getString(2));
	               playerDetails.setMatchesPlayed(rs.getInt(3));
	               playerDetails.setTotalRuns(rs.getInt(4));
	               playerDetails.setWicketsTaken(rs.getInt(5));
	               playerDetails.setPlayerType(rs.getString(6));
	               playerDetails.setAvg(rs.getInt(7));
	               playerList.add(playerDetails);
	           }
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	       return playerList;
	   } 
	 public List<PlayerDetails> displayFinalPlayers(List<PlayerDetails> data) throws SQLException
	    {	
		 ArrayList<PlayerDetails> final_list = new ArrayList<>(11);
	    
	    try
	       {	
			 	
	           String sql= "SELECT * FROM cricket where playerType='Bowler' order by wicketsTaken/matchesPlayed desc limit 0,4;";
	           ResultSet rs = getStatement().executeQuery(sql);
	           while ((rs.next()))
	           {
	               PlayerDetails playerDetails=new PlayerDetails();
	               playerDetails.setId(rs.getInt(1));
	               playerDetails.setName(rs.getString(2));
	               playerDetails.setMatchesPlayed(rs.getInt(3));
	               playerDetails.setTotalRuns(rs.getInt(4));
	               playerDetails.setWicketsTaken(rs.getInt(5));
	               playerDetails.setPlayerType(rs.getString(6));
	               playerDetails.setAvg(rs.getInt(7));
	               final_list.add(playerDetails);
	           }
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
		 try
	       {
	           String sql= "SELECT * FROM cricket where playerType='Wicket Keeper' order by average desc limit 0,1;";
	           ResultSet rs = getStatement().executeQuery(sql);
	           while ((rs.next()))
	           {
	               PlayerDetails playerDetails=new PlayerDetails();
	               playerDetails.setId(rs.getInt(1));
	               playerDetails.setName(rs.getString(2));
	               playerDetails.setMatchesPlayed(rs.getInt(3));
	               playerDetails.setTotalRuns(rs.getInt(4));
	               playerDetails.setWicketsTaken(rs.getInt(5));
	               playerDetails.setPlayerType(rs.getString(6));
	               playerDetails.setAvg(rs.getInt(7));
	               final_list.add(playerDetails);
	           }
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	 	
	        Collections.sort(data,new ScoreComparator());
	        
	        
	        int count =0;
	        for(PlayerDetails p:data){
	            if(count==6){
	                break;
	            }
	            final_list.add(p);
	            count++;
	        }
	        Collections.sort(final_list,new NameComparator());
	        return final_list;

	    }
}

