package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appvenda.model.domain.Cleaning;

public class CleaningService {
	
	private static Map<Integer, Cleaning> cleaningByCode = new HashMap<Integer, Cleaning>();
	
	public void insert(Cleaning cleaning) {
		
		cleaningByCode.put(cleaning.getCode(), cleaning);
		
	}
	
	public Collection<Cleaning> get() {
		
		return cleaningByCode.values();
		
	}

}
