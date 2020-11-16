package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Build;
import model.Catalogue;
import model.Part;

public class BuildController extends Controller<Build> {
    public final Build getBuild() { return model; }
    @FXML private Button Removesb;
    @FXML private TableView<Part> BuildTv;
    @FXML private TableColumn<Part, String> Price;
    @FXML private Text priceTxt;
    
            
    @FXML private void initialize(){
        Price.setCellValueFactory(cellData -> 
                         cellData.getValue().priceProperty().asString("$%.2f"));
        BuildTv.setItems(getBuild().getParts());
        BuildTv.getSelectionModel().selectedItemProperty().addListener((o, oldPart, newPart) -> Removesb.setDisable(newPart == null));
        BuildTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        priceTxt.textProperty().bind(getBuild().cashProperty().asString("$%.2f"));
        
    
    }
    
    private ObservableList<Part> getSelectedPart(){
        return BuildTv.getSelectionModel().getSelectedItems();
        
    }
    
   
    
    
    
    
     @FXML private void handleCheckb(ActionEvent event) throws IOException{
         getBuild().checkValidity();
         ViewLoader.showStage(getBuild(), "/view/buildcheck.fxml", "Build Validity Status", new Stage());
         
         
   }
     @FXML private void handleRemovesb(ActionEvent event){
         getBuild().remove(getSelectedPart());
         
   }
     @FXML private void handleClose(ActionEvent event){
         stage.close();
   }
}
