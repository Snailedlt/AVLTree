/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiskavltree;


import java.util.Random;
import javafx.application.Application; 
import javafx.geometry.Pos; 
import javafx.stage.Stage; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextField; 
import javafx.scene.layout.BorderPane; 
import javafx.scene.layout.HBox;

/**
 *
 * @author Mikael
 */
public class GrafiskAVLTree extends Application {
    @Override // Override the start method in the Application class
        public void start(Stage primaryStage) {
        AVLTree<Integer> tree = new AVLTree<>();
        // Create a tree
        BorderPane pane = new BorderPane();
        BTView view = new BTView(tree);
        pane.setCenter(view);
        
        TextField tfKey = new TextField();
        tfKey.setPrefColumnCount(3);
        tfKey.setAlignment(Pos.BASELINE_RIGHT);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        Button btSearch = new Button("Search");
        Button btKSearch = new Button("k Search");
        Button btTest = new Button("Add 10 random numbers");
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a key: "),
                tfKey, btInsert, btDelete, btSearch, btKSearch, btTest);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);
        
        btInsert.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (tree.search(key)) { // key is in the tree already
                view.displayTree();
                view.setStatus(key + " is already in the tree");
            } else {
                tree.insert(key);
                // Insert a new key
                view.displayTree();
                view.setStatus(key + " is inserted in the tree");
            }
        });

        btDelete.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (!tree.search(key)) {  // key is not in the tree
                view.displayTree();
                view.setStatus(key + " is not in the tree");
            } else {
                tree.delete(key);
                // Delete a key
                view.displayTree();
                view.setStatus(key + " is deleted from the tree");
            }
        });
        
        btSearch.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (!tree.search(key)) {  // key is not in the tree
                view.displayTree();
                view.setStatus(key + " is not in the tree");
            } else {
                view.displayTree();
                view.setStatus(key + " is in the tree");
            }
        });
        
        btKSearch.setOnAction(e -> {
            String statusOutput = "";
            int key = Integer.parseInt(tfKey.getText());
            if (key > tree.size) // key is larger than the size of the tree
                statusOutput = "There are fewer than " + key + " elements in the tree, currently the tree has " + tree.size + " elements";
            else if(key < 0)
                statusOutput = "You can not \"k search\" for a negative number";
            else {
                int k = tree.find(key);
                //Different ending after the number depending on what the number is
                switch (key) {
                    case 1: statusOutput = "The smallest key in the tree is " + k; //smallest
                        break;
                    case 2:statusOutput = "The " + key + "nd smallest number in the tree is " + k; //2nd smallest
                        break;
                    case 3:statusOutput = "The " + key + "rd smallest number in the tree is " + k; //3rd smallest
                        break;
                    default:statusOutput = "The " + key + "th smallest number in the tree is " + k; //anything else
                        break;
                }
            }
            view.displayTree();
            view.setStatus(statusOutput);
        });

        btTest.setOnAction(e -> {

            for (int i = 0; i < 10; i++) {
                int key = (int) (Math.random() * (100 + 1));
                tree.insert(key);
            }

            view.displayTree();
            view.setStatus("Added 10 random numbers");

        });

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("AVL Tre"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
}


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
