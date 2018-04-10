/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busawithinterface;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author s.frolov
 */
public class BusaWithInterface extends Application {
 
    public static ObservableList<Books> oBooks = FXCollections.observableArrayList();
    public static String URL = "Books.xml";
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("BusaView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("База книги");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println("Cannot find XFM file!");
        }
    }    
}
