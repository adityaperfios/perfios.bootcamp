package ques2;
import java.util.Scanner;
public class Findpair {
    public static void getPairs(int[] arr, int sum)
    {
         int count = 0;
        for (int i = 0; i < arr.length; i++)
            {for (int j = i + 1; j < arr.length; j++)
                {if ((arr[i] + arr[j]) == sum)
                	{ 
                	 System.out.println("count of pair = "+(count+1));
                	 System.out.println("1stnum = "+arr[i]+" 2ndnum = "+arr[j]);
                     count++;
                	}
                }
            }
        System.out.printf("Count of pairs is %d", count);
    }
    public static void main(String args[])
    {	
    	System.out.println("enter size of array");
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	System.out.println("enter array elements");
    	int[] arr = new int[n];
	    for(int i=0;i<n;i++)
	    {
	    	arr[i] = sc.nextInt();
	    }
	    System.out.println("enter target");
        int sum = sc.nextInt();
        getPairs(arr, sum);
    }
}
