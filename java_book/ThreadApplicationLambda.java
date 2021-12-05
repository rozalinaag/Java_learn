package com.company;

/**
 * Создание потока с использованием анонимного класса
 * Проверить выполняется ли поток можно с помощью метода isAlive(), which return true or false.
 * if need waiting the end of thread, then we can call method join()
 */


public class ThreadApplicationLambda {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Program execution begins");

        //tread based on a lambda-expression 
        Runnable r = ()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child:\t" + i);
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        System.out.println("The child thread begins");
        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("The main thread:\t" +(char)('A' + i));
            Thread.sleep(2000);
        }
        if (t.isAlive())
            t.join();
        else
            System.out.println("The program has been completed");
    }
}
