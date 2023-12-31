package br.edu.infnet.appvenda.models.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Pharmaceutical")
public class Pharmaceutical extends Product{
    
    private String type;
    
    @Size(min = 1, max = 10, message = "A dosagem deve ter entre {min} e {max} caracteres.")
    private String dosage;
    
    private String packaging;
    
    private String usageInstructions;
    
    private String brand;
    
    private String quantityInPackageDescription;
    
    private double customerRating;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
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
    
    public String getQuantityInPackageDescription() {
		return quantityInPackageDescription;
	}

	public void setQuantityInPackageDescription(String quantityInPackageDescription) {
		this.quantityInPackageDescription = quantityInPackageDescription;
	}

    public double getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(double customerRating) {
        this.customerRating = customerRating;
    }
    
    @Override
    public String toString() {
        return "Nome: " + name +
                ", Tipo= " + type +
                ", Dosagem= " + dosage +
                ", Quantidade por embalagem:' " + quantityInPackageDescription +
                ", Pacote: " + packaging +
                ", Instruções de uso: " + usageInstructions +
                ", Marca: " + brand +
                ", Avaliações dos clientes: " + customerRating +
                ", Tem em estoque? " + hasStock;
    }
    
}
