/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author R16
 */
public class FXMLController extends Application implements Initializable {

    private FXMLLoader loader;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField userTextfield;
    @FXML
    private TextField pwTextfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public FXMLController() {

    }

    @FXML
    private void btnLoginPressed(ActionEvent event) {
        String usr = userTextfield.getText();
        String pass = pwTextfield.getText();
        Parent win2 = null;
        try {
            win2= FXMLLoader.load(getClass().getResource("gui_mainmenu.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene nxt = new Scene(win2);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.hide();
        stg.setScene(nxt);   
        stg.show();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent scene1 = null;
        scene1 = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene sc1 = new Scene(scene1);
        primaryStage.setScene(sc1);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
