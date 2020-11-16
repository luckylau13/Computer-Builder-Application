package model;

import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Build {

	private ObservableList<Part> parts;
        private StringProperty listing = new SimpleStringProperty();
        private DoubleProperty cash = new SimpleDoubleProperty();

	public ObservableList<Part> getParts() {
		return this.parts;
	}

	public Build() {

		parts = FXCollections.observableArrayList();
                

	}

	public void addPart(Part part) {
		parts.add(part);
	}
        
        public void checkValidity(){
            String list = "";
            
            if(isValid())
            setListing("The build is functional");
            
            else{
            if(!hasPartOfType("cpu")){
            list += "The build is missing a CPU." + "\n";}
            
            
            if(!hasPartOfType("motherboard")){
            list += "The build is missing a motherboard." + "\n";}
            
            if(!hasPartOfType("memory")){
            list += "The build is missing a RAM." + "\n";}
            
            if(!hasPartOfType("case")){
            list += "The build is missing a case." + "\n";}
           
            if(!hasPartOfType("storage")){
            list += "The build is missing a storage" + "\n";}
            setListing(list);
            }
            
            
            
            
                
            
            
        }

	public boolean isValid() {
		return hasPartOfType("cpu") && hasPartOfType("motherboard") && hasPartOfType("memory") && hasPartOfType("case")
				&& hasPartOfType("storage");
	}
        
       
         
        

	public void totalPrice() {

		double sum = 0.0;

		for (Part p : parts)
			sum += p.getPrice();

		setCash(sum);
	}
        
        
       

	public boolean hasPartOfType(String type) {
		for (Part p : parts) {
			if (p.hasType(type))
				return true;
		}

		return false;
	}

	public void remove(Part p) {
		this.parts.remove(p);
	}

	public void remove(List<Part> selectedItems) {

		this.parts.removeAll(selectedItems);

	}

	public void addParts(List<Part> selectedItems) {

		this.parts.addAll(selectedItems);

	}
        
       
        
        public final String getListing() {return listing.get();}
        private final void setListing(String listing) {this.listing.set(listing);}
        public StringProperty listingProperty() {return listing;}
        
        public final double getCash() {return cash.get();}
        private final void setCash(double cash) {this.cash.set(cash);}
        public ReadOnlyDoubleProperty cashProperty() {return cash ;}
        
        
        

}
