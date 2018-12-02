/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.buses;

import finder.Main;
import finder.backendcomplete.RouteBus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Home
 */
public class BusesController implements Initializable {

    @FXML
    private ListView inputList;
    @FXML
    private ListView outputList;
    @FXML 
    private ImageView outputImage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        System.out.println("Buses Screen");
                
        //Loading all buses names from file 
        try {
            loadInputListFromFile();
        } catch (IOException ex) {
            Logger.getLogger(BusesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reading Input List data from file
    @FXML
    private void loadInputListFromFile() throws FileNotFoundException, IOException{
        FileReader fr=new FileReader("./src/finder/backendcomplete/buses.txt");
        BufferedReader br =new BufferedReader(fr);
        ArrayList<String> list=new ArrayList();
        String str="";
        while((str=br.readLine())!=null){
            list.add(str);
        }
        for (int i = 0; i < list.size(); i++) {
            inputList.getItems().add(list.get(i));
        }
    }

    @FXML
    private void selectedListItem() throws IOException{
        outputList.getItems().clear();
        System.out.println("clicked on " + inputList.getSelectionModel().getSelectedItem());
        
        //outputList.getItems().add(inputList.getSelectionModel().getSelectedItem());
        
        RouteBus Bus_r=new RouteBus(inputList.getSelectionModel().getSelectedItem().toString());
        String selectedBus = inputList.getSelectionModel().getSelectedItem().toString().substring(0, inputList.getSelectionModel().getSelectedItem().toString().length()-1);
        showImage(selectedBus);
        outputList.getItems().add(Bus_r);
    }
    
    @FXML 
    private void showImage(String url){
        File file = new File("src/finder/images/Maps/" + url +".png");
        Image image = new Image(file.toURI().toString());
        outputImage.setImage(image);
    }
    
    @FXML 
    private void homeButton() throws IOException{
        Main.showHomeScene();
    }
    
    @FXML
    private void helpButton() throws IOException{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText(null);
        alert.setContentText("This feature of the app provides the necessary information\n" +
"of the relevant public transport. It generates all the stops\n" +
"of the bus providing its complete route in pictorial form on\n" +
"the Google map along with the fare. Other uniqueness of \n" +
"the feature is that it gives the estimation of time to reach \n" +
"the destination.");

        alert.showAndWait();
    }
    
    
    
}
