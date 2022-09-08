import com.sun.corba.se.spi.orbutil.threadpool.Work;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Worker_Data {
    public Statement getStatement()

    {  Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worker", "root", "password");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }
    public int savedDetails(Worker emp){
        String sql = null;
        try{
            sql = "INSERT INTO `worker`.`Worker_Table` (`WORKER_ID`, `FIRST_NAME`, `LAST_NAME`, `SALARY`, `JOINING_DATE`, `DEPARTMENT`) VALUES " +
                    "('"+emp.getWorkerId()+"', '"+emp.getFname()+"', '"+emp.getLname()+"', '"+emp.getSal()+"', '"+emp.getJoinDate()+"', '"+emp.getDept()+"')";
            return getStatement().executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int update(Worker emp,int work_id){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("enter salary");
            Double salary=sc.nextDouble();
            System.out.println("enter department");
            String dept = sc.next();
            String sql = "update user_details set SALARY='"+salary+"',DEPARTMENT='"+dept+"' where WORKER_ID='"+work_id+"'";
            return getStatement().executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int deleteUser(Worker emp,int wid){
        try {
            String sql = "delete from Worker_table where WORKER_ID="+wid+" ";
            return getStatement().executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int query1(){
        List<String> fullname = new ArrayList<>();
        try {
            String sql =  "SELECT UPPER(CONCAT(FIRST_NAME,' ',LAST_NAME)) AS FULL_NAME FROM Worker_Table";
            ResultSet rs =  getStatement().executeQuery(sql);
            while (rs.next()){
                fullname.add(rs.getString(1));
            }
            System.out.println(fullname);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int query2(){
        try {
            List<String> dept = new ArrayList<>();
            String sql =  "SELECT DISTINCT(DEPARTMENT) FROM Worker_Table";
            ResultSet rs =  getStatement().executeQuery(sql);
            while (rs.next()){
                dept.add(rs.getString(1));
            }
            System.out.println(dept);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int query3(){
        String sql=null;
        try {
            sql = "select position('a' in first_name) from Worker_Table where WORKER_ID=4;";
            ResultSet rs = getStatement().executeQuery(sql);
            if(rs.next())
                System.out.println(rs.getInt(1));
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public List<Worker> getAllEmp(){
        List<Worker> empList = new ArrayList<Worker>();

        try{
            String sql = "select * from Worker_Table";
            ResultSet rs = getStatement().executeQuery(sql);

            while(rs.next()){
                Worker emp = new Worker();
                emp.setWorkerId(rs.getInt(1));
                emp.setFname(rs.getString(2));
                emp.setLname(rs.getString(3));
                emp.setSal(rs.getDouble(4));
                emp.setJoinDate(rs.getDate(5));
                emp.setDept(rs.getString(6));
                empList.add(emp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return empList;
    }


}
