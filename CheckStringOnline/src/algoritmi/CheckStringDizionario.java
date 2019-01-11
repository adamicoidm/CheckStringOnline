package algoritmi;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class CheckStringDizionario extends CheckString {

	public CheckStringDizionario() throws FileNotFoundException, IOException, ClassNotFoundException {
		super();
	}

	public CheckStringDizionario(CheckString next) throws FileNotFoundException, IOException, ClassNotFoundException {
		super(next);
	}

	@Override
	protected final String myCheck(String parolaDaConfrontare) {
		for (String parolaNelDizionario : super.dizionario) {
			// if (parolaNelDizionario.toLowerCase().contains((CharSequence)
			// parolaDaConfrontare.toLowerCase())) {
			if (singleCheck(parolaDaConfrontare.toUpperCase(), parolaNelDizionario.toUpperCase())) {
				System.out.println("PAROLA TROVATA: \t" + parolaNelDizionario);
				return parolaNelDizionario;
			}
		}
		return "";
	}

	protected abstract boolean singleCheck(String parolaDaConfrontare, String parolaNelDizionario);

}
