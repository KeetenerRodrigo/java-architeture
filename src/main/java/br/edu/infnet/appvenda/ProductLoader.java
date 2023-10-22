package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.edu.infnet.appvenda.model.domain.Pharmaceutical;
import br.edu.infnet.appvenda.model.domain.Product;
import br.edu.infnet.appvenda.model.service.ProductService;
import br.edu.infnet.appvenda.model.service.PharmaceuticalService;
import br.edu.infnet.appvenda.model.service.CleaningService;

@SuppressWarnings("unused")
public class ProductLoader implements ApplicationRunner {

	private static final String FILE_NAME = "sellers.txt";
	
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
                
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
    	
        readTxt(FILE_NAME);

        for (Product product : productService.get()) {
            System.out.println(product);
        }
		
	}
	
}
