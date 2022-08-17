package StrPrac;

public class Sub {
public static void main(String[] args) {
	String str1 = "java is a programming lang  ";
	StringBuffer strb = new StringBuffer("javatest");
	String str2 = str1.substring(1,9);
	System.out.println(str2);
	String str3 = str1.replace(" ", "");
	System.out.println(str3);
	str1 = str1.trim();
	char[] b = str1.toCharArray();
	for(char x: b)
	{
		System.out.println("element "+x);
	}
	System.out.println(strb.capacity());
	
	strb.append(" testtesttesttesttesttesttesttest");
	System.out.println(strb.capacity());
	
}
}
