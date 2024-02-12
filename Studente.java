/**
 * 
 */
package gestione.scuola;
import java.time.LocalDate;


/**classe dimostrativa si studente
 * 
 * @author Alessadro Congiusti-Vincenzo Dellomargio-Matteo luvisi-Lorenzo barteloni 4°BIF
 * 
 * @version 1.0
 */

import java.time.Month;
import java.util.Objects;

public class Studente extends Persona implements java.io.Serializable{
	
	private String annoIscrizione;
	private String classe;
	private int ripetente;
	private String note;

	/**
	 * creo un'oggetto di tipo studente con volari di stato relativi a 
	 * anno iscrizone, classe requentata, numero di anni ripetuti e note
	 * 
	 * @param annoIscrizio l' anno d'iscrizione dello studente
	 * 
	 * @param classe - classe requentata
	 * 
	 * @param rip - numero di anni che ha ripetuto
	 *            
	 * @param p1 - un oggetto di clasee persona
	 */
	public Studente(String annoIscrizione, String classe,int rip,Persona p1) {
	
		super(p1);
		this.annoIscrizione=annoIscrizione;
		this.setClasse(classe);
		this.ripetente=0;
		this.note=null;
	}
	
	/**restituisco l'anno d'iscirzione dello studente
	 * 
	 * @return una stringa con contenuto l'anno di iscrizione
	 */
	public String getAnnoIscrizione() {
		return annoIscrizione;
	}

	/**imposto il l'anno di iscrizione dello studente
	 * 	 
	 * @param annoIscrizione - l'anno di iscrizione dello studente
	 */
	private void setAnnoIscrizione(String annoIscrizione) {
		this.annoIscrizione = annoIscrizione;
	}

	
	public String getClasse() {
		return classe;
	}

	/**impostola classe dello studente
	 * 	 
	 * @param classe - la classe da impostare
	 */
	private void setClasse(String classe) {
		this.classe = classe;
	}

	/**resituisco il numero di anni che ha ripetuto lo studente
	 * 
	 * @return il numero di anni ripetuti
	 */
	public int getRipetente() {
		return ripetente;
	}

	/**imposto il numero di anni che ripetuto lo studente
	 * 
	 * @param ripetente- il numero da impostare
	 */
	public void setRipetente(int ripetente) {
		this.ripetente = ripetente;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	

	/**confronto due oggetti studente
	 * 
	 * @param s1 - studente da confrontare
	 * 
	 * @return il risultato del confronto
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Studente))
			return false;
		Studente other = (Studente) obj;
		return Objects.equals(annoIscrizione, other.annoIscrizione) && Objects.equals(classe, other.classe)
				&& Objects.equals(note, other.note) && ripetente == other.ripetente;
	}

	/**
	 *stampo i dati dello studente
	 *
	 *@return stringa con i dati dello studente
	 */
	@Override
	public String toString() {
		String ris="";
		
		ris= "dati Studente ["+super.toString() +"\n"
		+ (annoIscrizione != null ? "annoIscrizione=" + annoIscrizione + ", " : "")
		+ (classe != null ? "classe=" + classe + ", " : "")
		+ (note != null ? "note=" + note : "") + "]";
		
		

		if(this.ripetente==0) {
			ris+=" "+"ripetente= null" + "]"+"\n"+"\n";
		}
		else {
			ris+="ripetente= " + this.ripetente+"\n"+"\n";
		}
		
		
			
		return ris;
		
	}
	
}