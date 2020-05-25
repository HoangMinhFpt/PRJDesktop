/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoThread.Philosophers;

/**
 *
 * @author PC
 */
public class ChopStick {
    boolean ready;
    ChopStick(){
        ready = true;
    }
    public synchronized void getUp(){
        while(!ready){
            try{
                System.out.println("A philosopher is waiting for a chopsick.");
                wait();
            }
            catch(InterruptedException e){
                System.out.println("An error occured!");
            }
        }
            ready = false;
    }
    public synchronized void getDown(){
        ready = true;
        notify();
    }
}
