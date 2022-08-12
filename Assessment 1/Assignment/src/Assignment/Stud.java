package Assignment;

import java.util.Scanner;
class Dem{
	private int roll;
	private String name;
	private String email;
	private long ph;
	public String dob;
	public Dem(int a,String n,long phone,String em)
	{
		name = n;
		roll = a;
		ph = phone;
		email = em;
		
	}
	public void disp()
	{
		System.out.println("Name = "+ name);
		System.out.println("roll no = "+ roll);
		System.out.println("Phone = "+ ph);
		System.out.println("email = "+ email);
	}
}

public class Stud {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter roll no.");
		int roll = sc.nextInt();
		System.out.println("enter name");
		String name = sc.next();
		System.out.println("enter email");
		String email = sc.next();
		System.out.println("enter phone");
		long phone = sc.nextLong();
		Dem obj = new Dem(roll, name, phone, email);
		obj.disp();
	}
}