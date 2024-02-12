package gestione.salvataggio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import gestione.scuola.ElencoSegreteria;

public class Salvataggio {

	
	
	
	public static ElencoSegreteria caricaDaFile(String path) throws FileNotFoundException, IOException {

		ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path));

		 ElencoSegreteria s;

		try {
			s = (ElencoSegreteria) stream.readObject();
		} catch (ClassNotFoundException exception) {
			s = new  ElencoSegreteria();
		}
		stream.close();

		return s;
	}

	public static void  SalvaSuFile(ElencoSegreteria se,String path) throws IOException {

		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path));

		stream.writeObject(se);
		stream.close();
	}
}
