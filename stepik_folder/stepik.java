/**
 * Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.
 *
 * Класс AsciiCharSequence должен:
 *
 * реализовывать интерфейс java.lang.CharSequence;
 * иметь конструктор, принимающий массив байт;
 * определять методы length(), charAt(), subSequence() и toString()
 * Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
 *
 * В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
 */

package com.company;

import java.util.function.DoubleUnaryOperator;
import java.lang.CharSequence;


class AsciiCharSequence implements CharSequence {
    private byte [] mass;
    AsciiCharSequence(byte []mass){
        this.mass = mass;
    }

    @Override
    public int length(){
        return mass.length;
    }

    @Override
    public char charAt(int index){
        return (char)mass[index];
    }

    @Override
    public CharSequence subSequence(int start, int end){
        byte[] result = new byte[end-start];
        for(int i = start; i < end; i++ ){
            result[i-start] = mass[i];
        }
        return new AsciiCharSequence(result);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder(mass.length);
        for(int i = 0; i < mass.length; i++ ){
            result.append((char)mass[i]);
        }
        return result.toString();

    }
}

public class stepik {

    public static void main(String[] args) {

        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    }


}
