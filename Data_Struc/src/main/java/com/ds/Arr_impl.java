package com.ds;
import java.util.Scanner;

public class Arr_impl {
    public static void main(String[] args) {
        int [] arr = new int[5];
        int [] revarr = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the elements of array");
        for (int i=0;i<5;i++)
        {
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<5;i++)
        {
            System.out.println("element "+(i+1)+" is "+arr[i]);
        }
        int count = arr.length;
        System.out.println("length = "+arr.length);

        int j = 0;
        for(int i=arr.length;i>0;i--)
        {
            revarr[j] = arr[i-1];
            j++;
            if(j==arr.length)
                break;

        }
        for(int i=0;i<5;i++)
        {
            System.out.println("reversed element "+(i+1)+" is "+revarr[i]);
        }

    }
}
