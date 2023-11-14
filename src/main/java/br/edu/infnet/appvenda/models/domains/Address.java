package br.edu.infnet.appvenda.models.domains;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cep;

    private String street;

    private String complement;

    private String district;

    private String locale;
	
    private String uf;

    public Address() {}

    public Address(String cep) {
        this.cep = cep;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

	public String getStreet() {
        return street;
    }	

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
	
    @Override
	public String toString() {
    	
        return "Cleaning{" +
                "cep='" + cep + '\'' +
                ", street='" + street + '\'' +
                ", complement=" + complement +
                ", district='" + district + '\'' +
                ", locale=" + locale +
                ", uf=" + uf +
                '}';
        
    }

}
