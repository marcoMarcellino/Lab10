package it.polito.tdp.porto.db;

import java.util.*;

import it.polito.tdp.porto.model.Author;
import it.polito.tdp.porto.model.AuthorIdMap;
import it.polito.tdp.porto.model.Paper;
import it.polito.tdp.porto.model.PaperIdMap;

public class TestPortoDAO {
	
	public static void main(String args[]) {
		PortoDAO pd = new PortoDAO();
		AuthorIdMap map = new AuthorIdMap();
		PaperIdMap map2 = new PaperIdMap();
		//System.out.println(pd.getAutore(85));
		//System.out.println(pd.getArticolo(2293546));
		//System.out.println(pd.getArticolo(1941144));
		
		/*List<Author> list =new ArrayList<>(pd.getAllAuthorList(map));

		for(Author a :list) {
			System.out.println(a);

		}*/
		
	/*List<Paper> list =new ArrayList<>(pd.getAllPaperList(map2));

		for(Paper a :list) {
			System.out.println(a);
		}
	*/
		System.out.println(pd.coautoriList(2505606));
	}
}
