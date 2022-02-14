package eus.uni.dam.hiru;

import java.util.List;

import org.bson.types.ObjectId;

public class Eskatzaileak {

	
	private ObjectId id;
	private String izena;
	private List <Oparia>opariak;
	
	public Eskatzaileak() {
		
		
	}
	
	public Eskatzaileak(String izena, List<Oparia> opariak) {
		this.izena = izena;
		this.opariak = opariak;
	}
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public List<Oparia> getOpariak() {
		return opariak;
	}
	public void setOpariak(List<Oparia> opariak) {
		this.opariak = opariak;
	}
	
	@Override
	public String toString() {
		return "Eskatzaileak [id=" + id + ", izena=" + izena + ", opariak=" + opariak + "]";
	}
	
	
	
	
	
}
