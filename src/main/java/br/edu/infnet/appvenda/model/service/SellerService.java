package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Seller;
import br.edu.infnet.appvenda.model.domain.repository.ISellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private ISellerRepository sellerRepository;
	
	public Seller stringsToObject(String[] data) {

		Seller seller = new Seller();
		seller.setName(data[0]);
		seller.setCpf(data[1]);
		seller.setEmail(data[2]);
		
		return seller;
		
	}
	
	public void insert(Seller seller) {
		
		sellerRepository.save(seller);
		
	}
	
	public Seller findByEmail(String email) {
		return sellerRepository.findFirstByEmail(email).orElse(null);
	}
	
	public Collection<Seller> get() {
		
		return (Collection<Seller>) sellerRepository.findAll();
		
	}

}
