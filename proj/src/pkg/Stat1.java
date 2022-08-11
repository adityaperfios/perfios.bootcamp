package pkg;

class Stat {
	static
	{
		System.out.println("static block");
	}
	public Stat()
	{
		System.out.println("Constructor");
	}
	{
		System.out.println("instance block");
	}
}
public class Stat1 {
	public static void main(String[] args) {
		Stat obj = new Stat();
		System.out.println("main method");
		
	}
	
}