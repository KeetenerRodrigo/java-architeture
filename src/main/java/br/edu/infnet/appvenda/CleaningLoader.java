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

import br.edu.infnet.appvenda.models.domains.Cleaning;
import br.edu.infnet.appvenda.models.domains.Seller;
import br.edu.infnet.appvenda.models.services.CleaningService;
import br.edu.infnet.appvenda.models.services.SellerService;

@Order(4)
@Component
public class CleaningLoader implements ApplicationRunner {
	
	@Autowired
	private CleaningService cleaningService;

	@Autowired
	private SellerService sellerService;
	
	private static final String FILE_NAME = "files/cleanings.txt";
	
	private void readTxt(String fileName) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
        	
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");
                
                Cleaning cleaning = cleaningService.stringsToObject(data);

                Seller seller = sellerService.findByEmail(data[11]);

                cleaning.setSeller(seller);

                this.cleaningService.insert(cleaning);
                
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
    	
        readTxt(FILE_NAME);

        for (Cleaning cleaning : this.cleaningService.findAll()) {
            System.out.println(cleaning);
        }
		
	}

}
