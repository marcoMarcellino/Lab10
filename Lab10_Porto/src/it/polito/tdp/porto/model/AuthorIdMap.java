package it.polito.tdp.porto.model;

import java.util.*;

public class AuthorIdMap {
	private Map<Integer,Author> autori ;
	
	public AuthorIdMap() {
		autori= new TreeMap<Integer,Author>();
	}
	
	public Author getAut(Author a) {
		Author old= autori.get(a.getId());
		if(old==null) {
			autori.put(a.getId(),a);
			return a;
		}
		return old;
	}
	
	public void put(Author a) {
		this.autori.put(a.getId(),a);
	}

}
