package br.edu.infnet.appvenda.models.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.clients.IAddress;
import br.edu.infnet.appvenda.models.domains.Address;
import br.edu.infnet.appvenda.models.domains.Seller;
import br.edu.infnet.appvenda.models.repositories.ISellerRepository;

@Service
public class SellerService {

	@Autowired
	private IAddress address;
	
	@Autowired
	private ISellerRepository sellerRepository;
	
	public Seller stringsToObject(String[] data) {

		Seller seller = new Seller();
		seller.setName(data[0]);
		seller.setCpf(data[1]);
		seller.setEmail(data[2]);
		seller.setAddress(new Address(data[3]));
		
		return seller;
		
	}

	public void insertWithAddress(Seller seller){
		
		Address valueAddress = address.findCEP(seller.getAddress().getCep());

		seller.setAddress(valueAddress);
		
		sellerRepository.save(seller);

	}
	
	public void insert(Seller seller) {
		
		sellerRepository.save(seller);
		
	}
	
	public Seller findByEmail(String email) {

		return sellerRepository.findFirstByEmail(email).orElse(null);

	}
	
	public List<Seller> findByCpf(String cpf) {

		return sellerRepository.findByCpf(cpf);

	}

	public void delete(Integer id){

		sellerRepository.deleteById(id);

	}
	
	public Collection<Seller> findAll() {
		
		return (Collection<Seller>) sellerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		
	}

	public Long findCount(){
		
		return sellerRepository.count();
		
	}

}
