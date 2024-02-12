package gestione.scuola;

import java.util.Arrays;
import java.util.Objects;


/** classe dimostarttiva di persona
 * 
 * @author Alessandro Congiusti,Lorenzo Barteloni,Matteo Luvisi,Vincenzo Dellomargio
 * 
 * @version 1.0
 */
public class Persona implements java.io.Serializable{
	
	private String cognome;
	private String nome;
	private String annoNascita;
	private String[] genitori;
	private String luogoNascita;
	private String via;
	private String città;
	private int cap;
	
	/**
	 * creo un'oggetto di tipo persona con volari di stato relativi a 
	 * nome,cognome,anno di nascita,p1 ,p2
	 * 
	 * @param nome - nome della persona 
	 * 
	 * @param cognome - cognome della persona 
	 * 
	 * @param annoNascita - l'annoNascita della persona
	 * 
	 * @param p - padre della persona
	 * 
	 * @param m - madre della persona
	 */
	public Persona(String cog, String n, String aN, 
			String p1, String p2,String ln,String c,String via,int cap)
			throws IllegalArgumentException {
		
		this.genitori=new String[2];

		this.annoNascita=annoNascita;
		this.setCognome(cog);
		this.setNome(n);
		this.genitori[0]=p1.toString();		
		this.genitori[1]=p2.toString();	
		this.luogoNascita=ln;
		this.città=c;
		this.via=via;
		this.cap=cap;
	}
	
	
	public Persona(Persona p) {
		this.setAnnoNascita(p.getAnnoNascita());
		this.setCognome(p.getCognome());
		this.setNome(p.getNome());
		this.genitori = new String[2];
		
		String[] g=new String[2];
		
		g=p.getGenitori();
		
		this.genitori[0]=g[0];
		this.genitori[1]=g[1];
	}

	/**restituisco il cognome della persona
	 * 
	 * @return il cognome della persona
	 */
	public String getCognome() {
		return cognome;
	}

	private void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**restituisco l'anno di nascita della persona
	 * 
	 * @return l'anno di nascita della persona
	 */
	public String getAnnoNascita() {
		return annoNascita;
	}

	private void setAnnoNascita(String annoNascita) {
		this.annoNascita = annoNascita;
	}

	/**restituisco il nome della persona
	 * 
	 * @return il nome della persona
	 */
	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	/**restituisco il rierimento all'array di genitori
	 * 
	 * @return rierimento all'array genitori
	 */
	public String[] getGenitori() {
		return genitori;
	}

	/**imposta un genitore se è possibile
	 * 
	 * @param genitore - genitore da impostare
	 */
	private void setGenitori(String genitore) {

		boolean stop=false;
		int i=0;
		
		while(stop==false) {
			if(this.genitori[i]==null) {
				this.genitori[i]=genitore;
				stop=true;
			}
			else i++;
		}
	}


	/**restituisco il luogo di nascita della persona
	 * 
	 * @return il luogo di Nascita della persona
	 */
	public String getLuogoNascita() {
		return luogoNascita;
	}


	/**imposta il luogo di nascita della persona
	 * 
	 * @param luogo di nascita - il luogoNascita da impostare
	 */
	private void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}


	/**restituisco la via in cui vive la persona
	 * 
	 * @return la via
	 */
	public String getVia() {
		return via;
	}


	/**imposta la via in cui vive la persona
	 * 
	 * @param via -la via di residenza da impostare
	 */
	private void setVia(String via) {
		this.via = via;
	}


	/**restituisco la città in cui vive la persona
	 * 
	 * @return la città di residenza della persona
	 */
	public String getCittà() {
		return città;
	}


	/**impostala città della persona
	 * 
	 * @param città - la città di residenza da impostare da impostare
	 */
	private void setCittà(String città) {
		this.città = città;
	}


	/**restituisco il codice cap della città della persona
	 * 
	 * @return il cap della persona
	 */
	public int getCap() {
		return cap;
	}

	/**imposta il cap della città della persona
	 * 
	 * @param cap - il cap da impostare
	 */
	private void setCap(int cap) {
		this.cap = cap;
	}





	/**
	 *stampo i dati della persona
	 */
	@Override
	public String toString() {
		return " [" + (cognome != null ? "cognome=" + cognome + ", " : "")
				+ (nome != null ? "nome=" + nome + ", " : "")
				+ (annoNascita != null ? "annoNascita=" + annoNascita + ", " : "")
				+ (genitori != null ? "genitori=" + Arrays.toString(genitori) + ", " : "")
				+ (luogoNascita != null ? "luogoNascita=" + luogoNascita + ", " : "")
				+ (via != null ? "via=" + via + ", " : "") + (città != null ? "città=" + città + ", " : "")
                + "cap="+ cap + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(annoNascita, cap, città, cognome, luogoNascita, nome, via);
	}

	/**
	 *conronto due oggetti persona
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(annoNascita, other.annoNascita) && cap == other.cap && Objects.equals(città, other.città)
				&& Objects.equals(cognome, other.cognome) && Objects.equals(luogoNascita, other.luogoNascita)
				&& Objects.equals(nome, other.nome) && Objects.equals(via, other.via);
	}


	

}
