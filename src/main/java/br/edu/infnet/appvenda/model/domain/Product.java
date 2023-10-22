package br.edu.infnet.appvenda.model.domain;

public class Product {
	
	public String name;
	
	public Integer code;
	
	public Float price;
	
	public Boolean hasStock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getHasStock() {
		return hasStock;
	}

	public void setHasStock(Boolean hasStock) {
		this.hasStock = hasStock;
	}
	
	@Override
	public String toString() {
    	
        return "Cleaning{" +
                	"name='" + name + '\'' +
                	", code='" + code + '\'' +
                	", price=" + price +
                	", hasStock='" + hasStock + '\'' +
               '}';
        
    }
	
}
