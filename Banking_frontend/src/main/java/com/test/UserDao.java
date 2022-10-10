//package com.test;
//
//import java.sql.Statement;
//
//public class UserDao {
//public int saveUser(User user) {
//	Statement stmt = null;
//	String sql = null;
//	try {
//	sql = "insert into b_user values('"+user.getUserName()+"','"+user.getPassword()+"')";
//	stmt = Util.getConnection().createStatement();
//	return stmt.executeUpdate(sql);
//		}
//	catch(Exception e) {
//		e.printStackTrace();
//		return 0;
//	}
//}
//
//}
package com.test;
import java.sql.*;
public class UserDao {
	//sql layer~data access
	
	public static int saveUser(User user) {
		
		java.sql.Statement stmt=null;
		String sql = null;
		
		try {
		
//		sql="insert into Connection values('"+user.getUserName()+"','"+user.getPassword()+"')";
		
//		sql="insert into Connection values('Gokuk','gfihb')";
			
		sql="INSERT INTO user_details (name,username,password,amount,address,email,phone_no,gender) VALUES ('" + user.getName() + "','"+user.getUserName()+"','" + user.getPassword() + "','" + user.getAmount() + "','" + user.getAddress() + "','" + user.getEmail() + "','" + user.getPhn_no() +"','"+ user.getGender()+"')";
//		sql="insert into BankData ('Name','Password','Address','Amount','Phone','Email','AccType') VALUES('dfg','dfg','dfgdfg','asdfgd','adfgsd','adfgdsd','456465465');";
//			sql="SELECT * FROM BankData";
//		sql="INSERT INTO BankData (`Name`, `Password`, `Address`, `Amount`, `Phone`, `Email`, `AccType`) VALUES('mp', 'mm', 'mm', 'mm', 'mm', 'mm', 'mm')";
			
		stmt = Util.getConnection().createStatement();
		return stmt.executeUpdate(sql);
//		return stmt.executeQuery(sql);
		
	}
	catch(Exception e) {
		e.printStackTrace();
		return 0;
	}
	}
 public static boolean login(String user,String pass) throws Exception {
	
	String sql="SELECT * FROM user_details";
	boolean login_flag=false;
	java.sql.Statement stmt=Util.getConnection().createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	while(rs.next()) {
		if(rs.getString(2).equals(user) && rs.getString(3).equals(pass)) {
			System.out.println("Successful Login");
			login_flag = true;
			break;
		}
		else {
			//System.out.println("Invalid user,Please Register");
		}
		
	}
	return login_flag;
	
 }
}