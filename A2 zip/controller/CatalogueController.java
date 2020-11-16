package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Catalogue;
import model.Part;

public class CatalogueController extends Controller<Catalogue> {
    public final Catalogue getCatalogue() { return model; }

    @FXML private TableView<Part> partsTv;
    @FXML private TextField Typetf;
    @FXML private TextField minPricetf;
    @FXML private TextField maxPricetf;
    @FXML private TableColumn<Part, String> Price ;
    @FXML private Button Addtb;
    @FXML private Button Removesc;
    
    @FXML private void initialize(){
                 Price.setCellValueFactory(cellData -> 
                         cellData.getValue().priceProperty().asString("$%.2f"));
        partsTv.setItems(getCatalogue().getCurrentView());
        partsTv.getSelectionModel().selectedItemProperty().addListener((o, oldPart, newPart) -> Addtb.setDisable(newPart == null));
        partsTv.getSelectionModel().selectedItemProperty().addListener((o, oldPart, newPart) -> Removesc.setDisable(newPart == null));
        partsTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Typetf.textProperty().addListener((o, oldText, newText)-> {getCatalogue().filterList(newText, getminPrice(), getmaxPrice());});
        minPricetf.textProperty().addListener((o, oldText, newText) -> {getCatalogue().filterList(getType(), newText, getmaxPrice());});
        maxPricetf.textProperty().addListener((o, oldText, newText) -> {getCatalogue().filterList(getType(), getminPrice(), newText);});
        
    }
    private ObservableList<Part> getSelectedPart(){
        return partsTv.getSelectionModel().getSelectedItems();
        
    }
    
    
    //public void setType(String type){
    //    Typetf.setText(type);
    //}
    
        
    public String getType(){
        return Typetf.getText();
    }
    
    
    //public void setminPrice(double price){
    //    minPricetf.setText(""+price);
    //}
    
        
    public String getminPrice(){
        return minPricetf.getText();
    }
    
    
   // public void setmaxPrice(double price){
   //     maxPricetf.setText("" + price);
   // }
    
        
    public String getmaxPrice(){
        return maxPricetf.getText();
    }
    
    
        
    
  
    
     @FXML private void handleAddtb(ActionEvent event){
        getCatalogue().addToBuild(getSelectedPart());
        getCatalogue().getBuild().totalPrice();
    
      
   }
     @FXML private void handleAddnc(ActionEvent event) throws IOException{
         ViewLoader.showStage(getCatalogue(), "/view/addtocatalogue.fxml", "Add Part to Catalogue", new Stage());
         
   }
     @FXML private void handleRemovesc(ActionEvent event){
         getCatalogue().remove(getSelectedPart());
         
         
   }
     @FXML private void handleClose(ActionEvent event){
         stage.close();
   }    
    }
    
    

