package com.company;
import java.util.*;
import java.math.*;
import java.io.*;

interface MyNums{

    default void show(int n){
        System.out.println("Argument: " + n);
        System.out.println("Result: " + get(n));
    }
    int get(int n);
}
public class Actors_and_roles {

    public static void main(String[] args) {
        MyNums A= (int n)->{
            int k =0, s =0;
            for (int i = 1; i <n; i++) {
                s+= k;
            }
            return s;
        };

        System.out.println("We are using lambda-expression");
        A.show(10);
        System.out.println("Cheking: " + A.get(10));
        MyNums B = A;
        System.out.println("New lambda-expression:");

        A=n->n*n;
        A.show(10);
        B.show(10);

        System.out.println();

        String[] roles ={"Городничий","Аммос Федорович","Артемий Филиппович","Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор",
                "Аммос Федорович: Как ревизор?" , "Артемий Филиппович: Как ревизор? ",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем. ",
                "Аммос Федорович: Вот те на! ","Артемий Филиппович: Вот не было заботы, так подай! ",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        String[][] text_roles = new String[roles.length][textLines.length];
        String big_string ="";
        for (int i = 0; i < roles.length; i++) {
            big_string += roles[i] + "\n";
            for (int j = 0; j < textLines.length; j++) {
                int k = textLines[j].indexOf(roles[i]);
                if (k != -1) {
                    k = roles[i].length() + 1;
                    String str = (j+1) +")" + textLines[j].substring(k);
                    if (i==roles.length-1) big_string += str;
                    else big_string += str + "\n";
                }
            }
            if (i!= roles.length-1)
                big_string +="\n";
        }
        System.out.println(big_string);
	// write your code here
    }
}
