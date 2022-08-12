package Assignment;
import java.util.Scanner;
import Assignment.Stud;
public class Stu2 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("entering roll no. from diff class");
	int roll = sc.nextInt();
	System.out.println("enter name from diff class");
	String name = sc.next();
	System.out.println("enter email from diff class");
	String email = sc.next();
	System.out.println("enter phone from diff class");
	long phone = sc.nextLong();
	Dem obj = new Dem(roll, name, phone, email);
	obj.disp();
	}
}
