package algoritmi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import DAO.PostgresCompetenzeDAO;

public abstract class CheckString {
	protected CheckString next;
	public ArrayList<String> dizionario;
	public ArrayList<String> dizionarioParole;
	public ArrayList<Object> params = new ArrayList<>();

	public CheckString(CheckString next) throws FileNotFoundException, IOException, ClassNotFoundException {
		super();
		this.next = next;
		dizionario = caricaDizionario();
	}

	public CheckString(CheckString next, ArrayList<Object> params) throws FileNotFoundException, IOException, ClassNotFoundException {
		super();
		this.next = next;
		dizionario = caricaDizionario();
	}

	public CheckString() throws FileNotFoundException, IOException, ClassNotFoundException {
		super();
		this.next = null;
		dizionario = caricaDizionario();
	}

	public CheckString(ArrayList<Object> params) throws FileNotFoundException, IOException, ClassNotFoundException {
		super();
		this.next = null;
		dizionario = caricaDizionario();
	}

	/*public ArrayList<String> next(String parolaDaConfrontare) {
		if (next != null) {
			return this.next.check(parolaDaConfrontare);
		} else {
			ArrayList<String> a = new ArrayList<>();
			a.add("Fratello è finita");
			return a;
		}
	}*/
	

//	public final boolean check(String parolaDaConfrontare){
//		
//		if(myCheck(parolaDaConfrontare)) {
//			//inserimento parola nel db
//			System.out.println("Soluzione trovata da: " + this.getClass().getSimpleName());
//			return true;
//		}else {
//			System.out.println("Soluzione NON trovata da: " + this.getClass().getSimpleName());
//			if(next==null) {
//				System.out.println("Non esiste soluzione");
//				return false;
//			}
//			return next.check(parolaDaConfrontare);
//		}
//		
//	

	//METODO CHIAMATO DALL'ESTERNO
	public final String check(String parolaDaConfrontare){
		String result = myCheck(parolaDaConfrontare);
		if(result != "") {
			//inserimento parola nel db
			System.out.println("Soluzione trovata da: " + this.getClass().getSimpleName());
			return result;
		}else {
			System.out.println("Soluzione NON trovata da: " + this.getClass().getSimpleName());
			if(next==null) {
				System.out.println("Non esiste soluzione");
				return "";
			}
			return next.check(parolaDaConfrontare);
		}
		
	}
	
	

//	protected abstract boolean myCheck(String parolaDaConfrontare);
	protected abstract String myCheck(String parolaDaConfrontare);

	//public abstract ArrayList<String> check(String parolaDaConfrontare, ArrayList<Object> params);

	public ArrayList<String> caricaDizionario() throws FileNotFoundException, IOException, ClassNotFoundException {
//		Scanner sc = new Scanner(new File("src\\paesi.txt"));
//		Scanner sc = new Scanner(new File("src\\text3.txt"));

		PostgresCompetenzeDAO p = new PostgresCompetenzeDAO();
		ArrayList<String> dizionario = p.caricaDizionarioCompetenze();

//		while (sc.hasNextLine()) {
//			String s = sc.nextLine().toUpperCase();
////			String s = sc.nextLine().toUpperCase();
//			dizionario.add(s);
//		}
//
//		sc.close();
////		Scanner sc2 = new Scanner(new File("src\\text3.txt"));
//		Scanner sc2 = new Scanner(new File("src\\paesi.txt"));
//
//		ArrayList<String> dizionarioParole = new ArrayList<String>();
//
//		while (sc2.hasNextLine()) {
//			String s = sc2.nextLine().toUpperCase();
//			dizionarioParole.add(s);
//		}
//
//		sc2.close();
//
//		this.dizionarioParole = dizionarioParole;

		return dizionario;
	}
}
