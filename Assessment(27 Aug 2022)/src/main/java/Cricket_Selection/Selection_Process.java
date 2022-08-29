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
//        System.out.println("Serial No. ");
        System.out.println("Id : "+p.getId());
        System.out.println("Name : "+p.getName());
        System.out.println("Total Runs : "+p.getTot_runs());
        System.out.println("Total Matches : "+p.getMatches());
        System.out.println("Wickets Taken : "+p.getWickets_taken());
        System.out.println("Out on zero : "+p.getDuck());
        System.out.println("Current Avg : "+p.getAvg());
        System.out.println("Player Type : "+p.getPlayer_type());
        System.out.println();

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
        Players player6 = new Players(6,"Jasprit Bumrah",546,21,22,5,87,"Bowler");
        Players player7 = new Players(19,"Mayank Agarwal",322,17,11,9,34,"Batsman");
        Players player8 = new Players(8,"Shreyas Iyer",877,67,31,17,91,"Batsman");
        Players player9 = new Players(9,"Yuzvendra Chahal",133,9,15,7,32,"Bowler");
        Players player10 = new Players(10,"KL Rahul",743,89,0,15,77,"WicketKeeper");
        Players player11 = new Players(11,"Hardik Pandya",655,45,23,0,100,"Batsman");
        Players player12 = new Players(12,"Kuldeep Yadav",333,21,3,6,28,"Allrounder");
        Players player13 = new Players(13,"Shardul Thakur",675,58,14,17,30,"Bowler");
        Players player14 = new Players(14,"Navdeep Saini",223,34,2,4,25,"Bowler");
        Players player15 = new Players(15,"Shubman Gill",651,43,0,4,41,"Batsman");
        Players player16 = new Players(16,"Ajinkya Rahane",451,33,62,7,69,"Batsman");
        Players player17 = new Players(17,"Ravichandran Ashwin",121,23,22,12,75,"Bowler");
        Players player18 = new Players(18,"Umesh Yadav",99,4,32500,12,65,"Bowler");
        Players player19 = new Players(19,"MS Dhoni",345,8,9,7,87,"Bowler");
        Players player20 = new Players(20,"Risabh Pant",876,78,14,16,67,"Bowler");

        player_list.add(player1);
        player_list.add(player2);
        player_list.add(player3);
        player_list.add(player4);
        player_list.add(player5);
        player_list.add(player6);
        player_list.add(player7);
        player_list.add(player8);
        player_list.add(player9);
        player_list.add(player10);
        player_list.add(player11);
        player_list.add(player12);
        player_list.add(player13);
        player_list.add(player14);
        player_list.add(player15);
        player_list.add(player16);
        player_list.add(player17);
        player_list.add(player18);
        player_list.add(player19);
        player_list.add(player20);
    }


}
class Update{
    public static void update(ArrayList<Players> player_list) throws PlayerNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter players name");
        String name = sc.nextLine().toLowerCase();
        //sc.next();
            for (Players p:player_list){
                try {
                    if (name.equals(p.getName().toLowerCase())) {
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
                    else {
                        throw new PlayerNotFoundException("Player not found");
                    }
                }
                catch (PlayerNotFoundException ex){
                    System.out.println("Player Not found");
                }
                catch (Exception e){
                    System.out.println("Something went wrong");
                }

            }
        System.out.println("player not found");
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
