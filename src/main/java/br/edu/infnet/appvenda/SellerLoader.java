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

import br.edu.infnet.appvenda.models.domains.Seller;
import br.edu.infnet.appvenda.models.services.FileLoggerService;
import br.edu.infnet.appvenda.models.services.SellerService;

@Order(1)
@Component
public class SellerLoader implements ApplicationRunner {
	
	private static final String FILE_NAME = "files/sellers.txt";
	
	@Autowired
	private SellerService service;
	
	private void readTxt (String fileName) throws IOException{
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
        	
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {

    			Seller seller = service.stringsToObject(line.split(","));
    			
    			service.insert(seller);
                
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {

			String message = "[Seller] ";
			
			String finalMessage = message.concat(e.getMessage());

           	FileLoggerService.logException(finalMessage);
			
        }
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
    	
        readTxt(FILE_NAME);

        for (Seller seller : service.findAll()) {
            System.out.println(seller);
        }
		
	}

}
