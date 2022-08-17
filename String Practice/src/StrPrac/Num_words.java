package StrPrac;
import java.util.Scanner;
public class Num_words {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter a string");
	String str = sc.nextLine();
	str = str.trim();
	int count = 0;
	for(int i=0;i<str.length();i++)
	{
		char ch = str.charAt(i);
		if(ch==' ')
		{
			count++;
		}
	}
	System.out.println("no. of words = "+(count+1));
	sc.close();
}
}
