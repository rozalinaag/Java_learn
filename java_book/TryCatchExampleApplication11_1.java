package com.company;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class TryCatchExampleApplication11_1 {
    public static void main(String[] args) {

        //В Джава есть иерархия классов, каждый из которых соотвествует ошибке определенного типа.
        //В вершине этой иерархии находится класс Throwable. У этого класса имеются
        //два подкласса Error and Exception. 1 класс соответсвует фатальным ошибкам,
        //которые обычно программой не обрабатываются. У второго класса есть множество подклассов
        // где Класс RuntimeException является суперклассом для классов, описывающих всевозможные ошибки.
        //блоков catch может быть несколько.

        //Если ошибка возникла, то в соотвествии с ее типом создается объект. Этот объект (исключение) передается
        //для обработки методу, который вызвал ошибку (исключение вбрасывается в метод). Если ошибка в методе не обработалась
        // то обект ошибки передается для обработки в метод, вызвавший ошибку. и так по цепочке. вплоть до главного метода.
        //если в главном методе ошибка не обрабатывается, то начинает работать обработчик по умолчанию. А значит
        //программа досрочно завершает выполнение.

        String input;
        int num;

        input = showInputDialog(null,
                "Input number:", //Text on the field Input
                "number", //name of the window
                QUESTION_MESSAGE); //type of the window

        try{
            num = parseInt(input);
            showMessageDialog(null, "Number " + (num-1) + "," + num + " and " + (num+1),
                    "Numbers", INFORMATION_MESSAGE);
        } catch(Exception e){
            showMessageDialog(null, "Something went wrong...", "Error" , ERROR_MESSAGE);
        }

    }
}
