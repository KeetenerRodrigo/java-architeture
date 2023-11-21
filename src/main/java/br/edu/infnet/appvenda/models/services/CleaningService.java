package br.edu.infnet.appvenda.models.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.appvenda.models.domains.Cleaning;
import br.edu.infnet.appvenda.models.repositories.ICleaningRepository;
import org.springframework.stereotype.Service;

@Service
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

		return cleaning;

	}

	public void insert(Cleaning cleaning) {

		cleaningRepository.save(cleaning);

	}

	public void delete(Integer id){

		cleaningRepository.deleteById(id);

	}

	public Collection<Cleaning> findAll() {

		return (Collection<Cleaning>) cleaningRepository.findAll();

	}

	public List<Cleaning> findByName(String name) {

		return cleaningRepository.findByName(name);

	}

	public Long findCount() {

		return cleaningRepository.count();

	}

}
