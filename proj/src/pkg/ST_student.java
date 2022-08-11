package pkg;
import java.util.Scanner;
class Dem{
	private int roll;
	private String name;
	public Dem(int a,String n)
	{
		name = n;
		roll = a;
		
	}
	public void disp()
	{
		System.out.println("Name = "+ name);
		System.out.println("roll no = "+ roll);
	}
}

public class ST_student {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter roll no.");
		int roll = sc.nextInt();
		System.out.println("enter name");
		String name = sc.next();
		Demo obj = new Demo(roll, name);
		obj.disp();
	}
}