package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Pharmaceutical;

@Order(2)
@Component
public class LoadPharmaceutical implements ApplicationRunner {
	
	private static final String FILE_NAME = "pharmaceuticals.txt";
	
	private static Map<Integer, Pharmaceutical> pharmaceuticalByCode = new HashMap<Integer, Pharmaceutical>();
	
	private static void insertPharmaceutical(Pharmaceutical cleaning) {
		
		pharmaceuticalByCode.put(cleaning.getCode(), cleaning);
		
	}
	
	private static Collection<Pharmaceutical> getCleaningProducts() {
		
		return pharmaceuticalByCode.values();
		
	}
	
	private static void readTxt(String fileName) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
        	
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");
                
                Pharmaceutical pharmaceutical = new Pharmaceutical();

                pharmaceutical.setName(data[0]);
                pharmaceutical.setType(data[1]);
                pharmaceutical.setDosage(data[2]);
                pharmaceutical.setPackaging(data[3]);
                pharmaceutical.setQuantityInPackageDescription(data[4]);
                pharmaceutical.setUsageInstructions(data[5]);
                pharmaceutical.setBrand(data[6]);
                pharmaceutical.setPrice(Float.parseFloat(data[7]));
                pharmaceutical.setCustomerRating(Double.parseDouble(data[8]));
                pharmaceutical.setHasStock(Boolean.parseBoolean(data[9]));
                pharmaceutical.setCode(Integer.parseInt(data[10]));

                insertPharmaceutical(pharmaceutical);
                
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
	@Override
	public void run(ApplicationArguments args) throws Exception {
    	
        readTxt(FILE_NAME);

        for (Pharmaceutical pharmaceutical : getCleaningProducts()) {
            System.out.println(pharmaceutical);
        }
		
	}

}
