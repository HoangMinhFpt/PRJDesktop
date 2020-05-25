/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoThread.DeadLockDemo;

/**
 *
 * @author PC
 */
public class DeadLockDemo implements Runnable{
    DeadLockDemo assistance = null;
    int a = 100, b = 200;
    public /*synchronized*/ void changeValues(){
        try{
            Thread.sleep(500);
            a++;
            b++;}
            catch(Exception e){ }
        }
        public synchronized void run(){
            while(true){
                try{
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("a= " + a);
                    System.out.println("b= " + b);
                    Thread.sleep(500);
                } 
                catch(Exception e){ }
                assistance.changeValues();
            }
        }
        public static void main(String[] args) {
        DeadLockDemo person1 = new DeadLockDemo();
        DeadLockDemo person2 = new DeadLockDemo();
        person1.assistance = person2;
        person2.assistance = person1;
        Thread t1 = new Thread( person1, "Thread-1");
        Thread t2 = new Thread( person2, "thread-2");
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch(Exception e){ }
    }
}
