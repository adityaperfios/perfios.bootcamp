package ques3;
import java.util.Scanner;
public class BalancePara {
	int count;
	public static void main(String[] args) {
		System.out.println("enter a string including paranthesis");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int count = 0;
		int check = 0;
		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			if(ch == '(')
				count++;
			else if(ch == ')')
				count--;
			
			if(count < 0)
			{
				System.out.println("A paranthesis closed before opening\nString isn't balanced exiting");
				break;
			}
		}
		if(check == 0 && count == 0)
		{
			System.out.println("String is balanced");
		}
		else
			System.out.println("String not balanced");
		sc.close();
	}
}
