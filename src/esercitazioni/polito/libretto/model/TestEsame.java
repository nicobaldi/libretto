package esercitazioni.polito.libretto.model;

import java.time.LocalDate;

public class TestEsame {

	public static void main(String[] args) {
		Esame tdp = new Esame ("03FYZ", "Tecniche di programmazione", "Fulvio");
		System.out.println(tdp);
		Esame ami = new Esame("11e3d", "Ambiente inteligence", "Fulvio");
		System.out.println(ami);
		System.out.println(ami.equals(tdp));
		
		tdp.supera(30, LocalDate.now());
		System.out.println(tdp);
		tdp.supera(18, LocalDate.now());
		System.out.println(tdp);
	}

}
