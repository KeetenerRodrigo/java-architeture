package br.edu.infnet.appvenda.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.clients.IInformation;

import br.edu.infnet.appvenda.models.domains.Information;

@Service
public class InformationService {
	
	@Autowired
	private IInformation informationClient;

	public List<Information> findAll() {
		return informationClient.findAll();
	}

	public Information insert(Information information) {
		return informationClient.insert(information);
	}
}
