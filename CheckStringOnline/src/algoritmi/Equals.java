package algoritmi;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Equals extends CheckStringDizionario {

	public Equals() throws FileNotFoundException, IOException, ClassNotFoundException {
		super();
	}

	public Equals(CheckString c) throws FileNotFoundException, IOException, ClassNotFoundException {
		super(c);
	}
	
	@Override
	protected boolean singleCheck(String parolaDaConfrontare, String parolaNelDizionario) {
		return parolaNelDizionario.toLowerCase().equals((CharSequence) parolaDaConfrontare.toLowerCase());

	}




}
