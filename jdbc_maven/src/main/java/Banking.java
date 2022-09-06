import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Banking {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios", "root", "password");
/*PreparedStatement st=con.prepareStatement("create table studentbatch229(empno int,name varchar(30),"
		+ "address varchar(30),phoneno varchar(30)) ");
st.execute();
System.out.println("table created");*/


        Scanner ob = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice 1.Insert 2.update 3.delete 4.Display 5.Deposit 6. Withdraw 7. Exit");
            int choice = ob.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("enter name,address,Balance");
                    //int empno = ob.nextInt();
                    String Name = ob.next();
                    String Address = ob.next();
                    double Balance = ob.nextDouble();
                    PreparedStatement st = con.prepareStatement("insert into Banking(Name,Address,Balance) values(?,?,?)");
                    //st.setInt(1, empno);
                    st.setString(1, Name);
                    st.setString(2, Address);
                    st.setDouble(3, Balance);
                    st.execute();
                    System.out.println("row inserted");
                    break;
                }
                case 2: {
                    System.out.println("enter Name,address, and accno to update");

                    String Address = ob.next();
                    String Name = ob.next();
                    //double Balance = ob.nextDouble();
                    int Accno = ob.nextInt();
                    PreparedStatement st = con.prepareStatement("update Banking set Address=? , Name=? where Accno=?");
                    st.setString(1, Address);
                    st.setString(2, Name);
                    st.setInt(3, Accno);
                    //st.setInt(3, empno);
                    st.execute();
                    System.out.println("row updated");
                    break;
                }
                case 3: {
                    System.out.println("enter empno to delete");
                    int empno = ob.nextInt();
                    PreparedStatement st = con.prepareStatement("delete from Banking where empno=?");
                    st.setInt(1, empno);
                    st.execute();
                    System.out.println("row deleted");
                    break;
                }
                case 4: {
                    PreparedStatement st = con.prepareStatement("select * from Banking");
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                    }
                    break;
                }
                case 5: {

                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter acc no to deposit");
                    int acc = sc.nextInt();
                    double old_ammount = 0;
                    System.out.println("Enter amount to deposit");
                    double amount = sc.nextDouble();
                    PreparedStatement pst = con.prepareStatement("select Balance from Banking where Accno=?");
                    pst.setInt(1, acc);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        old_ammount = rs.getDouble(1);
                    }
                    amount = amount + old_ammount;
                    PreparedStatement st = con.prepareStatement("update Banking set Balance=? where Accno=?");
                    st.setDouble(1, amount);
                    st.setInt(2, acc);
                    st.execute();
                    System.out.println("Balance updated");

                }
                break;
                case 6: {

                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter acc no to withdraw");
                    int acc = sc.nextInt();
                    double old_ammount = 0;
                    System.out.println("Enter amount to withdraw");
                    double amount = sc.nextDouble();
                    PreparedStatement pst = con.prepareStatement("select Balance from Banking where Accno=?");
                    pst.setInt(1, acc);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        old_ammount = rs.getDouble(1);
                    }
                    if(old_ammount>amount)
                    {
                        if(old_ammount-amount<1000){
                            System.out.println("Can't withdraw minimum balance requirement failed");
                            break;
                        }
                        else {
                            amount =  old_ammount - amount;
                        }
                    }
                    PreparedStatement st = con.prepareStatement("update Banking set Balance=? where Accno=?");
                    st.setDouble(1, amount);
                    st.setInt(2, acc);
                    st.execute();
                    System.out.println("Balance updated");

                }
                break;
                case 7: {
                    System.exit(1);
                }
                default:
                    System.out.println("wrong input");
            }
        }
    }
}