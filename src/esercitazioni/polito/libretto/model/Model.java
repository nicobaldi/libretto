package esercitazioni.polito.libretto.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private List<Esame> esami;
	
	public Model() {
		this.esami = new LinkedList<Esame>();
	}
	/*
	 * Aggiunge un nuovo esame all'elenco degli esami già esistenti
	 * verificando che non ci sia già
	 */
	public boolean addCorso(Esame e){
		if(!esami.contains(e)) {
			esami.add(e);
			return true;
		}else {
			return false;
		}
	}
	/**
	 * cerco un esame all'interno della lista
	 * creo un esame falso che e lo costruisco con il codice che gli passo come argomento
	 * indexOf utilizza l'equal ridefinito nella classe dell'oggetto
	 */
	public Esame trovaEsame(String codice) {
		int pos = esami.indexOf(new Esame(codice, null, null));
		if(pos == -1) {
			return null;
		}else {
			return esami.get(pos);
		}
	}
}
