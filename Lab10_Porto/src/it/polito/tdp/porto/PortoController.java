package it.polito.tdp.porto;

import java.net.URL;import java.util.ResourceBundle;

import it.polito.tdp.porto.db.PortoDAO;
import it.polito.tdp.porto.model.Author;
import it.polito.tdp.porto.model.AuthorIdMap;
import it.polito.tdp.porto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PortoController {

	Model model;
	PortoDAO pdao=new PortoDAO();
	AuthorIdMap mapAut= new AuthorIdMap();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Author> boxPrimo;

    @FXML
    private ComboBox<Author> boxSecondo;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleCoautori(ActionEvent event) {
    txtResult.clear();
     Author a = boxPrimo.getValue();
     model.creaGrafo();
     if(a!=null)
     txtResult.appendText(model.toStringCoautori(a));
     
    	
    	
    	
    }

    @FXML
    void handleSequenza(ActionEvent event) {

    	
    	
    }

    @FXML
    void initialize() {
        assert boxPrimo != null : "fx:id=\"boxPrimo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert boxSecondo != null : "fx:id=\"boxSecondo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Porto.fxml'.";

        boxPrimo.getItems().addAll(pdao.getAllAuthorList(mapAut));
        boxSecondo.getItems().addAll(pdao.getAllAuthorList(mapAut));

        
    }
    public void setModel(Model model) {
		this.model = model;
	}
}
