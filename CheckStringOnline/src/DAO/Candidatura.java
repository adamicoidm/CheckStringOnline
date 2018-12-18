package DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Candidatura {
	String nome;
	 String cognome;
	 String dataNascita;
	 String titoloStudio;
	 String livelloEsperienza;
	 String competenze;
	 String ultimaEsperienza;
	 public Candidatura() {
		 
	 }
	 /**
	  * Ciao ragazzi e Grazie
	  * 
	  * 
	  * @param nome
	  * @param cognome
	  * @param dataNascita
	  * @param titoloStudio
	  * @param livelloEsperienza
	  * @param competenze
	  * @param ultimaEsperienza
	  */
	public Candidatura(String nome, String cognome, String dataNascita, String titoloStudio, String livelloEsperienza,
			String competenze, String ultimaEsperienza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.titoloStudio = titoloStudio;
		this.livelloEsperienza = livelloEsperienza;
		this.competenze = competenze;
		this.ultimaEsperienza = ultimaEsperienza;
	}
	 public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getTitoloStudio() {
		return titoloStudio;
	}
	public void setTitoloStudio(String titoloStudio) {
		this.titoloStudio = titoloStudio;
	}
	public String getLivelloEsperienza() {
		return livelloEsperienza;
	}
	public void setLivelloEsperienza(String livelloEsperienza) {
		this.livelloEsperienza = livelloEsperienza;
	}
	public String getCompetenze() {
		return competenze;
	}
	public void setCompetenze(String competenze) {
		this.competenze = competenze;
	}
	public String getUltimaEsperienza() {
		return ultimaEsperienza;
	}
	public void setUltimaEsperienza(String ultimaEsperienza) {
		this.ultimaEsperienza = ultimaEsperienza;
	}
	public void StreamData(String s) throws IOException {
		File file = new File("C:\\eclipse-workspace\\CheckStringOnline\\src\\DAO", "Candidature.txt");
		Scanner sc = new Scanner(file);
		String s1 = "";
		while (sc.hasNextLine()) {
			s1 = s1 + sc.nextLine()+"\n";
		}
		FileWriter fw = new FileWriter(file);
		fw.append(s1+"\n\n"+s);
		sc.close();
		fw.close();
		//jklklkjljk
	}
	
}
