package br.edu.infnet.appvenda.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appvenda.models.domains.Information;

@FeignClient(url = "http://localhost:8081/api/information", name = "informationClient")
public interface IInformation {

	@GetMapping(value = "/all")
	public List<Information> findAll();

	@PostMapping(value = "/insert")
	public Information insert(Information information);

}
