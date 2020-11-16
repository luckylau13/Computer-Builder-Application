package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Build;
import model.Catalogue;

public class CheckBuildController extends Controller<Build> {
    public final Build getBuild() { return model; }
    
    @FXML private Text Checkvalid;
    
    @FXML private void initialize(){
        Checkvalid.textProperty().bind(getBuild().listingProperty());
    }
    
     @FXML private void handleOkays(ActionEvent event){
         stage.close();
   }
 
}
