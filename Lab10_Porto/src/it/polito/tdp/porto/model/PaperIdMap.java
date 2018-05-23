package it.polito.tdp.porto.model;

import java.util.*;

public class PaperIdMap {
	private Map<Integer,Paper> papers ;
	
	public PaperIdMap() {
		papers= new TreeMap<Integer,Paper>();
	}
	
	public Paper getAut(Paper p) {
		Paper old= papers.get(p.getEprintid());
		if(old==null) {
			papers.put(p.getEprintid(),p);
			return p;
		}
		return old;
	}
	
	public void put(Paper p) {
		this.papers.put(p.getEprintid(),p);
	}

}