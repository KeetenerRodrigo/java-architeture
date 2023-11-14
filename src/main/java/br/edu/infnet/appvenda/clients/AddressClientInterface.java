package br.edu.infnet.appvenda.clients;

import br.edu.infnet.appvenda.models.domains.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "address")
public interface AddressClientInterface {

    @GetMapping(value = "/{cep}/json/")
    public Address findCEP(@PathVariable String cep);

}
