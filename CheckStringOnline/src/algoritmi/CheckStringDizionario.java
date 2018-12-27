package algoritmi;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class CheckStringDizionario extends CheckString {

	public CheckStringDizionario() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckStringDizionario(CheckString next) throws FileNotFoundException, IOException {
		super(next);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected final boolean myCheck(String parolaDaConfrontare) {
		for (String parolaNelDizionario : super.dizionario) {

			// if (parolaNelDizionario.toLowerCase().contains((CharSequence)
			// parolaDaConfrontare.toLowerCase())) {
			if (singleCheck(parolaDaConfrontare, parolaNelDizionario)) {
				System.out.println("PAROLA TROVATA: \t" + parolaNelDizionario);
				return true;

			}

		}
		return false;
	}

	protected abstract boolean singleCheck(String parolaDaConfrontare, String parolaNelDizionario);

}
