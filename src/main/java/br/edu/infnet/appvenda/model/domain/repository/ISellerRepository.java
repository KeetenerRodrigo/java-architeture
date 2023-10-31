package br.edu.infnet.appvenda.model.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Seller;

@Repository
public interface ISellerRepository extends CrudRepository<Seller, Integer> {

	Optional<Seller> findFirstByEmail(String email);
	
}
