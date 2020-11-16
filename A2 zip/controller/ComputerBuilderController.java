package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.*;
import javafx.fxml.*;
import model.*;
import javafx.stage.*;

public class ComputerBuilderController extends Controller<ComputerBuilder> {
    public final ComputerBuilder getComputerBuilder() {return model;} 
   
    @FXML private void handleViewCatalogue(ActionEvent event) throws IOException{
       ViewLoader.showStage(getComputerBuilder().getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }
    
   @FXML private void handleViewBuild(ActionEvent event) throws IOException{
       ViewLoader.showStage(getComputerBuilder().getBuild(), "/view/build.fxml", "Add Part to Catalogue", new Stage());
   }
   
   @FXML private void handleQuit(ActionEvent event){
       stage.close();
   }
}