package model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;//la importo per dichiarare che importerò la tabella Utente nel database
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Transient;
//con gli attributi dichiarati.


@Entity//indica che questa è una tabella(un'entità)
@Table(name="UTable")//creo una tabella con questo nome
public class Utente {
	
	@Id//indico che questa è una chiave primaria
	@GeneratedValue(strategy=GenerationType.AUTO)//Serve per  scegliere le strategie con cui voglio lavorare
	//.AUTO serve per imporre di assegnare la chiave in automatico
	
	private int id_utente;
	
	
	@Column(name="n") //assegna nome "n" alla colonna con nome
	private String nome;
	//@Transient      serve per non inserire la colonna "cognome" nella tabella
	private String cognome;
	
	
	@Embedded//crea colonna di un oggetto 
	private Indirizzo indirizzo;
	
	@ElementCollection(fetch=FetchType.EAGER)//crea altra tabella "LISTA" con colonna id_utente e elemento accoppiato
	@JoinTable(name="Stringhe")
	
	private Set<String>  lista=new HashSet<String>();
	
	public Utente() {
		
	}


	public Utente(int id_utente, String nome, String cognome) {
		super();
		this.id_utente = id_utente;
		this.nome = nome;
		this.cognome = cognome;
		this.setIndirizzo(indirizzo);
	}


	public int getId_utente() {
		return id_utente;
	}


	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
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


	public Indirizzo getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}


	public Set<String> getLista() {
		return lista;
	}


	public void setLista(Set<String> lista) {
		this.lista = lista;
	}
	//aggiungo elemento a lista
	public void addString(String s){
		this.lista.add(s);
	}
	
	
	
}
