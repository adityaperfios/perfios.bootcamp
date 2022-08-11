package pkg;
import java.util.Scanner;
public class Class1 implements Cloneable{

	int id = 101;
	static int pin = 123456;
	public void display() {
		System.out.println(id+" "+pin);
	}
	public int ip()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the id you want");
		int a = sc.nextInt();
		return a;
	}
	//factory method without parameter
	public Class1 getobj() {
		return new Class1();
	}
	//using new operator
	public static void main(String[] args) throws Exception {
		Class1 obj = new Class1();
		obj.display();
		System.out.println(obj);
		System.out.println(obj.hashCode());
		Class1 obj1 = obj.getobj();
		System.out.println(obj1);
		System.out.println(obj1.hashCode());
		obj.id = obj.ip();
		System.out.println("after changing ");
		obj.display();
		//clone method		
		Class1 clobj = (Class1) obj.clone();
		System.out.println(clobj);
		System.out.println(clobj.hashCode());
	}
}

