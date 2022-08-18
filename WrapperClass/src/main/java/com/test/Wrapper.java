package com.test;

public class Wrapper {
    public static void main(String[] args) {

        String v1 = "100";
        String v2 = "300";

        System.out.println("string = "+v1+v2);

        int x = Integer.parseInt(v1);
        int y = Integer.parseInt(v2);

        System.out.println("integer = "+(x+y));

        float j = Float.parseFloat(v1);
        float k = Float.parseFloat(v2);

        System.out.println("Float = "+(j+k));

        boolean bl = Boolean.parseBoolean(v1);
        System.out.println("Boolean = "+ bl);
    }
}
