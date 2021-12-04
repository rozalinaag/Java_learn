package com.company;

/**
 * Передача лямбда-выражения аргументом методу
 */

interface MyFunction{
    double f(double x);
}

public class listing10_9 {

    //static method for calculating the integral
    static double integrate(MyFunction obj, double a, double b){

        int n=100; //number of internal intervals
        double h = (b-a)/n; //step
        double s = (obj.f(a) + obj.f(b))*h/2; //integral sum
        for (int k = 1; k <= n-1; k++) {
            s+= h*obj.f(a+k*h);
        }
        return s; //integral value
    }

    public static void main(String[] args) {

        //for calculating integrals we use static method - integrate(), which we describe above.
        System.out.print(integrate((double x)->{return x*(1-x);},0,1));
        System.out.println(" - reality meanings " + 1.0/6);

        System.out.print(integrate((double x)->{return 1/x;},1,2));
        System.out.println(" - reality meanings " + Math.log(2));

        System.out.print(integrate((double x)->{return Math.exp(-x);},0,10));
        System.out.println(" - reality meanings " + (1-Math.exp(-10)));

    }
}
