package it.polito.tdp.model;

public class Vicino implements Comparable<Vicino> {
	
	private Distretto distretto;
	private double distanza;
	
	
	
	public Vicino(Distretto distretto, double distanza) {
		super();
		this.distretto = distretto;
		this.distanza = distanza;
	}
	
	public Distretto getDistretto() {
		return distretto;
	}
	public void setDistretto(Distretto distretto) {
		this.distretto = distretto;
	}
	public double getDistanza() {
		return distanza;
	}
	public void setDistanza(double distanza) {
		this.distanza = distanza;
	}

	@Override
	public int compareTo(Vicino altro) {
		return (int)(this.distanza - altro.distanza);
	}

	@Override
	public String toString() {
		return "Distretto numero " + distretto.getId() + " a distanza di " + distanza +" km";
	}

	
}
