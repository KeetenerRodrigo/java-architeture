package br.edu.infnet.appvenda.models.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.models.domains.Pharmaceutical;
import br.edu.infnet.appvenda.models.repositories.IPharmaceuticalRepository;

@Service
public class PharmaceuticalService {

	private IPharmaceuticalRepository pharmaceuticalRepository;

	@Autowired
	private SellerService sellerService;

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
		pharmaceutical.setSeller(sellerService.findByEmail(data[10]));

		return pharmaceutical;

	}

	public void insert(Pharmaceutical pharmaceutical) {

		pharmaceuticalRepository.save(pharmaceutical);

	}

	public Collection<Pharmaceutical> findAll() {

		return (Collection<Pharmaceutical>) pharmaceuticalRepository.findAll();

	}

	public Long findCount() {

		return pharmaceuticalRepository.count();

	}

}
