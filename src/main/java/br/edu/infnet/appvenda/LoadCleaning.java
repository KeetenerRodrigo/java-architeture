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

import br.edu.infnet.appvenda.model.domain.Cleaning;
import br.edu.infnet.appvenda.model.service.CleaningService;

@Order(3)
@Component
public class LoadCleaning implements ApplicationRunner {
	
	private static final String FILE_NAME = "cleanings.txt";
	
	@Autowired
	private CleaningService cleaningService;
	
	private void readTxt(String fileName) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
        	
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");
                
                Cleaning cleaning = new Cleaning();

                cleaning.setName(data[0]);
                cleaning.setType(data[1]);
                cleaning.setVolumeOrWeight(data[2]);
                cleaning.setFragrance(data[3]);
                cleaning.setpHLevel(Double.parseDouble(data[4]));
                cleaning.setPrice(Float.parseFloat(data[5]));
                cleaning.setPackaging(data[6]);
                cleaning.setUsageInstructions(data[7]);
                cleaning.setBrand(data[8]);
                cleaning.setCustomerRating(Double.parseDouble(data[9]));
                cleaning.setHasStock(Boolean.parseBoolean(data[10]));
                cleaning.setCode(Integer.parseInt(data[11]));

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

        for (Cleaning cleaning : cleaningService.get()) {
            System.out.println(cleaning);
        }
		
	}

}
