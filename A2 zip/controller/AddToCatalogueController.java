package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Catalogue;
import model.ComputerBuilder;

public class AddToCatalogueController extends Controller<Catalogue> {
 public final Catalogue getCatalogue() {return model;} 
 
    @FXML private TextField Typetf;
    @FXML private TextField Nametf;
    @FXML private TextField Pricetf;
    
    
    public void setType(String type){
        Typetf.setText(type);
    }
    
        
    public String getType(){
        return Typetf.getText();
    }
    
    public void setName(String name){
        Nametf.setText(name);
    }
    
        
    public String getName(){
        return Nametf.getText();
    }
    
    public void setPrice(int price){
        Pricetf.setText("" + price);
    }
    
        
    public Double getPrice(){
        return Double.parseDouble(Pricetf.getText());
    }
    
    
    
     @FXML private void handleAddtc(ActionEvent event) throws IOException{
       try {
         getCatalogue().addPart(getName(), getType(), getPrice());
       }
       catch (Exception e) {
          ViewLoader.showStage(e, "/view/error.fxml", "Incorrect Input", new Stage());
       }
   }

}
