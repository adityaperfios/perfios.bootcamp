package pkg;

class Cons {
	//default cons
	public Cons()
	{
		System.out.println("default constructor");
	}
	//parametrised
	public Cons(int a)
	{
		System.out.println("parametrised cons");
	}
	//overloaded
	public Cons(String a)
	{
		System.out.println("overloaded ");
	}
	public Cons(Emp a)
	{
		System.out.println("object parametrised cons");
	}
	
	
}

public class Emp
{
	public static void main(String[] args) {
		Cons obj = new Cons(5);
		System.out.println("in main block");
	}
	
}