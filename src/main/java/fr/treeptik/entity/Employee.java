package fr.treeptik.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@Entity
public class Employee implements Serializable{
     
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Integer id;
    
	@NotNull
    private String firstname;
 
	@NotNull(message="min 2 lettre")
    private String lastname;
 
    @Email
//    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;
     
    
//    @Pattern(regexp="[0-9]", message="8 chiffre")
    private String telephone;

    @ManyToOne() 
    @JoinColumn(name="DEPARTMENT_ID")
    private Department department;

    public Employee() {
	}
    
    public Employee(Integer id, String firstname, String lastname,
			String email, String telephone) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email
				+ ", telephone=" + telephone + "]";
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
    
     
}