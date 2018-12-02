/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finder.routes;

import finder.Main;
import finder.backendcomplete.LocationToDestination;
import java.io.BufferedReader;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Home
 */
public class RoutesController implements Initializable {

    @FXML
    private ComboBox<String> firstBox;
    @FXML
    private ComboBox<String> secondBox;
    @FXML
    private ListView outputList = new ListView();

    String currentStop;
    String destinationStop;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Routes Screen");
        try {
            loadComboBoxesFromFile();
        } catch (IOException ex) {
            Logger.getLogger(RoutesController.class.getName()).log(Level.SEVERE, null, ex);

        }

        firstBox.setValue("Current Stop");
        secondBox.setValue("Destination Stop");
    }

    @FXML
    private void loadComboBoxesFromFile() throws FileNotFoundException, IOException {

        FileReader fr = new FileReader("./src/finder/backendcomplete/Stops.txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> list = new ArrayList();
        String str = "";
        while ((str = br.readLine()) != null) {
            list.add(str);
        }
        for (int i = 0; i < list.size(); i++) {
            firstBox.getItems().add(list.get(i));
            secondBox.getItems().add(list.get(i));
        }
    }

    @FXML
    private void clickOnProceed() throws IOException {
        outputList.getItems().clear();
        currentStop = firstBox.getSelectionModel().getSelectedItem().toString();
        System.out.println("Current Stop " + currentStop);

        destinationStop = secondBox.getSelectionModel().getSelectedItem().toString();
        System.out.println("Destination Stop " + destinationStop);

        if (currentStop.equals(destinationStop)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Oops!, There Is An Error");
            alert.setContentText("You have selected same locations");
            alert.showAndWait();
            outputList.getItems().clear();

        } else if (currentStop.equals("Current Stop") || destinationStop.equals("Destination Stop")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Oops!, There Is An Error");
            alert.setContentText("You have selected only one location");
        } else if (currentStop == null && destinationStop == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Oops!, There Is An Error");
            alert.setContentText("You have not selected any location");
        } else {
            LocationToDestination bus = new LocationToDestination(currentStop, destinationStop);
            //System.out.println(bus);
            if (bus.list.size()==0) {
                //System.out.println("there is nothing");
                 //outputList.getItems().clear();
                 outputList.getItems().add("Sorry! There no bus found on specific route.");
            } else {
                System.out.println("there is something");
                outputList.getItems().add(bus);
            }
        }
    }

    @FXML
    private void homeButton() throws IOException {
        Main.showHomeScene();
    }

    @FXML
    private void helpButton() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText(null);
        alert.setContentText("This feature of the app asks you to enter your current loca-\n"
                + "tion and the desirable destination. On the basis of this inf-\n"
                + "ormation it provides the suggestions of the buses from t-\n"
                + "he pool of buses operating in Karachi. The uniqueness of-\n"
                + "this feature is that it sorts the suggestion in the ascendin-\n"
                + "g order according to the shortest path.");

        alert.showAndWait();
    }
}
