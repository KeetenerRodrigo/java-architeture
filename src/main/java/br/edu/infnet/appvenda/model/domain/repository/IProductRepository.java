package br.edu.infnet.appvenda.model.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Product;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {

}
