package br.edu.infnet.appvenda.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.models.domains.Product;
import br.edu.infnet.appvenda.models.domains.Seller;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findBySeller(Seller seller);

	List<Product> findByName(String name);

}
