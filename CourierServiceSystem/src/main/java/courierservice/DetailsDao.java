package courierservice;

import courierservice.Details;
import courierservice.Util;

public class DetailsDao {
public static int saveUser(Details user) {
		
		java.sql.Statement stmt=null;
		String sql = null;
		
		try {
		
//		sql="insert into Connection values('"+user.getUserName()+"','"+user.getPassword()+"')";
		
//		sql="insert into Connection values('Gokuk','gfihb')";
			
		sql="INSERT INTO courier_details (customer_name,city,phone,delivery_area,weight,ratepergram,booking_date,delivery_date,amount) VALUES ('" + user.getCust_name() + "','"+user.getCity()+"','" +user.getPhn()+"','"+ user.getDelivery_area() + "','" + user.getWt() + "','" + user.getRpg() + "','" + user.getBook_date() + "','" + user.getDel_date()+ "','"+user.getPay_amt()+"')";
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

}
