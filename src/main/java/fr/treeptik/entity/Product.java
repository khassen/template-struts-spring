package fr.treeptik.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product implements Serializable{
    
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    
    private String ref;
    private String description;
    
	@Enumerated(EnumType.STRING)
	@Column(name="DTYPE")
	private DTYPE dtype;
	

	
	  //table de jointure:
	@ManyToMany
	@JoinTable(name="PROJECT_EMPLOYEE", joinColumns=@JoinColumn(name="PROJECTS_ID"),inverseJoinColumns=@JoinColumn(name="EMPLOYEES_ID"))
    private List<Employee> employees;
    
    public Product() {
	}

    
	public Product(Integer id, String ref, String description) {
		super();
		this.id = id;
		this.ref = ref;
		this.description = description;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", ref=" + ref + ", description="
				+ description + "]";
	}


	public DTYPE getDtype() {
		return dtype;
	}


	public void setDtype(DTYPE dtype) {
		this.dtype = dtype;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

    
}
