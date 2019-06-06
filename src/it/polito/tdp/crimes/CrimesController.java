/**
 * Sample Skeleton for 'Crimes.fxml' Controller Class
 */

package it.polito.tdp.crimes;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;
import java.util.ResourceBundle;

import it.polito.tdp.model.Distretto;
import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CrimesController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxAnno"
    private ComboBox<Year> boxAnno; // Value injected by FXMLLoader

    @FXML // fx:id="boxMese"
    private ComboBox<Month> boxMese; // Value injected by FXMLLoader

    @FXML // fx:id="boxGiorno"
    private ComboBox<Integer> boxGiorno; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreaReteCittadina"
    private Button btnCreaReteCittadina; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtN"
    private TextField txtN; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCreaReteCittadina(ActionEvent event) {
    	
    	if (boxAnno.getValue() == null) {
    		txtResult.setText("Scegliere anno");
    		return;
    	}
    	
    	model.creaGrafo(boxAnno.getValue());
    	
    	for (Distretto d: model.getGraph().vertexSet()) {
    		txtResult.appendText("Distretto "+d.getId() + " :\n" + d.getVicini() + "\n");
    	}
    }

    @FXML
    void doSimula(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	int n = 0;
    	
    	try {
    		n = Integer.parseInt(txtN.getText());
    	}
    	catch (NumberFormatException e) {
    		txtResult.setText("valore di N non valido");
    		e.printStackTrace();
    	}
    	if (boxAnno.getValue() == null || boxMese.getValue() == null || boxGiorno.getValue() == null || n > 10 || n < 1) {
    		txtResult.setText("Errore nei dati inseriti");
    		return;
    	}
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxAnno != null : "fx:id=\"boxAnno\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert boxMese != null : "fx:id=\"boxMese\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert boxGiorno != null : "fx:id=\"boxGiorno\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert btnCreaReteCittadina != null : "fx:id=\"btnCreaReteCittadina\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert txtN != null : "fx:id=\"txtN\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Crimes.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	
    	boxAnno.getItems().addAll(model.getAnni());
    	for (int i=1; i<13; i++) {
    		boxMese.getItems().addAll(Month.of(i));
    	}
    	for (int i=1; i<32; i++) {
    		boxGiorno.getItems().addAll(i);
    	}
    }
}