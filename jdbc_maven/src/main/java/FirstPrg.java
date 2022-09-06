import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FirstPrg {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios", "root", "password");
/*PreparedStatement st=con.prepareStatement("create table studentbatch229(empno int,name varchar(30),"
		+ "address varchar(30),phoneno varchar(30)) ");
st.execute();
System.out.println("table created");*/
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter your choice 1.Insert 2.update 3.delete 4.select");
        int choice = ob.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("enter empno,name,address,phoneno");
                int empno = ob.nextInt();
                String name = ob.next();
                String address = ob.next();
                String phoneno = ob.next();
                PreparedStatement st = con.prepareStatement("insert into studentbatch values(?,?,?,?)");
                st.setInt(1, empno);
                st.setString(2, name);
                st.setString(3, address);
                st.setString(4, phoneno);
                st.execute();
                System.out.println("row inserted");
                break;
            }
            case 2: {
                System.out.println("enter address, phoneno and empno to update");
                String address = ob.next();
                String phoneno = ob.next();
                int empno = ob.nextInt();
                PreparedStatement st = con.prepareStatement("update studentbatch229 set address=? , phoneno=? "
                        + "where empno=?");
                st.setString(1, address);
                st.setString(2, phoneno);
                st.setInt(3, empno);
                st.execute();
                System.out.println("row updated");
                break;
            }
            case 3: {
                System.out.println("enter empno to delete");
                int empno = ob.nextInt();
                PreparedStatement st = con.prepareStatement("delete from studentbatch229 where empno=?");
                st.setInt(1, empno);
                st.execute();
                System.out.println("row deleted");
                break;
            }
            case 4: {
                PreparedStatement st = con.prepareStatement("select * from studentbatch229");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + rs.getString(4));
                }
                break;
            }
            default:
                System.out.println("wrong input");
        }
    }
}