package pkg;

public class Methodch {
	public void method1()
	{
		System.out.println("Method 1");
		method2();
	}
	public void method2()
	{
		System.out.println("Method 2");
		method3();
	}
	public void method3()
	{
		System.out.println("Method 3");
	}
	public static void main(String[] args) {
		Methodch obj = new Methodch();
		obj.method1();
	}
}
