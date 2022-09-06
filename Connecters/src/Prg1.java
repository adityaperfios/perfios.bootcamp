import java.sql.*;
public class Prg1 {
    public static void main(String[] args)throws Exception
    {
        //load the driver
        Class.forName("com.mysql.jdbc.Driver");
        //connection URL
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios","root","password");
        //statement
        Statement st=con.createStatement();
        //querry
        st.execute("insert into bank(name,address) values('geeta','hydrabad')");
        st.execute("update student set address='chennai' where rollno=101 ");
        st.execute("insert into bank(name,address) values('devesh','lucknow')");
        System.out.println("row inserted");
    }
}
