package eus.uni.dam.hiru;

import java.util.List;

public class Emailea {
	
	private String izena;
	private int adina;
	private List<Oparia> opari;
	
	
	public Emailea(String izena, int adina) {

		this.izena = izena;
		this.adina = adina;
	}
public Emailea() {
		
		
	}


	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public int getAdina() {
		return adina;
	}
	public void setAdina(int adina) {
		this.adina = adina;
	}
	@Override
	public String toString() {
		return "Emailea [izena=" + izena + ", adina=" + adina + "]";
	}
	
	

}
