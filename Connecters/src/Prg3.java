import java.sql.*;
import java.util.*;

public class Prg3 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios","root","password");
        Scanner obj = new Scanner(System.in);
        System.out.println("enter rollno,name,address");
        int rollno =obj.nextInt();
        String name=obj.next();
        String address = obj.next();
        PreparedStatement st = con.prepareStatement("insert into student values(?,?,?)");
        st.setInt(1,rollno);
        st.setString(2,name);
        st.setString(3,address);
        st.execute();
        System.out.println("row inserted");
    }
}
