package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.appvenda.model.domain.Pharmaceutical;

public class PharmaceuticalService {

	
	private static Map<Integer, Pharmaceutical> pharmaceuticalByCode = new HashMap<Integer, Pharmaceutical>();
	
	public void insert(Pharmaceutical cleaning) {
		
		pharmaceuticalByCode.put(cleaning.getCode(), cleaning);
		
	}
	
	public Collection<Pharmaceutical> get() {
		
		return pharmaceuticalByCode.values();
		
	}
	
}
