package com.company;

/**
 * Явная реализация интерфеса Runnable.
 * Проверить выполняется ли поток можно с помощью метода isAlive(), which return true or false.
 * if need waiting the end of thread, then we can call method join()
 */

class MyTread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child:\t" + i);

            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class TreadApplication {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Program execution begins");


        Thread t = new Thread(new MyTread());
        System.out.println("The child thread begins");
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("The main thread:\t" +(char)('A' + i));
            Thread.sleep(2000);
        }
        System.out.println("The program has been completed");

    }
}
