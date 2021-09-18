

import java.util.ArrayList;
import java.util.List;
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
public class CreateArrayList {
  
    public void createArray(){  
        int arrayLength = 2000000000;
//        int arrayLength = 200000;
        Long startTime;
        Long endTime;
        int mySum=0;
        try { 
            startTime = System.nanoTime();
            List<Integer> al = new ArrayList<>();
            int myRandom = 0;
            //Add each random number to the ArrayList
             for (int i=0;i<arrayLength;i++){
                 myRandom = ThreadLocalRandom.current().nextInt(0,10);
                 al.add(myRandom);
                 mySum+=myRandom;   } 
            endTime = System.nanoTime();
            long processTime = endTime-startTime;
        System.out.println("Finished adding the ArrayList: " + processTime);
        //Now remove each number from the arrayList
            startTime = System.nanoTime();
        
             for (int i=0;i<al.size();i++){
                al.remove(i);       
             }           
         endTime = System.nanoTime();
        processTime = endTime-startTime;
        System.out.println("Finished deleting the ArrayList: " + processTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }  
    
}
