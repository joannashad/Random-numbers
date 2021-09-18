
import java.util.Hashtable;
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
public class CreateHashTable{

    public void createList(){  
        int arrayLength = 2000000000;
//        int arrayLength = 200000;
        Long startTime;
        Long endTime;
        int mySum=0;
        try { 
            startTime = System.nanoTime();
            Hashtable<Integer, Integer> ht1 = new Hashtable<>();
            int myRandom = 0;
             for (int i=0;i<arrayLength;i++){
                 myRandom = ThreadLocalRandom.current().nextInt(0,10);
                 ht1.put(i,myRandom);  }
            endTime = System.nanoTime();
            long processTime = endTime-startTime;
        System.out.println("Finished adding Hash Table: " + processTime);

            startTime = System.nanoTime();
             for (int i=0;i<ht1.size();i++){
               ht1.remove(i);
             }
               
            endTime = System.nanoTime();
            processTime = endTime-startTime;
            System.out.println("Finished deleting Hash Table: " + processTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }    
}
