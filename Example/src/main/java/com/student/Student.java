package com.student;

public class Student {
    public int voting(int age)
    {   int flag = 0;
        if(age>=18){
            flag = 1;
            //System.out.println("eligible for voting");
        }
        else{
            //System.out.println("not eligible for voting");
        }
        return flag;
    }
    public char validgrade(int marks)
    {
        char grade;
        if(marks>90)
            grade = 'A';
        else if (marks>80&&marks<=90) {
            grade = 'B';}
            else if(marks>70&&marks<=80){
                grade = 'C';
            }
            else {
                grade = 'D';
        }
            return grade;
    }
}

