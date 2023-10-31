package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.appvenda.model.domain.Pharmaceutical;
import br.edu.infnet.appvenda.model.domain.repository.IPharmaceuticalRepository;

public class PharmaceuticalService {
	
	@Autowired
	private IPharmaceuticalRepository pharmaceuticalRepository;
	
	public Pharmaceutical stringsToObject(String[] data) {
        
        Pharmaceutical pharmaceutical = new Pharmaceutical();

        pharmaceutical.setName(data[0]);
        pharmaceutical.setType(data[1]);
        pharmaceutical.setDosage(data[2]);
        pharmaceutical.setPackaging(data[3]);
        pharmaceutical.setQuantityInPackageDescription(data[4]);
        pharmaceutical.setUsageInstructions(data[5]);
        pharmaceutical.setBrand(data[6]);
        pharmaceutical.setPrice(Float.parseFloat(data[7]));
        pharmaceutical.setCustomerRating(Double.parseDouble(data[8]));
        pharmaceutical.setHasStock(Boolean.parseBoolean(data[9]));
        pharmaceutical.setCode(Integer.parseInt(data[10]));
        
        return pharmaceutical;
		
	}
	
	public void insert(Pharmaceutical pharmaceutical) {
		
		pharmaceuticalRepository.save(pharmaceutical);
		
	}
	
	public Collection<Pharmaceutical> get() {
		
		return (Collection<Pharmaceutical>) pharmaceuticalRepository.findAll();
		
	}
	
}
