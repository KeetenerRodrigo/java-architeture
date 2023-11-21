package br.edu.infnet.appvenda.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.models.domains.Seller;

@Repository
public interface ISellerRepository extends CrudRepository<Seller, Integer> {

	Optional<Seller> findFirstByEmail(String email);

	List<Seller> findAll(Sort sort);

	List<Seller> findByCpf(String cpf);
	
}
