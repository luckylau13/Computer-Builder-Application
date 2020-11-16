package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Catalogue;


public class ErrorController extends Controller<Exception> {
    public final Exception getException() { return model; }
    
@FXML private void handleOkay(ActionEvent event){
    stage.close();
   } 

}
