package esercitazioni.polito.libretto.model;

public class TestModel {

	public static void main(String[] args) {
		Model m = new Model();
		
		System.out.println(m.addCorso(new Esame ("03FYZ", "Tecniche di programmazione", "Fulvio")));
		System.out.println(m.addCorso(new Esame ("03GHJ", "Ambiente Inteligence", "Fulvio")));
		
		System.out.println(m.trovaEsame("03FYZ"));
		System.out.println(m.trovaEsame("03GHJ"));
		System.out.println(m.trovaEsame("03FFRZ"));

		System.out.println(m.addCorso(new Esame ("03GHJ", "Ambiente Inteligence", "Fulvio")));
	}

}
