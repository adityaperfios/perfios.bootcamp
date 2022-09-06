import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prg2 {
    public static void main(String[] args)throws Exception
    {
        //load the driver
        Class.forName("com.mysql.jdbc.Driver");
        //connection URL
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios","root","password");
        //statement
        Statement st=con.createStatement();
        //querry
        ResultSet rs = st.executeQuery("select * from student");
        while (rs.next()){
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
        }
        System.out.println();
    }
}
