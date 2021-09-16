/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *Call a new method which adds 2,000,000 random integers into an ArrayList, then deletes each one from the ArrayList

Call a new method which adds 2,000,000 random integers into a LinkedList, then deletes each one from the LinkedList

Call a new method which adds 2,000,000 random integers into a Hashtable, then deletes each one from the Hashtable
 * @author joanna smith
 */
public class FXMain extends Application {
 
     
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        StackPane root = new StackPane();
   
        Button btn1 = new Button();
        btn1.setText("Create Array List");
        btn1.setPrefWidth(150);
        Label lblResults = new Label();
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
        int nThreads = 10000000;
            @Override
            public void handle(ActionEvent event) {
                ExecutorService executor = Executors.newFixedThreadPool(nThreads);
                CreateArrayList ca1=new CreateArrayList(); 
                executor.execute(ca1);
                executor.shutdown();
                // Wait until all threads are finish
                while (!executor.isTerminated()) {

                }
                
                ExecutorService executor2 = Executors.newFixedThreadPool(nThreads);
                CreateHashTable cht=new CreateHashTable(); 
                executor2.execute(cht);
                executor2.shutdown();
                
                ExecutorService executor3 = Executors.newFixedThreadPool(nThreads);
                CreateLinkedList cll=new CreateLinkedList(); 
                executor3.execute(cll);
                executor3.shutdown();

        }});       
        
        Button btn2 = new Button();
        btn2.setText("Create Linked List");
        btn2.setPrefWidth(150);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ExecutorService executor = Executors.newFixedThreadPool(4);
                CreateLinkedList cll=new CreateLinkedList(); 
                executor.execute(cll);
                executor.shutdown();
                // Wait until all threads are finish
                while (!executor.isTerminated()) {

                }

            }
        });

        
        Button btn3 = new Button();
        btn3.setText("Create Hashtable");
        btn3.setPrefWidth(150);
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ExecutorService executor = Executors.newFixedThreadPool(4);
                CreateHashTable cht=new CreateHashTable(); 
                executor.execute(cht);
                executor.shutdown();
                // Wait until all threads are finish
                while (!executor.isTerminated()) {

                }

                System.out.println("\nFinished all threads");
            }
        });

       
        grid.add(btn1, 0, 1);
        grid.add(btn2, 0, 2);
        grid.add(btn3, 0, 3);
        
        Scene scene = new Scene(grid, 300, 300);
        
        primaryStage.setTitle("Random numbers.");
        primaryStage.setScene(scene);
        primaryStage.show();
    


    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
