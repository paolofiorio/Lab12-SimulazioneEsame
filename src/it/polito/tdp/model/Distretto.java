package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.javadocmd.simplelatlng.LatLng;

public class Distretto {
	
	private int id;
	private LatLng centro;
	private List<Vicino> vicini;
	
	
	public Distretto(int id, LatLng centro) {
		super();
		this.id = id;
		this.centro = centro;
		this.vicini = new ArrayList<Vicino>();
	}
	
	public List<Vicino> getVicini() {
		Collections.sort(this.vicini);
		return this.vicini;
	}

	public void setVicini(Vicino v) {
		vicini.add(v);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distretto other = (Distretto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Distretto [id=" + id + ", centro=" + centro + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LatLng getCentro() {
		return centro;
	}
	public void setCentro(LatLng centro) {
		this.centro = centro;
	}

}
