package com.ds;
import java.util.Scanner;
public class Exp12 {
    public static void main(String[] args) {
        int[][] ar = new int[3][3];
        Scanner sc = new Scanner(System.in);
        //int [][] arr = {{10,20,30}, {40,50,60}, {70,80,90}};
        //System.out.println(arr[0][0]);
        System.out.println("enter data for 2d array");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.println("a["+i+"]"+"["+j+"]");
                ar[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix is : ");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                int num = ar[i][j];
                for (int k = 0;k<3;k++)
                {
                    for (int l = 0;l<3;l++){
                        if(i==k && j==l){
                            continue;
                        }
                        if(num == ar[k][l]){
                            System.out.println("duplicate found at ("+i+" "+j+") and ("+k+" "+l+") the value is ="+ar[i][j]);
                        }
                    }
                }
                //System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }

}
