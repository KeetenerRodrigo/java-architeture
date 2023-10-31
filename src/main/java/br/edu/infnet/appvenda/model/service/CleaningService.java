package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.appvenda.model.domain.Cleaning;
import br.edu.infnet.appvenda.model.domain.repository.ICleaningRepository;

public class CleaningService {
	
	@Autowired
	private ICleaningRepository cleaningRepository;
	
	public Cleaning stringsToObject(String[] data) {
		
        Cleaning cleaning = new Cleaning();

        cleaning.setName(data[0]);
        cleaning.setType(data[1]);
        cleaning.setVolumeOrWeight(data[2]);
        cleaning.setFragrance(data[3]);
        cleaning.setpHLevel(Double.parseDouble(data[4]));
        cleaning.setPrice(Float.parseFloat(data[5]));
        cleaning.setPackaging(data[6]);
        cleaning.setUsageInstructions(data[7]);
        cleaning.setBrand(data[8]);
        cleaning.setCustomerRating(Double.parseDouble(data[9]));
        cleaning.setHasStock(Boolean.parseBoolean(data[10]));
        cleaning.setCode(Integer.parseInt(data[11]));
        
        return cleaning;
        
	}
	
	public void insert(Cleaning cleaning) {
		
		cleaningRepository.save(cleaning);
		
	}
	
	public Collection<Cleaning> get() {
		
		return (Collection<Cleaning>) cleaningRepository.findAll();
		
	}

}
