package com.company;


import java.util.Scanner;

public class left_triangles {

    static public double left_triangles(double a, double b, int n){
        double h = (b-a)/n;
        double f, result=0;
        for (double i = a; i < b; i += h) {
            //f = 1/(Math.log(i));
            f = Math.cos(i);
            result +=f;
        }
        result = result *h;
        return result;
    }

    static public double right_triangles(double a, double b, int n){
        double h = (b-a)/n;
        double f, result=0;
        for (double i = a+h; i <= b; i += h) {
            //f = 1/(Math.log(i));
            f = Math.cos(i);
            result +=f;
        }
        result = result *h;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input a: ");
        double a = in.nextDouble();
        System.out.println("Input b: ");
        double b = in.nextDouble();
        System.out.println("Input n: ");
        int n = in.nextInt();

        double result = left_triangles(a,b,n);
        double result2 = right_triangles(a,b,n);
        System.out.println("LEFT S = " + result);
        System.out.println("RIGHT S = " + result2);
    }
}
