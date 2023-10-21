package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Seller;

@Order(1)
@Component
public class LoadSeller implements ApplicationRunner {
	
	private static final String FILE_NAME = "sellers.txt";
	
	private static Map<String, Seller> sellerByCPF = new HashMap<String, Seller>();
	
	private static void insertSeller(Seller seller) {
		
		sellerByCPF.put(seller.getCpf(), seller);
		
	}
	
	private static Collection<Seller> getSellers() {
		
		return sellerByCPF.values();
		
	}
	
	private static List<Seller> readTxt (String fileName){

        List<Seller> sellers = new ArrayList<>();
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
        	
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");

    			Seller seller = new Seller();
    			seller.setName(data[0]);
    			seller.setCpf(data[1]);
    			seller.setEmail(data[2]);
    			
    			insertSeller(seller);
                
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sellers;
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
    	
        readTxt(FILE_NAME);

        for (Seller seller : getSellers()) {
            System.out.println(seller);
        }
		
	}

}
