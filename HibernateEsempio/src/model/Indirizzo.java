package model;

import javax.persistence.Embeddable;

@Embeddable//per esportarlo in tabella utente
public class Indirizzo {
	private String città;
	private String via;
	
	
	public Indirizzo() {
		super();
	}


	public Indirizzo(String città, String via) {
		super();
		this.città = città;
		this.via = via;
	}


	public String getCittà() {
		return città;
	}


	public void setCittà(String città) {
		this.città = città;
	}


	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}
	
	
		
}
