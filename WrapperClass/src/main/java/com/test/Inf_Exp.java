package com.test;
@FunctionalInterface
interface FunInf{
    void message(String msg);
}
public class Inf_Exp {
    public static void main(String[] args) {
        FunInf obj = (String msg) -> System.out.println("Text : "+msg);
        FunInf obj1 = (String msg) -> System.out.println("Email : "+msg);
        obj.message("Plain text");
        obj1.message("example@perfios.com");

        FunInf obj2 = new FunInf() {
            @Override
            public void message(String msg) {
                System.out.println(msg);
            }
        };
        obj2.message("java");
    }
}
