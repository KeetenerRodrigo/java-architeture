package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public String name;
	
	public Integer code;
	
	public Float price;
	
	public Boolean hasStock;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sellerId")
	private Seller seller;

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
	
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
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
