package com.company;

//the first functionality interface
interface Alpha{
    void showA();
}

//the second functionality interface:
interface Bravo{
    void showB();
}

//the third
interface Charlie{
    void showC();
}

public class listing10_3 {
    public static void main(String[] args) {
        //meaning interface value equals lambda-expression
        Alpha A = ()-> System.out.println("Using lambda-expression");
        A.showA();

        Bravo B = ()-> System.out.println("Using lambda-expression");
        B.showB();

        //meanings interface's value equals link to the method
        //командой объявляется интерфейсная переменная С интерфейса Чарли, а значение у нее это
        //ссылка на метод шоуА. Это ссылка на метод из объекта А. переменной С создается объект
        //анонимного класса, реализующего интерфейс Чарли, в котором метод шоуС имеет такой же код, как и
        //метод шоуА из объекта
        Charlie C=A::showA;
        //Call method from interface value
        C.showC();
    }
}
