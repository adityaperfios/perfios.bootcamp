package StrPrac;

import java.util.Scanner;

public class Remove_occurance {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter a string");
	String str = sc.nextLine();
	System.out.println("enter char to be removed");
	String str1 = sc.next();
	char target = str1.charAt(0);
	str = str.trim();
	StringBuffer Final = new StringBuffer("");
	char[] b = str.toCharArray();
	for(char x:b)
	{
		if(x!=target)
		{
			Final.append(x);
		}
	}
	System.out.println("Without char string = "+Final);
}
}
