package com.company;

import java.util.Random;

class MyThread extends Thread{
    private int count;

    MyThread(String name, int count){
        super(name);
        this.count = count;
        start();
    }

    public void run(){
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println("The thread " + getName() + " is " + (getName().charAt(0) + i));

            try {
                Thread.sleep(1000 + rnd.nextInt(2001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreadApplication {
    public static void main(String[] args) throws InterruptedException {

        MyThread thread1 = new MyThread("Thread1", 10);
        MyThread thread2 = new MyThread("Thread2", 3);
        MyThread thread3 = new MyThread("Thread3", 7);

        for (int i = 0; i < 10; i++) {
            System.out.println("The main thread is " + (char)('A' + i));
            Thread.sleep(1200);
        }

        if (thread1.isAlive()){
            thread1.join();
        }
        if (thread2.isAlive()){
            thread2.join();
        }
        if (thread3.isAlive()){
            thread3.join();
        }
    }
}
