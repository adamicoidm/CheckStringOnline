package algoritmo.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import algoritmi.EditDistance;
import algoritmi.Equals;

public class TestAlgoritmi {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/algoritmi/CatenaDiResponsabilita.xml");
		
/*		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Inserire parola da cercare: \t");
		String s = bufferRead.readLine();*/
		String s = "Cine";
		
//		HuntMcIlroy h = (HuntMcIlroy) context.getBean("huntMcIlroy");
//		Equals e = new Equals();
		EditDistance ed3 = (EditDistance) context.getBean("editDistance1");	
		ed3.check(s);
	}
}
