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

import br.edu.infnet.appvenda.model.domain.Pharmaceutical;
import br.edu.infnet.appvenda.model.service.PharmaceuticalService;

@Order(3)
@Component
public class PharmaceuticalLoader implements ApplicationRunner {
	
	private static final String FILE_NAME = "files/pharmaceuticals.txt";
	
	@Autowired
	private PharmaceuticalService pharmaceuticalService;
	
	private void readTxt(String fileName) {

        try (BufferedReader bufferedReader = 
        		new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
        	
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                
                Pharmaceutical pharmaceutical = pharmaceuticalService.stringsToObject(line.split(","));
                		
                pharmaceuticalService.insert(pharmaceutical);
                
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
	@Override
	public void run(ApplicationArguments args) throws Exception {
    	
        readTxt(FILE_NAME);

        for (Pharmaceutical pharmaceutical : pharmaceuticalService.get()) {
            System.out.println(pharmaceutical);
        }
		
	}

}
