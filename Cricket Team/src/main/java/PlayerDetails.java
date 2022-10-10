
import java.util.Comparator;


class PlayerDetails {
		private int id;
		private String name;
	    private int matchesPlayed;
	    private int totalRuns;
	    private int wicketsTaken;
	    private String playerType;
	    private int avg=0;

	    public PlayerDetails()
	    {

	    }
	    public PlayerDetails(int id,String name,int matchesPlayed,int totalRuns,int wicketsTaken,String playerType)
	    {
	        this.id=id;
	        this.name= name;
	        this.matchesPlayed=matchesPlayed;
	        this.totalRuns=totalRuns;
	        this.wicketsTaken=wicketsTaken;
	        this.playerType=playerType;
	        this.setAvg((totalRuns/matchesPlayed));
	    }

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getMatchesPlayed() {
	        return matchesPlayed;
	    }

	    public int getTotalRuns() {
	        return totalRuns;
	    }

	    public int getWicketsTaken() {
	        return wicketsTaken;
	    }

	    public String getPlayerType() {
	        return playerType;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setPlayerType(String playerType) {
	        this.playerType = playerType;
	    }

	    public void setMatchesPlayed(int matchesPlayed) {
	        this.matchesPlayed = matchesPlayed;
	    }

	    public void setTotalRuns(int totalRuns) {
	        this.totalRuns = totalRuns;
	    }

	    public void setWicketsTaken(int wicketsTaken) {
	        this.wicketsTaken = wicketsTaken;
	    }
		public int getAvg() {
			return avg;
		}
		public void setAvg(int avg) {
			this.avg = avg;
		}
				 
}
class ScoreComparator implements Comparator<PlayerDetails>
{
	@Override
	public int compare(PlayerDetails o1, PlayerDetails o2) {
//		int avg1 = (o1.getTotalRuns()/o1.getMatchesPlayed());
//        int avg2=(o2.getTotalRuns()/ o2.getMatchesPlayed());
        return o2.getAvg()-o1.getAvg();
	}
}


class NameComparator implements Comparator<PlayerDetails>
{
    
	@Override
	public int compare(PlayerDetails o1, PlayerDetails o2) {
		 return o1.getName().compareTo(o2.getName());
	}
}
