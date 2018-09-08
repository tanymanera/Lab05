package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.db.NomeDAO;

public class Model {
	private Set<String> permutazioni;
	private Set<String> parole;
	private NomeDAO dao;
	
	public Model() {
		dao = new NomeDAO();
	}
	
	/**
	 * //A if(condizione di terminazione){ doSomething(); return;
	 * 
	 * for()/while() { //B genera nuova soluzione parziale
	 * 
	 * if(filtro){//C scegliPezzo(..., level+1, ...); }
	 * 
	 * // D backtracking; }
	 */
	public void ricorsione(String untilNow, List<Character> caratteriDisponibili) {
		if(caratteriDisponibili.isEmpty()) {
				permutazioni.add(untilNow);
			return;
		}
		StringBuilder justNow = new StringBuilder();
		justNow.append(untilNow);
		
		List<Character> itera = new ArrayList<>(caratteriDisponibili);
		for(Character chr: itera) {
			justNow.append(chr);
			caratteriDisponibili.remove(chr);
			ricorsione(justNow.toString(), caratteriDisponibili);
			caratteriDisponibili.add(chr);
			justNow.deleteCharAt(justNow.length() - 1);
			
		}
	}
	
	public Set<String> getPermutazioni() {
		return permutazioni;
	}

	public Set<String> getParole() {
		return parole;
	}
	
	private void setParole() {
		dao = new NomeDAO();
		parole = dao.isNome(permutazioni);
	}

	public void anagrammma(String currentWord) {
		permutazioni = new HashSet<>();
		parole = new HashSet<>();
		String untilNow = "";
		List<Character> disponibili = new LinkedList<Character>();
		for(char chr: currentWord.toCharArray()) {
			disponibili.add(chr);
		}
		ricorsione(untilNow, disponibili);
		setParole();
		permutazioni.removeAll(parole);
	}
	
}
