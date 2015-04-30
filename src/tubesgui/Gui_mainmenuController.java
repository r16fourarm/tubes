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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author R16
 */
public class Gui_mainmenuController implements Initializable {
    @FXML
    private Circle btnOlahData;
    @FXML
    private Circle btnOlahJadwal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnOlahDataClicked(MouseEvent event) {
        Parent win3 =  null;
        try {
            win3 =  FXMLLoader.load(getClass().getResource("olahdatafxml.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Gui_mainmenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene sc = new Scene(win3);
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void btnOlahJadwalClicked(MouseEvent event) {
    }
    
}
