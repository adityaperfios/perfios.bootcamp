package com.text;
import java.util.Scanner;
import com.perfs.Modifiers;
public class Ip_op {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your name");
	String name = sc.nextLine();
	
	System.out.println("Enter company");
	String cmp = sc.next();
	
	System.out.println("Enter City ");
	String city = sc.next();
	
	System.out.println("enter mobile number ");
	long mob = sc.nextLong();
	
	System.out.println("=================================");
	System.out.println("Name : "+ name);
	System.out.println("Works in : "+ cmp);
	System.out.println("Lives in : "+ city);
	System.out.println("Mobile no.: "+ mob);
	System.out.println("=================================");
	
	Modifiers obj = new Modifiers();
	System.out.println("accesing from another package"+obj.a);
	
	
	
}
}
