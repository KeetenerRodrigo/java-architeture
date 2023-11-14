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
import br.edu.infnet.appvenda.models.services.CleaningService;

@Order(4)
@Component
public class CleaningLoader implements ApplicationRunner {
	
	private static final String FILE_NAME = "files/cleanings.txt";
	
	@Autowired
	private CleaningService cleaningService;
	
	private void readTxt(String fileName) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
        	
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");
                
                Cleaning cleaning = cleaningService.stringsToObject(data);

                cleaningService.insert(cleaning);
                
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
    	
        readTxt(FILE_NAME);

        for (Cleaning cleaning : cleaningService.findAll()) {
            System.out.println(cleaning);
        }
		
	}

}
