package com.company;

/**
 * Lambda expression and method result.
 * The task of calculating the derivative for a function.
 *
 * Лямбда-выражение и результат метода.
 * Задача о вычислениии производной для функции.
 */

interface MyFunction{
    //return result with type double
    double f(double x);
}

public class listing10_10 {

    //static method for calculating derivative
    static MyFunction Derivative(MyFunction ref){

        //an argument increment to compute the derivative at a point.
        double dx = 1e-5;
        //The result of the method is lambda-expression
        return (double x)->{return(ref.f(x+dx) - ref.f(x))/dx;};
    }

    public static void main(String[] args) {
        //the derivative for the first function
        //A is interface value.
        //the result return link to the object of class, which implement interface MyFunction
        //in this object method f() describe f'(x).
        MyFunction A = Derivative((double x)->{return x*(3-x);});

        MyFunction B = Derivative((double x)->{return x*Math.exp(-x);});

        System.out.println(A);
        //verify results
        System.out.println("Derivative for the first function is");
        System.out.println("Calculated:\tExactly:");
        for (double t = 0; t < 5; t++) {
            System.out.printf("%8.5f\t%8.5f\n", A.f(t),(3-2*t));
        }

        System.out.println("Derivative for the second function is");
        System.out.println("Calculated:\tExactly:");
        for (double t = 0; t < 5; t++) {
            System.out.printf("%8.5f\t%8.5f\n", B.f(t), Math.exp(-t)*(1-t));
        }
    }
}
