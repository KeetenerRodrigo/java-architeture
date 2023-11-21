package br.edu.infnet.appvenda.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.models.domains.Pharmaceutical;

@Repository
public interface IPharmaceuticalRepository extends CrudRepository<Pharmaceutical, Integer> {

	List<Pharmaceutical> findByName(String name);

}
