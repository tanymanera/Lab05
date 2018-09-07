package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCurrentWord;

    @FXML
    private Button btnAnagramma;

    @FXML
    private TextArea areaParole;

    @FXML
    private TextArea areaPermutazioni;

    @FXML
    private Button btnReset;

    @FXML
    void handleAnagramma(ActionEvent event) {
    	areaParole.clear();
    	areaPermutazioni.clear();
    	String currentWord = txtCurrentWord.getText().toLowerCase();
    	if(!Pattern.matches("[a-z]+", currentWord)) {
    		areaParole.setText("Immettere una parola");
    		return;
    	}
    	model.anagrammma(currentWord);
    	for(String parola: model.getParole()) {
    		areaParole.appendText(parola + "\n");
    	}
    	for(String permutazione: model.getPermutazioni()) {
    		areaPermutazioni.appendText(permutazione + "\n");
    	}
    }

    @FXML
    void handleReset(ActionEvent event) {
    	txtCurrentWord.clear();
    	areaParole.clear();
    	areaPermutazioni.clear();

    }

    @FXML
    void initialize() {
        assert txtCurrentWord != null : "fx:id=\"txtCurrentWord\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert areaParole != null : "fx:id=\"areaParole\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert areaPermutazioni != null : "fx:id=\"areaPermutazioni\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model;
	}
}

