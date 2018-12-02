/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.homepage;

import finder.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Home
 */
public class HomepageController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Homepage");
    }    
    
    @FXML 
    private void busesButton() throws IOException{
        Main.showBusesScene();
    }
    
    @FXML 
    private void routesButton() throws IOException{
        Main.showRoutesScene();
    }
    
    @FXML
    private void helpButton() throws IOException{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText(null);
        alert.setContentText("All comes here the program is about!");

        alert.showAndWait();
    }
    
    @FXML
    private void aboutUsButton() throws IOException{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Us");
        alert.setHeaderText(null);
        alert.setContentText("We are a group of tech enthusiasts. We have a very optimistic vision for the development of Pakistan and its prosperity through incorporating technology in every department and phase of lives." + "\n\n" + "Contact Us" + "\n" + "asadkhalid305@icloud.com");
        alert.showAndWait();
    } 
    
    @FXML
    private void aboutAppMoreButton() throws IOException{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Application");
        alert.setHeaderText(null);
        alert.setContentText("Our application i.e. “KARACHI PUBLIC TRANSPORT ROUTE \n" +
"DETECTIVE” is such an app which helps the public transp-\n" +
"ort travelers with the guidance of the  routes of their des-\n" +
"tinations and not only that but also tells the public transp-\n" +
"ort operating on the relevant route along with the fare. \n" +
"And if that is also not enough than keeping in mind that \n" +
"“time is money” it also indicates the transport specifically \n" +
"that takes less time for reaching the destination. This feature \n" +
"is one of the uniqueness of our product which could help\n" +
"the user for better time management.");
        alert.showAndWait();
    }
}
