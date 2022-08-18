package com.test;
class A{
    int id = 30;
    String name = "Dilip";
    public void disp()
    {
        System.out.println(name+" is employee no. "+id);
    }
}

class B extends A{
    String city = "Blr";
    public void userdets()
    {
        System.out.println(name+" lives in "+city+" and has id no. "+id);
    }
}

class C extends B{
    int Salary = 60000;
    public void salary(){
        System.out.println(name+" gets Rs. "+Salary);
    }
}
public class Inherit_exp {
    public static void main(String[] args) {
        C obj = new C();
        obj.disp();
        obj.userdets();
        obj.salary();
    }
}
