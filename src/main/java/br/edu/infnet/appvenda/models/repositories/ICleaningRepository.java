package br.edu.infnet.appvenda.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.models.domains.Cleaning;

@Repository
public interface ICleaningRepository extends CrudRepository<Cleaning, Integer>  {

	List<Cleaning> findByName(String name);

}
