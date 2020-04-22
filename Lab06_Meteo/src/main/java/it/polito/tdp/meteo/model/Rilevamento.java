package it.polito.tdp.meteo.model;

import java.time.Month;
import java.util.Date;

public class Rilevamento {
	
	private String localita;
	private Date data;
	private int umidita;
	private double media;
	
	

	public Rilevamento(String localita, Date data, int umidita) {
		this.localita = localita;
		this.data = data;
		this.umidita = umidita;
	}
	
	

	public Rilevamento(String s, double media) {
		this.localita = s;

		this.media = media;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getUmidita() {
		return umidita;
	}

	public void setUmidita(int umidita) {
		this.umidita = umidita;
	}

	// @Override
	// public String toString() {
	// return localita + " " + data + " " + umidita;
	// }

	@Override
	public String toString() {
		return String.valueOf(umidita);
	}


	 public String toStringSS() {
     return localita + " " + data + " " + umidita;
 }

	 public String toStringSSMedia() {
	     return localita + " media " + media;
	 }

	public double getMedia() {
		return media;
	}

}
