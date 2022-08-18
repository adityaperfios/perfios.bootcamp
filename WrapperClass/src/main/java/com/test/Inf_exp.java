package com.test;

interface Inf{
    void dog();
    interface Inf3{
        void horse();
    }
    interface Inf2{
        void sub();
    }
    default void cat(){
        System.out.println("default method");
    }

    static void fox()//can't access through object of Normal class
    {
        System.out.println("static method");
    }
}
@FunctionalInterface
interface func{
    void horse();
}
abstract class AB{
    public void disp(){
        System.out.println("Abstract class default method");
    }
    public abstract void human();
}

class Normal extends AB implements Inf
{
    public void human(){
        System.out.println("human overridden");
    }

    public void dog()
    {
        System.out.println("interface method overridden");
    }

}

class Exp extends Normal implements Inf.Inf2{
    public void sub(){
        System.out.println("nested interface sub method");
    }
}
public class Inf_exp {
    public static void main(String[] args) {
        Exp obj = new Exp();
        obj.dog();
        obj.cat();
        obj.disp();
        obj.human();
        obj.sub();
        Inf.fox();
    }
}
