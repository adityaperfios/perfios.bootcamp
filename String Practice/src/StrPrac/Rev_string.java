package StrPrac;
import java.util.Scanner;
public class Rev_string {

	public static void main(String[] args) {
	
		System.out.println("enter a string");
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		StringBuffer str = new StringBuffer(string);
		StringBuffer strchk = new StringBuffer(string);
		StringBuffer Rev_str = str.reverse();
		if(strchk == Rev_str)
		{
			System.out.println("it is a palindrome");
			
		}
		else
		{
			System.out.println("not a palindrome");
		}
}
}
