package eus.uni.dam.hiru;

public class Oparia {
	
	private String zer;
	private int lehentasuna;
	private Emailea nori;
	
	
	public Oparia(String zer, int lehentasuna, Emailea nori) {
		
		this.zer = zer;
		this.lehentasuna = lehentasuna;
		this.nori = nori;
	}

public Oparia() {
		
		
	}
	public String getZer() {
		return zer;
	}
	public void setZer(String zer) {
		this.zer = zer;
	}
	public int getLehentasuna() {
		return lehentasuna;
	}
	public void setLehentasuna(int lehentasuna) {
		this.lehentasuna = lehentasuna;
	}
	public Emailea getNori() {
		return nori;
	}
	public void setNori(Emailea nori) {
		this.nori = nori;
	}
	
	@Override
	public String toString() {
		return "Oparia [zer=" + zer + ", lehentasuna=" + lehentasuna + ", nori=" + nori + "]";
	}
	
	
	
}
