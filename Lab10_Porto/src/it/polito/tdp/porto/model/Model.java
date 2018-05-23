package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.porto.db.PortoDAO;

public class Model {
	
	AuthorIdMap autMap ;
	PaperIdMap papMap ;
	PortoDAO dao;
	List<Paper> listPap;
	List<Author> listAut;
	Graph<Author,DefaultEdge> grafo ;
	
	public Model() {
		autMap = new AuthorIdMap();
		papMap = new PaperIdMap();
		dao= new PortoDAO();
		listPap = new ArrayList<Paper>(dao.getAllPaperList(papMap));
		listAut= new ArrayList<Author>(dao.getAllAuthorList(autMap));
		grafo= new SimpleGraph<>(DefaultEdge.class);
	}
	
	public void creaGrafo() {
		Graphs.addAllVertices(grafo, listAut);
		this.addEdge();
	}

	private void addEdge() {
     		for(Paper p : listPap) {
     			List<Author> coautori = new ArrayList<>(dao.coautoriList(p.getEprintid()));
     			if(coautori.size()>0){
     				Author a= coautori.get(0);
     				for(int i=1; i<coautori.size();i++) {
     					grafo.addEdge(a,coautori.get(i));
     				}
     			}
     			
     		}
	}

	public Graph<Author, DefaultEdge> getGrafo() {
		return grafo;
	}

	public List<Author> coautori(Author a){
		List<Author> out = new ArrayList<>(Graphs.neighborListOf(grafo, a));
		return out;
		
	}
	public String toStringCoautori(Author a) {
		StringBuilder sb = new StringBuilder();
		for(Author au : this.coautori(a)) {
			sb.append(""+au.toString()+"\n");
		}
		return sb.toString();
	}
}
