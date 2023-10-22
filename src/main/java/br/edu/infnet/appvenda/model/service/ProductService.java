package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Product;

@Service
public class ProductService {

	private static Map<Integer, Product> productByCode = new HashMap<Integer, Product>();
	
	public void insert(Product product) {
		
		productByCode.put(product.getCode(), product);
		
	}
	
	public Collection<Product> get() {
		
		return productByCode.values();
		
	}
	
}
