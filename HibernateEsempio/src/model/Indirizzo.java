package model;

import javax.persistence.Embeddable;

@Embeddable//per esportarlo in tabella utente
public class Indirizzo {
	private String citt�;
	private String via;
	
	
	public Indirizzo() {
		super();
	}


	public Indirizzo(String citt�, String via) {
		super();
		this.citt� = citt�;
		this.via = via;
	}


	public String getCitt�() {
		return citt�;
	}


	public void setCitt�(String citt�) {
		this.citt� = citt�;
	}


	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}
	
	
		
}
