/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Home
 */
public class Main extends Application {
    private static Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        
        Main.primaryStage.setTitle("Buses & Routes Finder");
        showWelcomeScene();
    }

    
    private static void showWelcomeScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("welcome/Welcome.fxml"));
        Pane mainLayout = loader.load();
        
        Scene scene = new Scene(mainLayout, 833, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
    public static void showHomeScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("homepage/Homepage.fxml"));
        Pane homepage = loader.load();
        
        Scene scene = new Scene(homepage, 833, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void showBusesScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("buses/Buses_1.fxml"));
        BorderPane busesScene = loader.load();
        
        Scene scene = new Scene(busesScene, 833, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void showRoutesScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("routes/Routes_1.fxml"));
        BorderPane routesScene = loader.load();
        
        Scene scene = new Scene(routesScene, 833, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
