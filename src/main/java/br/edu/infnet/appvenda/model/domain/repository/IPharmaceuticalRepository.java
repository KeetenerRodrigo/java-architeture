package br.edu.infnet.appvenda.model.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Pharmaceutical;

@Repository
public interface IPharmaceuticalRepository extends CrudRepository<Pharmaceutical, Integer> {

}
