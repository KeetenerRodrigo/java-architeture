package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Seller;
import br.edu.infnet.appvenda.model.service.SellerService;

@Order(1)
@Component
public class LoadSeller implements ApplicationRunner {
	
	private static final String FILE_NAME = "sellers.txt";
	
	@Autowired
	private SellerService service;
	
	private void readTxt (String fileName){
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
        	
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");

    			Seller seller = new Seller();
    			seller.setName(data[0]);
    			seller.setCpf(data[1]);
    			seller.setEmail(data[2]);
    			
    			service.insert(seller);
                
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
    	
        readTxt(FILE_NAME);

        for (Seller seller : service.get()) {
            System.out.println(seller);
        }
		
	}

}
