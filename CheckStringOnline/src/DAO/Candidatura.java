package DAO;

import java.util.ArrayList;

public class Candidatura {
	long id_candidatura;
	String nome;
	String cognome;
	String email;
	String dataNascita;
	String numTelefono;
	String titoloStudio;
	String livelloEsperienza;
	String competenze;
	String ultimaEsperienza;
	String stato;
	String note;

	public void controllaCompetenze() throws ClassNotFoundException {
//		String[] competenzeDaVerificare = competenze.split(";");
//		ArrayList<String[]> competenzeEcorrispondenze = new ArrayList<String[]>();
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("./algoritmi/CatenaDiResponsabilita.xml");
//
//		Equals algorithmChain = (Equals) context.getBean("equals");
//
//		String s ="";
//		
//		PostgresSinonimiDAO p = new PostgresSinonimiDAO(); 
//		
//		for (int i = 0; i < competenzeDaVerificare.length; i++) {
//			String[] array = new String[2];
//			array[0]= competenzeDaVerificare[i];
//			competenzeEcorrispondenze.add(array);
//			competenzeEcorrispondenze.get(i)[1] = algorithmChain.check(competenzeEcorrispondenze.get(i)[0]);
//			if(!p.containsSinonimo(competenzeEcorrispondenze.get(i)[1])) {
//				p.inserisciSinonimo(competenzeEcorrispondenze.get(i)[0],competenzeEcorrispondenze.get(i)[1]);
//			}
//			
//			s+=competenzeEcorrispondenze.get(i)[1] + "+";
//			
//		}
//		this.competenze = s;
		/**
		 * Split in Array[String]
		 * 
		 * for competenza in array
		 * 
		 * array[i]=check() nuoveCompetenze+= ", " + array[i]
		 * 
		 *
		 */

	}


	public String getStato() {
		return stato;
	}


	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}

	public long getId_candidatura() {
		return id_candidatura;
	}

	public void setId_candidatura(int id_candidatura) {
		this.id_candidatura = id_candidatura;
	}

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

	// push di ripristino
//	public Candidatura(String nome, String cognome, String email, String dataNascita, String numTelefono,
//			String titoloStudio, String livelloEsperienza, String competenze, String ultimaEsperienza) {
//		super();
//		this.nome = nome;
//		this.cognome = cognome;
//		this.email = email;
//		this.dataNascita = dataNascita;
//		this.numTelefono = numTelefono;
//		this.titoloStudio = titoloStudio;
//		this.livelloEsperienza = livelloEsperienza;
//		this.competenze = competenze;
//		this.ultimaEsperienza = ultimaEsperienza;
//	}

	public Candidatura(long id, String nome, String cognome, String email, String dataNascita, String numTelefono,
			String titoloStudio, String livelloEsperienza, String competenze, String ultimaEsperienza) {
		super();
		this.id_candidatura = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.numTelefono = numTelefono;
		this.titoloStudio = titoloStudio;
		this.livelloEsperienza = livelloEsperienza;
		this.competenze = competenze;
		this.ultimaEsperienza = ultimaEsperienza;
	}

	public Candidatura(long id_candidatura, String nome, String cognome, String email, String dataNascita,
			String numTelefono, String titoloStudio, String livelloEsperienza, String ultimaEsperienza, String stato,String note) {
		super();
		this.id_candidatura = id_candidatura;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.numTelefono = numTelefono;
		this.titoloStudio = titoloStudio;
		this.livelloEsperienza = livelloEsperienza;
		this.ultimaEsperienza = ultimaEsperienza;
		this.stato = stato;
		this.note = note;
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

	public String getUltimaEsperienza() {
		return ultimaEsperienza;
	}

	public void setUltimaEsperienza(String ultimaEsperienza) {
		this.ultimaEsperienza = ultimaEsperienza;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

//	public void StreamData(String s) throws IOException {
//		File file = new File("C:\\eclipse-workspace\\CheckStringOnline\\src\\DAO", "Candidature.txt");
//		Scanner sc = new Scanner(file);
//		String s1 = "";
//		while (sc.hasNextLine()) {
//			s1 = s1 + sc.nextLine() + "\n";
//		}
//		FileWriter fw = new FileWriter(file);
//		fw.append(s1 + "\n\n" + s);
//		sc.close();
//		fw.close();
//		// jklklkjljk
//	}

	public boolean insertCandidatura() throws ClassNotFoundException {

		PostgresCandidaturaDAO cDAO = new PostgresCandidaturaDAO();
		return cDAO.inserisciCandidatura(this);

	}

	public long getDBID(Candidatura c) throws ClassNotFoundException {
		PostgresCandidaturaDAO cDAO = new PostgresCandidaturaDAO();
		ArrayList<Candidatura> cand = cDAO.getId_New_Candidatura(c);
		return cand.get(0).getId_candidatura();

	}
}
