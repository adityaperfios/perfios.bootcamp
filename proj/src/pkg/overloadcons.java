package pkg;

class Book{
	public Book()
	{
		this("java");
		System.out.println("default");
	}
	public Book(String str)
	{	
		this(22);
		System.out.println("str cons");
	}
	public Book(int a) {
		System.out.println("int cons");
	}
}

public class overloadcons {
	public static void main(String[] args) {
		Book obj = new Book();
	}
}
