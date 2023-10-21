package br.edu.infnet.appvenda.model.domain;

public class Cleaning extends Product {
    
    private String type;
    
    private String volumeOrWeight;
    
    private String fragrance;
    
    private double pHLevel;
    
    private double price;
    
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
    
    public String toString() {
    	
        return "Cleaning{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", volumeOrWeight=" + volumeOrWeight +
                ", fragrance='" + fragrance + '\'' +
                ", pHLevel=" + pHLevel +
                ", price=" + price +
                ", packaging='" + packaging + '\'' +
                ", usageInstructions='" + usageInstructions + '\'' +
                ", brand='" + brand + '\'' +
                ", customerRating=" + customerRating +
                ", code=" + code +
                ", hasStock=" + hasStock +
                '}';
        
    }
    
}
