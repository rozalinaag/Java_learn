package com.company;

import javax.swing.*;

/**
* Демон-поток выполняется в фоновом режиме. Выскакивает каждые 3 секунды диологовое окно. Пока пользователь не нажмет кнопку ДА, оно будет работать бесконечно 
*/

import static javax.swing.JOptionPane.*;

public class DaemonThreadApplication {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(()->{ //lambda-expression
            int k=1, s=0;
            while(true){
                System.out.println(Thread.currentThread().getName() + ": " + s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s+=k;
                k++;
            }
        }, "Calculating the amounts");

        t.setDaemon(true); //Daemon thread
        int res;
        t.start();

        do{
            Thread.sleep(3000);
            res = showConfirmDialog(null, "Do you want the end calculating amount?", "Amount of numbers", JOptionPane.YES_NO_CANCEL_OPTION);
        } while(res!=YES_OPTION);
    }
}
