/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoThread;

/**
 *
 * @author PC
 */
public class Consumer extends Thread{
    Store store = null;
    public Consumer(Store s) {
        store = s;
    }
    public void run(){
        while(true){
            try{
                long x = store.get();
                if(x>0)
                    System.out.println("-- Producer " + x + " is bought.");
                else
                    System.out.println("Consumer is waiting for new product.");
            }
            catch (Exception e){
                
            }
        }
    }
}
