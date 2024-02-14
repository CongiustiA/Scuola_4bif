package gestione.scuola;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import gestione.salvataggio.*;

/**
 * classe Elenco segreteria per gestione dati degli studenti di una scuola
 * 
 * @author Alessandro Congiusti,Lorenzo Barteloni,Matteo Luvisi,Vincenzo Dellomargio
 * @version 1.0
 */
public class ElencoSegreteria implements java.io.Serializable{

	//attributi
	private LinkedList<Studente> studenti;
	
	/**
	 * istanzio un oggetto della classe ElencoSegreteria
	 */
	
	//metodo costruttore
	public ElencoSegreteria() {
		this.studenti = new LinkedList<Studente>();
	}

	/**restituisco il rierimento alla linkedList dell'eleco della segreteria
	 * 
	 * @return rierimento della linkedList
	 */
	
	//metodo get di Studenti
	public LinkedList<Studente> getStudenti() {
		return studenti;
	}

	/**imposto una linkedLista per l'elenco della segreteria
	 * 
	 * @param studenti - LinkedList che si vuole impostare
	 */
	
	//metodo set di Studenti
	private void setStudenti(LinkedList<Studente> studenti) {
		this.studenti = studenti;
	}


	/**richiedo l'inserimento dei dati dello studente da tastiere per
	 * nome, cognome, anno nascita, nome e/o cognome del padre dello studente,
	 * nome e/o cognome della madre dello studente, luogo di nascita,
	 * via di residenza, citta' di residenza, classe requentata,
	 * anno iscrizione e cap
	 * 
	 * @return un oggetto studente con i dati inseriti
	 */
	public Studente inputS() {

		Scanner s2 = new Scanner(System.in);

		System.out.println("inserisci il nome dello studente");
		String n = s2.nextLine();

		System.out.println("inserisci il cognome dello studente");
		String cog = s2.nextLine();

		System.out.println("inserisci l'anno di nascita dello studente");
		String an = s2.nextLine();

		System.out.println("inserisci il nome del padre dello studente");
		String p = s2.nextLine();

		System.out.println("inserisci il nome della madre dello studente");
		String m = s2.nextLine();

		System.out.println("inserisci il luogo di nascita dello studente dello studente");
		String ln = s2.nextLine();

		System.out.println("inserisci la via in cui vive lo studente");
		String v = s2.nextLine();

		System.out.println("inserisci la città dello studente");
		String c = s2.nextLine();

		System.out.println("inserisci la classe dello studente");
		String classe = s2.nextLine();

		System.out.println("inserisci l'anno d'iscrizione dello studente");
		String aI = s2.nextLine();

		int a = 0;
			
		System.out.println("inserisci il cap dello studente");
		int cap = s2.nextInt();

		Persona p1 = new Persona(cog, n, an, p, m, ln, c, v, cap);

		Studente st = new Studente(aI, classe, a, p1);

		
		return st;

	}

	/**aggiungo uno studente alla LinkedList
	 * 
	 * @param s - studente che si vuole aggiungere
	 */
	public void aggiungiStudente(Studente s) {

		this.studenti.addLast(s);
		
	}

	/**
	 * avvio il menu' della segreteria e chiedo che tipo di operazione si vuole fare
	 */
	public void Start() {

		String path="studenti.bin";
		
		int n=0;
		Scanner s = new Scanner(System.in);
		
		boolean stop = false;
		
		ElencoSegreteria temp= new ElencoSegreteria();
		
		try {
			temp=Salvataggio.caricaDaFile(path);
		} catch (FileNotFoundException e) {
			System.out.println("file non trovato");
			
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("input non valido");
			e.printStackTrace();
		}
		
		this.studenti=temp.studenti;

		while (stop == false) {

			System.out.println(
				"benvenuto nel menù della segreteria per l'operazione che si vuole fare si scelga 1 se si vuole aggiungere uno studente "
				+ "o 2 per salvare i dati o 3 per chiudere il menù");
			 n = s.nextInt();

			switch (n) {

			case 1: {

				Studente st = inputS();

				 aggiungiStudente(st);
				Salvataggio.SalvaSuFile(this,path);

			}
				break;

			case 2: {
				 path = "studenti.bin";

				try {
					Salvataggio.SalvaSuFile(this,path);              
				} catch (Exception e) {

				}
			}
				break;

			case 3: {
				s.close();
				stop = true;
				Salvataggio.SalvaSuFile(this,path);

			}

			}

		}

	}

	
	
	
	
}



