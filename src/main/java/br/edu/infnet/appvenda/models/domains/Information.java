package br.edu.infnet.appvenda.models.domains;

public class Information {
	
	private Integer id;

	private String field;

	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    @Override
    public String toString() {
        return " Campo: " + field +
                ", Descrição: " + description;
    }

	
}
