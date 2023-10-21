package br.edu.infnet.appvenda.model.domain;

public class Pharmaceutical extends Product{
    
    private String type;
    
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
        return "Pharmaceutical{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dosage=" + dosage +
                ", packaging='" + packaging + '\'' +
                ", usageInstructions='" + usageInstructions + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", customerRating=" + customerRating +
                ", code=" + code +
                ", hasStock=" + hasStock +
                '}';
    }
    
}
