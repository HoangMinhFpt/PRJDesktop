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
public class Producer extends Thread{
    Store store = null;
    long index = 1;
    public Producer (Store s){
        store = s;
    }
    public void run(){
        while (true){
            try{
                boolean result = store.put(index);
                if (result == true)
                    System.out.println("** Producer " + (index++) + " is made.");
                else 
                    System.out.println("Store is full.");
            }
            catch (Exception e) {
            }
        }
    }
}
