package app1;

import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a value");
		int x = sc.nextInt();
		
		String v1 = "300";
		String v2 = "200";
		
		System.out.println(v1+v2);
		
		//int x = Integer.parseInt(v1);
		int y = Integer.parseInt(v2);
		
		System.out.println(x+y);
		sc.close();
	}
}
