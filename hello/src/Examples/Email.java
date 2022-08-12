package Examples;
import java.util.Scanner;
class data{
	private String email = null;
	
	public data()
	{
		
	
	}
	public data(String email)
	{
		this.email = email;
	}
	public String getemail()
	{ 
		return email;	
	}
	public void setemail(String email)
	{
		this.email = email;
	}
}


public class Email {
	public static void main(String[] args) {

	data[] email_ar = new data[5];
	data std = new data("simple");
	email_ar[0] = std;
	Scanner sc = new Scanner(System.in);
	System.out.println("enter an email id");
	String uem = sc.next();
	int flag = 0;
	int count = 1;
	
	for(data obj : email_ar)
	{   if(obj != null)
		{ 
		count++;
		System.out.println("count = "+count);
		if(obj.getemail()==uem) {
			flag = 1;
		}
		}
		
	}
	if(flag == 0) {
		System.out.println("Email not found adding new email to array");
		email_ar[count] = new data();
		email_ar[count].setemail(uem);
	}
	else if(flag==1)
	{
		System.out.println("the email exists already\n");
	}
	for(data obj:email_ar) {
		String er = obj.getemail();
		System.out.println(er);
	}
	}	
}
