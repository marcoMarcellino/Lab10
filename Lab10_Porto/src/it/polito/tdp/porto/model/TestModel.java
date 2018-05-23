package it.polito.tdp.porto.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.creaGrafo();
		
		
		//System.out.println(model.coautori(new Author(1847,"Lioy","Antonio")));
		System.out.println(model.toStringCoautori(new Author(85,"Belforte","Gustavo")));
	}

}
