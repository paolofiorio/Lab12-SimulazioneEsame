package it.polito.tdp.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.db.EventsDao;

public class Model {
	
	private EventsDao dao;
	private List<Year> anni;
	private List<Distretto> distretti;
	private SimpleWeightedGraph<Distretto, DefaultWeightedEdge> graph;
	
	public Model() {
		dao = new EventsDao();
		anni = dao.listAllYears();
		distretti = new ArrayList<>();
		graph = new SimpleWeightedGraph<Distretto, DefaultWeightedEdge>(DefaultWeightedEdge.class);
	}
	
	public void creaGrafo(Year anno) {
		
		for (int i = 1; i<8; i++) {
			distretti.add(new Distretto(i,dao.centroDistretto(anno, i)));
		}
		
		for (Distretto d : distretti) {
			graph.addVertex(d);
		}
		
		for (Distretto d1 : graph.vertexSet()) {
			for (Distretto d2 : graph.vertexSet()) {
				if (!d1.equals(d2) && graph.getEdge(d1, d2) == null) {
					Graphs.addEdge(graph, d1, d2, LatLngTool.distance(d1.getCentro(), d2.getCentro(), LengthUnit.KILOMETER));
					d1.setVicini(new Vicino(d2, LatLngTool.distance(d1.getCentro(), d2.getCentro(), LengthUnit.KILOMETER)));
					d2.setVicini(new Vicino(d1, LatLngTool.distance(d1.getCentro(), d2.getCentro(), LengthUnit.KILOMETER)));
				}
			}
		}
	}
	
	public List<Vicino> adiacenti(Distretto d){
		
		return d.getVicini();
	}

	public SimpleWeightedGraph<Distretto, DefaultWeightedEdge> getGraph() {
		return graph;
	}

	public List<Year> getAnni() {
		return anni;
	}

	public List<Distretto> getDistretti() {
		return distretti;
	}
	
	
}

