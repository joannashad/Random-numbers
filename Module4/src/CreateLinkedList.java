
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joann
 */
public class CreateLinkedList  implements Runnable{
         CreateLinkedList(){
    }
    public void run(){  
        int arrayLength = 200;
       // int arrayLength = 2000000000;
        Long startTime;
        Long endTime;
        int mySum=0;
        try { 
            startTime = System.nanoTime();
            LinkedList<Integer> ll  = new LinkedList<Integer>();
            int myRandom = 0;
             for (int i=0;i<arrayLength;i++){
                 myRandom = ThreadLocalRandom.current().nextInt(0,10);
                 ll.add(myRandom);
                 mySum+=myRandom;           
                Thread.sleep(1000);  }
            endTime = System.nanoTime();
            long processTime = endTime-startTime;
            System.out.println("Finished creating Linked List" + processTime);
        
            startTime = System.nanoTime();
             for (int i=0;i<ll.size();i++){
               ll.remove(i);
             }
        
            endTime = System.nanoTime();
            processTime = endTime-startTime;
            System.out.println("Finished deleting Linked List" + processTime);
        
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }  
    
}
