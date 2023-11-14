package br.edu.infnet.appvenda.models.domains;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "Product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Size(min = 3, max = 100)
	public String name;
	
    @Positive
	public Float price;
	
	public Boolean hasStock;
	
	@ManyToOne()
	@JoinColumn(name = "sellerId")
	private Seller seller;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                	", id='" + id + '\'' +
                	", price=" + price +
                	", hasStock='" + hasStock + '\'' +
               '}';
        
    }
	
}
