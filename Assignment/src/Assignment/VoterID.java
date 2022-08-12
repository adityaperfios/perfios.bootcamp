package Assignment;
import java.util.Scanner;
public class VoterID {
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter name of the person");
	String name = sc.next();
	System.out.println("enter age");
	int age = sc.nextInt();
	
	if(age>=18)
	{ System.out.println(name+" is eligible for voter id card");
	
	}
	else
		System.out.println(name+" is not eligible");
}
}
