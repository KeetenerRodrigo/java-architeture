package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Product;
import br.edu.infnet.appvenda.model.domain.repository.IProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private IProductRepository productRepository;
	
	public void insert(Product product) {
		
		productRepository.save(product);
		
	}
	
	public Collection<Product> get() {
		
		return (Collection<Product>) productRepository.findAll();
		
	}
	
}
