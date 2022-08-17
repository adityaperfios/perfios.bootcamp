package StrPrac;

public class StrPrac {
	public static void main(String[] args) {
		String str1 = "java" ;
		String str2 = "java";
		String str3 = "Hello";
		String str4 = "hello";
		String revstr = "";
		String str5 = new String("java");
		String str6 = new String("hello");
		
		System.out.println("str1 "+str1.hashCode());
		System.out.println("str2 "+str2.hashCode());
		System.out.println(str5 == str1);
		System.out.println(str5.equals(str1));
		System.out.println(str1.length());
		
		for(int i=str1.length()-1;i>=0;i--)
		{
			revstr = revstr + str1.charAt(i);
			//System.out.print(str1.charAt(i));
		}
		System.out.println("reverse of string "+str1+" is "+revstr);
		str1 = str1.concat(" test");
		str1.concat(" concat");//this wont't work for string as no new object is being created
		System.out.println(str1);
		
		StringBuffer sb = new StringBuffer(str1);
		sb.append(" world");
		System.out.println("sb = "+sb);
		System.out.println(sb.capacity());
		
	}
}
