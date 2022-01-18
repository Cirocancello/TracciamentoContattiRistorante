package it.polito.tdp.TracciamentoContatti;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.TracciamentoContatti.model.Model;
import it.polito.tdp.TracciamentoContatti.model.Ristorante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    void HandleButtonAction(ActionEvent event) {

    	List<Ristorante> ristoranti = this.model.getRistoranti();
    	
    	for(Ristorante r : ristoranti) {
    		txtResult.appendText(r.toString()+"\n");
    	}
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
