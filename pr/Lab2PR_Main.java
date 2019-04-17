package ua.pr;

import java.util.concurrent.CountDownLatch;

public class Lab2PR_Main{

    static AutoResetEvent waitHandler = new AutoResetEvent(false);
    static Thread thirdTh;

    public static void firstThread(){
        System.out.println("First thread is started");
        waitHandler.set();
    }

    public static void secondThread(){
        System.out.println("Second thread is started");
        try {
            waitHandler.waitOne();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread fifthTh = new Thread(()->fifthThread());
        fifthTh.start();
    }

    public static void fourthThread(){
        System.out.println("Fourth thread is started");
        try {
            waitHandler.waitOne();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread sixthTh = new Thread(()->sixthThread());
        sixthTh.start();
    }

    public static void fifthThread(){
        System.out.println("Fifth thread is started");
        try {
            waitHandler.waitOne();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread fourthTh = new Thread(()->fourthThread());
        fourthTh.start();
    }

    public static void sixthThread(){
        System.out.println("Sixth thread is started");
    }

    public static void thirdThread(){
        System.out.println("Third thread is started");
        Thread firstTh = new Thread(()->firstThread());
        Thread secondTh = new Thread(()->secondThread());
        Thread fourthTh = new Thread(()->fourthThread());
        Thread fifthTh = new Thread(()->fifthThread());
        Thread sixthTh = new Thread(()->sixthThread());
        firstTh.start();
        secondTh.start();
        fourthTh.start();
        fifthTh.start();
        sixthTh.start();
    }

    public static void main(String[] args){
        thirdTh = new Thread(()->thirdThread());
    }
}