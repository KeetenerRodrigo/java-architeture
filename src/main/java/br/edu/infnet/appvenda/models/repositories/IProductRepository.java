package br.edu.infnet.appvenda.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.models.domains.Product;
import br.edu.infnet.appvenda.models.domains.Seller;

import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findBySeller(Seller seller);

}
