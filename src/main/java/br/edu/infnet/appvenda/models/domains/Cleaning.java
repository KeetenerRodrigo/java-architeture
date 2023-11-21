package br.edu.infnet.appvenda.models.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cleaning")
public class Cleaning extends Product {
    
    private String type;
    
    private String volumeOrWeight;
    
    private String fragrance;
    
    private double pHLevel;
    
    private String packaging;
    
    private String usageInstructions;
    
    private String brand;
    
    private double customerRating;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVolumeOrWeight() {
        return volumeOrWeight;
    }

    public void setVolumeOrWeight(String volumeOrWeight) {
        this.volumeOrWeight = volumeOrWeight;
    }

    public String getFragrance() {
        return fragrance;
    }

    public void setFragrance(String fragrance) {
        this.fragrance = fragrance;
    }

    public double getpHLevel() {
        return pHLevel;
    }

    public void setpHLevel(double pHLevel) {
        this.pHLevel = pHLevel;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getUsageInstructions() {
        return usageInstructions;
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(double customerRating) {
        this.customerRating = customerRating;
    }
    
    @Override
    public String toString() {
    	
        return  "Nome: " + name +
                ", Tipo= " + type +
                ", Volume= " + volumeOrWeight +
                ", Fragrância: " + fragrance +
                ", PH: " + pHLevel +
                ", Pacote: " + packaging +
                ", Instruções de uso: " + usageInstructions +
                ", Marca: " + brand +
                ", Avaliações dos clientes: " + customerRating +
                ", Tem em estoque? " + hasStock;
        
    }
    
}
