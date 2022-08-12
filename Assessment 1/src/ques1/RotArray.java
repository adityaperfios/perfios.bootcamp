package ques1;
import java.util.Scanner;
public class RotArray {
	static void Rightrot(int ar[],int n,int k)
	{
		for(int i = 0; i < n; i++)
	    {
	        if(i<k)
	        {
	            System.out.print(ar[n + i - k]
	                             + " ");
	        }
	        else
	        {
	            System.out.print(ar[i - k]
	                             + " ");
	        }
	    }
	    System.out.println();
	}
	public static void main(String args[])
	{
	    System.out.println("enter the length of array");
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int[] Array = new int[N];
	    System.out.println("enter array elements");
	    for(int i=0;i<N;i++)
	    {
	    	Array[i] = sc.nextInt();
	    }
	    System.out.println("enter size of rotation");
	    int K = sc.nextInt();
	    Rightrot(Array, N, K);
	 
	}
	}

