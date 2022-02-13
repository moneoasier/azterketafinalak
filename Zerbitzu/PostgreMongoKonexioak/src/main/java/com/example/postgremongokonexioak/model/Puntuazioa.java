package com.example.postgremongokonexioak.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.bson.types.ObjectId;

/**
 * 
 * Puntuazioaren modeloa
 *
 */
public class Puntuazioa {

	private ObjectId id;
	//private int ida;
	private String jokalari;
	private int jokalariId;
	private int puntuazioa;
	private LocalDateTime data;
	
	public Puntuazioa() {
	}

	public Puntuazioa(int jokalariId, String jokalari, int puntuazioa, String data) {
		this.jokalari = jokalari;
		this.jokalariId=jokalariId;
		this.puntuazioa = puntuazioa;
		this.data = LocalDateTime.parse(data);
	}

	public Puntuazioa(int jokalariId, String jokalari, int puntuazioa) {
		this.jokalari = jokalari;
		this.jokalariId=jokalariId;
		this.puntuazioa = puntuazioa;
	}
	
	public String getJokalari() {
		return jokalari;
	}

	public void setJokalari(String jokalari) {
		this.jokalari = jokalari;
	}

	public int getJokalariId() {
		return jokalariId;
	}

	public void setJokalariId(int jokalariId) {
		this.jokalariId = jokalariId;
	}
	public int getPuntuazioa() {
		return puntuazioa;
	}

	public void setPuntuazioa(int puntuazioa) {
		this.puntuazioa = puntuazioa;
	}

	public LocalDateTime getData() {
		return data;
	}
	

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id, jokalari, jokalariId, puntuazioa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puntuazioa other = (Puntuazioa) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(jokalari, other.jokalari) && jokalariId == other.jokalariId
				&& puntuazioa == other.puntuazioa;
	}

	@Override
	public String toString() {
		return "Puntuazioa [id=" + id + ", jokalari=" + jokalari + ", jokalariId=" + jokalariId + ", puntuazioa="
				+ puntuazioa + ", createDate=" + data + "]";
	}
}
