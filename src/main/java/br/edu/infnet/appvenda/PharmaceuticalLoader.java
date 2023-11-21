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

import br.edu.infnet.appvenda.models.domains.Pharmaceutical;
import br.edu.infnet.appvenda.models.domains.Seller;
import br.edu.infnet.appvenda.models.services.PharmaceuticalService;
import br.edu.infnet.appvenda.models.services.SellerService;

@Order(3)
@Component
public class PharmaceuticalLoader implements ApplicationRunner {
	
	private static final String FILE_NAME = "files/pharmaceuticals.txt";

	@Autowired
	private SellerService sellerService;

    @Autowired
	private PharmaceuticalService pharmaceuticalService;

	private void readTxt(String fileName) {

        try (BufferedReader bufferedReader = 
        		new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
        	
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                
                Pharmaceutical pharmaceutical = this.pharmaceuticalService.stringsToObject(line.split(","));

		        Seller seller = sellerService.findByEmail(line.split(",")[10]);
                
		        pharmaceutical.setSeller(seller);
                		
                this.pharmaceuticalService.insert(pharmaceutical);
                
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
	@Override
	public void run(ApplicationArguments args) throws Exception {
    	
        readTxt(FILE_NAME);

        for (Pharmaceutical pharmaceutical : this.pharmaceuticalService.findAll()) {
            System.out.println(pharmaceutical);
        }
		
	}

}
