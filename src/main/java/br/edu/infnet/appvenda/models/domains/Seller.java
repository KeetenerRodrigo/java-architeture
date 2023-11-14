package br.edu.infnet.appvenda.models.domains;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Seller", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cpf"}),
    @UniqueConstraint(columnNames = {"email"})
})
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Size(min = 3, max = 100)
	private String name;
	
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    @Column(unique = true)
	private String cpf;
	
	@Pattern(regexp = "/^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$/i")
    @Column(unique = true)
	private String email;
	
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "addressId")
    private Address address;
	
    @JoinColumn(name = "sellerId")
    @OneToMany(fetch = FetchType.EAGER)
	private List<Product> products;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

	@Override
    public String toString() {
    	
        return "Seller{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email=" + email +
                ", products='" + products + '\'' +
                '}';
        
    }
	
}
