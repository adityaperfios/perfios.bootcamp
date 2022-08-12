package Assignment;

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

public class SigTn {
	public static void main(String[] args)
	{
		SingleTn obj = SingleTn.getobj();
		System.out.println("Hashcode of object created through single ton method = "+obj.hashCode());
		SingleTn obj1 = SingleTn.getobj();
		System.out.println("hashcode of object created normally = "+obj.hashCode());
	}
}
