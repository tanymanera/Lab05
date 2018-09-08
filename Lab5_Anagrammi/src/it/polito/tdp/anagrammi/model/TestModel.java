package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
		model.anagrammma("attore");
		System.out.println(model.getPermutazioni().size());
		System.out.println("-------------------------");
		System.out.println(model.getParole());
		
	}

}
