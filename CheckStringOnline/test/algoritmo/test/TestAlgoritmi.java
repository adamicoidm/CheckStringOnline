package algoritmo.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import algoritmi.Equals;

public class TestAlgoritmi {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/algoritmi/CatenaDiResponsabilita.xml");
		

		String s = "Isole Vergini Britanni";
		

		Equals CATENADIANDROMEDA = (Equals) context.getBean("equals");	
		CATENADIANDROMEDA.check(s);
	}
}
