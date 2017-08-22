package esercitazioni.polito.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import esercitazioni.polito.libretto.model.Esame;
import esercitazioni.polito.libretto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	/*
	 * se il programa fosse più complesso ci sarebbero più viste e quindi ci sarebbero più 
	 * controllore ma il modello deve essere unico quinid non  può ogni controllore 
	 * crearsi un modello diverso
	 */
	//Model model = new Model();
	// è un riferimento al modello dato dal main
	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtxCodice;

    @FXML
    private TextField txtTitolo;

    @FXML
    private TextField txtDocente;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtMessage;

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice = txtxCodice.getText();
    	
    	if(codice.length()<5) {
    		txtMessage.appendText("codice non valido\n");
    		return;
    	}
    	
    	Esame e = model.trovaEsame(codice);
    	
    	if (e==null) {
    		txtMessage.appendText("codice "+codice+ " non trovato\n");
    	}else {
    		txtMessage.appendText("codice "+codice+ " trovato\n");
    		
    		txtxCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}
    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	// recupera i dati dall'interfaccia
    	String codice = txtxCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	//verifica la validità dei dati, non può mai essere null 
    	if(codice.length() < 5 || titolo.length() == 0 || docente.length() == 0) {
    		txtMessage.appendText("dati non corretti\n");
    		return;
    	}
    	
    	//chiede al model di effettuare l'operazione, in questo caso l'inserimento
    	Esame e = new Esame(codice, titolo, docente);
    	boolean resutl = model.addCorso(e);
    	
    	//aggiorna la vsta con il risultato dell'operazione
    	if(resutl) {
    		txtMessage.appendText("Esame aggiunto correttamente\n");
    	}else {
    		txtMessage.appendText("Esame NON AGGIUNTO perchè già presente un esame con lo stesso codice\n");
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtxCodice != null : "fx:id=\"txtxCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";

    }

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}
}
