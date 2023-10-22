package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Seller;

@Service
public class SellerService {
	
	private static Map<String, Seller> sellerByCPF = new HashMap<String, Seller>();
	
	public void insert(Seller seller) {
		
		sellerByCPF.put(seller.getCpf(), seller);
		
	}
	
	public Collection<Seller> get() {
		
		return sellerByCPF.values();
		
	}

}
