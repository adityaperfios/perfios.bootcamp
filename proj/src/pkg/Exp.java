package pkg;

class SingleTn 
{
	static SingleTn obj = null;
	private SingleTn()
	{
		
	}
	
	public static SingleTn getobj()
	{
		if(obj == null)
		{
			obj = new SingleTn();
		}
		return obj;
	}
	
}

public class Exp {
	public static void main(String[] args)
	{
		SingleTn obj = SingleTn.getobj();
		System.out.println(obj.hashCode());
		SingleTn obj1 = SingleTn.getobj();
		System.out.println(obj.hashCode());
	}
}
