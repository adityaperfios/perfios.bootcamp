package Cricket_Selection;

import java.util.*;

class Players{
    private int id;
    private String name;
    private long tot_runs;
    private long matches;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private long wickets_taken;
    private long duck;
    private double avg;

    private int points;
    private String player_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTot_runs() {
        return tot_runs;
    }

    public void setTot_runs(long tot_runs) {
        this.tot_runs = tot_runs;
    }

    public long getMatches() {
        return matches;
    }

    public void setMatches(long matches) {
        this.matches = matches;
    }

    public long getWickets_taken() {
        return wickets_taken;
    }

    public void setWickets_taken(long wickets_taken) {
        this.wickets_taken = wickets_taken;
    }

    public long getDuck() {
        return duck;
    }

    public void setDuck(long duck) {
        this.duck = duck;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getPlayer_type() {
        return player_type;
    }

    public void setPlayer_type(String player_type) {
        this.player_type = player_type;
    }

    public Players(){}

    public Players(int id,String name,long tot_runs,long matches,
                   long wickets_taken,long duck,double avg,String player_type){
        this.id = id;
        this.name = name;
        this.tot_runs = tot_runs;
        this.matches = matches;
        this.wickets_taken = wickets_taken;
        this.duck = duck;
        this.avg = avg;
        this.player_type = player_type;

    }
    public static Comparator<Players> playersComparator = new Comparator<Players>() {
        @Override
        public int compare(Players t1, Players t2) {
            return t2.getPoints()- t1.getPoints();
        }
    };


}
class Utils {

    public static void display(Players p){
        System.out.println("Serial No. ");
        System.out.println("Id : "+p.getId());
        System.out.println("Name : "+p.getName());
        System.out.println("Total Runs : "+p.getTot_runs());
        System.out.println("Total Matches : "+p.getMatches());
        System.out.println("Wickets Taken : "+p.getWickets_taken());
        System.out.println("Out on zero : "+p.getDuck());
        System.out.println("Current Avg : "+p.getAvg());
        System.out.println("Player Type : "+p.getPlayer_type());

    }
    public static void sortbyName(ArrayList<Players> list){
        list.sort((o1, o2)
                -> o1.getName().compareTo(
                o2.getName()));
    }
    public static void addplayers(ArrayList<Players> player_list,int n){
        Scanner sc = new Scanner(System.in);
        int i=0;
        int bowlerscount=0;
        int wicketkeepcount=0;
        while(true){

            Players p = new Players();
            System.out.println("Enter player id");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter player name");
            String name = sc.nextLine();
            System.out.println("Enter total runs scored");
            long tot_runs = sc.nextLong();
            System.out.println("Enter matches played");
            long matches = sc.nextLong();
            System.out.println("Enter wickets taken");
            long wickets_taken = sc.nextLong();
            System.out.println("Enter no. of times "+name+" got out on Zero(Duck)");
            long duck = sc.nextLong();
            System.out.println("Enter player type");
            String player_type = sc.next().toLowerCase();
            if(player_type.equals("bowler")){
                bowlerscount++;
            }else if(player_type.equals("wicketkeeper")){
                wicketkeepcount++;
            }

            double avg = ((double) tot_runs/(double) matches)+(double) wickets_taken - (double) duck;
            int points = (int) avg;


            p.setId(id);
            p.setName(name);
            p.setTot_runs(tot_runs);
            p.setMatches(matches);
            p.setWickets_taken(wickets_taken);
            p.setDuck(duck);
            p.setAvg(avg);
            p.setPlayer_type(player_type);
            p.setPoints(points);

            player_list.add(p);//adding all the values in arraylist
            i++;
            if(i==n){
                if(bowlerscount<3||wicketkeepcount<1){
                    if (bowlerscount<3){
                        System.out.println("No. of bowlers = "+bowlerscount);
                        System.out.println("bowlers not sufficient,Minimun 3 are required");
                    }else
                    {
                        System.out.println("wicket keepers not suffiecient,Minimum 1 is required");
                        System.out.println("No. of wicketkeepers = "+wicketkeepcount);
                    }
                    player_list.clear();
                    i=0;
                    continue;
                }
                else {
                    break;
                }
            }

        }
    }
    public static void setplayers(ArrayList<Players> player_list){
        Players player1 = new Players(1,"Shikhar Dhawan",923,67,7,0,78,"WicketKeeper");
        Players player2 = new Players(2,"Virat",786,45,5,4,27,"Bowler");
        Players player3 = new Players(3,"Ravindra Jadeja",97,19,1,4,89,"Bowler");
        Players player4 = new Players(4,"Mohammed Shami",987,15,15,4,37,"Bowler");
        Players player5 = new Players(5,"Manish Pandey",345,13,13,0,56,"Bowler");
//        Player player6 = new Player(6,"Jasprit Bumrah","Bowler",0.0,38500,400,25,32);
//        Player player7 = new Player(19,"Mayank Agarwal","Batsman",0.0,29500,400,25,32);
//        Player player8 = new Player(8,"Shreyas Iyer","Batsman",0.0,91500,400,25,32);
//        Player player9 = new Player(9,"Yuzvendra Chahal","Bowler",0.0,85500,400,25,32);
//        Player player10 = new Player(10,"KL Rahul","Wicket-Keeper",0.0,75500,400,25,32);
//        Player player11 = new Player(11,"Hardik Pandya","Batsman",0.0,92500,400,25,32);
//        Player player12 = new Player(12,"Kuldeep Yadav","Bowler",0.0,16500,400,25,32);
//        Player player13 = new Player(13,"Shardul Thakur","Bowler",0.0,7500,400,25,32);
//        Player player14 = new Player(14,"Navdeep Saini","Bowler",0.0,8500,400,25,32);
//        Player player15 = new Player(15,"Shubman Gill","Batsman",0.0,72500,400,25,32);
//        Player player16 = new Player(16,"Ajinkya Rahane","Batsman",0.0,62500,400,25,32);
//        Player player17 = new Player(17,"Ravichandran Ashwin","Bowler",0.0,22500,400,25,32);
//        Player player18 = new Player(18,"Umesh Yadav","Bowler",0.0,32500,400,25,32);
//        Player player19 = new Player(7,"MS Dhoni","Wicket-Keeper",0.0,98500,400,25,32);

        player_list.add(player1);
        player_list.add(player2);
        player_list.add(player3);
        player_list.add(player4);
        player_list.add(player5);
    }


}
class Update{
    public static void update(ArrayList<Players> player_list) throws PlayerNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter players name");
        String name = sc.nextLine();
        //sc.next();
            for (Players p:player_list){
                try {
                    if (name.equals(p.getName())) {
                        System.out.println("Enter player id");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter player name");
                        String name1 = sc.nextLine();
                        System.out.println("Enter total runs scored");
                        long tot_runs = sc.nextLong();
                        System.out.println("Enter matches played");
                        long matches = sc.nextLong();
                        System.out.println("Enter wickets taken");
                        long wickets_taken = sc.nextLong();
                        System.out.println("Enter no. of times " + name + " got out on Zero(Duck)");
                        long duck = sc.nextLong();
                        System.out.println("Enter player type");
                        String player_type = sc.next().toLowerCase();

                        double avg = ((double) tot_runs / (double) matches) + (double) wickets_taken - (double) duck;
                        int points = (int) avg;

                        p.setId(id);
                        p.setName(name1);
                        p.setTot_runs(tot_runs);
                        p.setMatches(matches);
                        p.setWickets_taken(wickets_taken);
                        p.setDuck(duck);
                        p.setAvg(avg);
                        p.setPlayer_type(player_type);
                        p.setPoints(points);

                    }
                }catch (Exception e){
                    System.out.println("Player Not Found");
                }
            }
            }
        }


public class Selection_Process {
    public static void main(String[] args) throws PlayerNotFoundException {
        int n = 5;
        ArrayList<Players> player_list = new ArrayList<>(n);
        Scanner sc = new Scanner(System.in);
        boolean update;
        int menu=0;

        while(true){
            System.out.println("\n\n");
            System.out.println("====Menu====");
            System.out.println("1.Add Players");
            System.out.println("2. Display PLayers");
            System.out.println("3. Display Team");
            System.out.println("4. Update Player");
            System.out.println("5.Exit");
            System.out.println("Enter your choice");
            menu = sc.nextInt();
        switch (menu){
            case 1:
                //Utils.addplayers(player_list,n);
                Utils.setplayers(player_list);
                break;
            case 2:
                for (Players p:player_list){
                    Utils.display(p);
                }
                break;
            case 3:
                Collections.sort(player_list,Players.playersComparator);
                ArrayList<Players> final_list = new ArrayList<>(11);
                int count =0;
                for(Players p:player_list){
                    if(count==11){
                        break;
                    }
                    final_list.add(p);
                    count++;
                }
                Utils.sortbyName(final_list);
                for(Players p:final_list){
                    Utils.display(p);
                }
                break;
            case 4:
                Update.update(player_list);
                break;
            case 5:
                System.exit(0);
        }
        }

    }
}
