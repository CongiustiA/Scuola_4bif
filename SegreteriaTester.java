package gestione.scuola;

import java.io.FileNotFoundException;
import java.io.IOException;

import gestione.salvataggio.Salvataggio;

public class SegreteriaTester {

	public static void main(String[] args) {
		
		ElencoSegreteria se= new ElencoSegreteria();
		
		
		
		Persona p1=new Persona("pippo","caio","1/02/2005","gino","paola","milano","firenze"," san paolo",1234);
		
		Persona p2=new Persona("gino","sempronio","5/03/2006","gigi","sara","milano","firenze"," san paolo",4567);
		
		Studente s1=new Studente("05/14/2015","4°AIF",0,p1);
		
	
		Studente s2=new Studente("05/14/2015","4°AIF",0,p2);
		
		
		
		
		
		se.aggiungiStudente(s1);
		
		se.aggiungiStudente(s2);
		
		try {
		  Salvataggio.SalvaSuFile(se,"studenti.bin");
		}
		catch(Exception e) {
			System.out.println("ok");
		}
		
		ElencoSegreteria se2=new ElencoSegreteria();
		
		try {
			se2=Salvataggio.caricaDaFile("studenti.bin");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(se.getStudenti().size());
		
	
		
		System.out.println(se.getStudenti().toString());
		
		
		
		//se.Start();
		
		

	}

}
