package banking_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banking_utils {
    public Statement getStatement()
    {  Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_app", "root", "password");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public int saveDetails(Acc_Details user){
        String sql = null;
        try{
            sql = "insert into user_details values('"+user.getName()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getAcc_no()+
                    "','"+user.getAmount()+"','"+user.getAddress()+"','"+user.getEmail()+"','"+user.getPhone_no()+"')";
            return getStatement().executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int update(int acc_no){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("enter username");
            String username=sc.next();
            System.out.println("enter address");
            String address = sc.nextLine();
            sc.next();
            System.out.println("enter phone no ");
            long phn = sc.nextLong();
            System.out.println("enter email");
            String email = sc.next();
            String sql = "update user_details set username='"+username+"',address='"+address+"',email='"+email+"',phone_no='"
                    +phn+"' where acc_no='"+acc_no+"'";
            return getStatement().executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int deleteUser(Acc_Details user,long acc_no){
        try {
            String sql = "delete from user_details where acc_no="+acc_no+" ";
            return getStatement().executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public List<Acc_Details> getAllUser(){
        List<Acc_Details> userList = new ArrayList<Acc_Details>();

        try{
            String sql = "select * from user_details";
            ResultSet rs = getStatement().executeQuery(sql);

            while(rs.next()){
                Acc_Details user = new Acc_Details();
                user.setName(rs.getString(1));
                user.setUsername(rs.getString(2));
                user.setAcc_no(rs.getLong(4));
                user.setAmount(rs.getDouble(5));
                user.setAddress(rs.getString(6));
                user.setEmail(rs.getString(7));
                user.setPhone_no(rs.getLong(8));
                userList.add(user);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }
}
