package com.company;

public class MainThread {
    public static void main(String[] args) {
        Thread t;

        t = Thread.currentThread(); //ссылка на текущий поток
        t.setName("Main"); //установка имени потоку
        t.setPriority(7); //установка приоритету потока
        System.out.println(t); //[Main, 7, main]

        System.out.println(t.activeCount()); //количество активных потоков в группе
        System.out.println(t.getId()); //identifier thread
        System.out.println(t.getState()); //status object
        System.out.println(t.interrupted()); //был ли прерван поток ? false
        System.out.println(t.isDaemon()); //if thread is daemon (background thread) - false
        //notify() - из режима ожидания поток переводится в режим выполнения
        //run() -  точка входа в поток
        //setDaemon() - делать поток демон-потоком (автоматически прекращается при завершении главного потока)
        //start() запуск потока на выполнение
        //wait() - переводит поток в режим ожидания
}
}
