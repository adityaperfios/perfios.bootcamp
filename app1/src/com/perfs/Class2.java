package com.perfs;
//import com.perfs.Modifiers;

public class Class2 {
	
	public void disp(Class3 obj)
	{
		System.out.println("Accessing public var (a) of class modifiers "
				+ "through Class2 "+obj.a);
		System.out.println("Accessing protected var (z) of class modifiers "
				+ "through Class2 "+obj.z);
	}
	public static void main(String[] args) {
		//Modifiers obj = new Modifiers();
		Class2 obj2 = new Class2();
		Class3 obj3 = new Class3();
		obj3.display();
		obj2.disp(obj3);
		obj3.disp();
				
	}
}

class Class3 extends Modifiers
{	
	public void disp() {
		System.out.println("without object calling protec var "+z);
		System.out.println("accessing default var (y)"+y);
		System.out.println("accessing protected var (z)"+ z);
}
	}
