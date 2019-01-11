package algoritmo.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.Candidatura;
import algoritmi.CheckString;
import algoritmi.Equals;

public class TestAlgoritmi {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/algoritmi/CatenaDiResponsabilita.xml");

		String s = "Isole Vergini Britanni";
//		String s = "aaaaaaaaaaaaaaaa"; //non trova niente ma fa vedere che algoritmi ci sono

		CheckString CATENADIANDROMEDA = (Equals) context.getBean("equals");	
		String risultato = CATENADIANDROMEDA.check(s);
		System.out.println(risultato);
		
		
//		Candidatura candidatura = new Candidatura(3, "Riccardo"
//				, "Bussolino", "A@B", 
//				"1111-11-11", "3345", "Laurea", "fsd", 
//				"CINA;CIN;ITALIA;SATASIA", 
//				"note");
//		
//		candidatura.controllaCompetenze();
//		
//		System.out.println(candidatura.getCompetenze());

		
	}
}
