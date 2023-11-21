package br.edu.infnet.appvenda.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.models.domains.Product;
import br.edu.infnet.appvenda.models.domains.Seller;
import br.edu.infnet.appvenda.models.repositories.IProductRepository;

import java.util.Collection;
import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	private IProductRepository productRepository;
	
	public void insert(Product product) {
		
		productRepository.save(product);
		
	}
	
	public Collection<Product> findAll() {
		
		return (Collection<Product>) productRepository.findAll();
		
	}
	
	public List<Product> findBySeller(Seller seller) {
		
		return productRepository.findBySeller(seller);
		
	}

	public void delete(Integer id){

		productRepository.deleteById(id);

	}

	public List<Product> findByName(String name) {

		return productRepository.findByName(name);

	}

	public Long findCount() {

        return productRepository.count();
		
    }
	
}
