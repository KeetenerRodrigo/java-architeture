package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;

import br.edu.infnet.appvenda.models.domains.Cleaning;
import br.edu.infnet.appvenda.models.domains.Pharmaceutical;
import br.edu.infnet.appvenda.models.domains.Product;
import br.edu.infnet.appvenda.models.domains.Seller;
import br.edu.infnet.appvenda.models.services.CleaningService;
import br.edu.infnet.appvenda.models.services.PharmaceuticalService;
import br.edu.infnet.appvenda.models.services.ProductService;
import br.edu.infnet.appvenda.models.services.SellerService;

@Order(2)
public class ProductLoader implements ApplicationRunner {

	private static final String FILE_NAME = "files/sellers.txt";
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PharmaceuticalService pharmaceuticalService;
	
	@Autowired
	private CleaningService cleaningService;
	
	private void readTxt (String fileName){
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
        	
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");
            	
            	String[] dataWithoutFirstPosition = new String[data.length - 2];
            	
            	Seller seller = sellerService.findByEmail(data[1]);
                
                if(data[0] == "P") {
                	
                	Cleaning cleaning = cleaningService.stringsToObject(dataWithoutFirstPosition);
                	cleaning.setSeller(seller);
                	
                	productService.insert(cleaning);
                
                } else if( data[0] == "C" ) {
                	
                	Pharmaceutical pharmaceutical = pharmaceuticalService.stringsToObject(dataWithoutFirstPosition);
                	pharmaceutical.setSeller(seller);
                	
                	productService.insert(pharmaceutical);
                	
                }
                
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
    	
        readTxt(FILE_NAME);

        for (Product product : productService.findAll()) {
            System.out.println(product);
        }
		
	}
	
}
