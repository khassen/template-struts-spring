package fr.treeptik.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fr.treeptik.entity.Employee;
import fr.treeptik.service.EmployeeService;

//2 ANNOTATIONS SPRING
@Component(value = "employeeAction")
@Scope("prototype")
@Namespace("/employee")
public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EmployeeService employeeService;

	private Employee employee = new Employee();
	private List<Employee> employees = new ArrayList<>();

	@Override
	public Employee getModel() {
		return employee;
	}

	public void validate() {

		if (getEmployee().getFirstname().trim().length() == 0
				| getEmployee().getFirstname().trim().length() < 2) {
			addFieldError("firstname",
					"First name is required, minumum two letters");
		}

		if (getEmployee().getLastname().trim().length() == 0
				| getEmployee().getLastname().trim().length() < 2) {

			addFieldError("lastName",
					"lastName is requered , minumum two letters");
		}

		if ( !getEmployee().getTelephone().matches("[0-9]*") | getEmployee().getTelephone().trim().length() != 8 ) {
			addFieldError("telephone", "Telephone contains 8 digitals");
		}
		if (getEmployee().getEmail().trim().length() == 0 | ! getEmployee().getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") ){
			addFieldError("email", "email is requered");
		}
		if (getEmployee().getDateEmbauche().equals(null)  ){
			addFieldError("dateEmbauche", "Do past Date");
		}
		

	}

	// peut etre appeler depuis un url: localhost../nomprojet/addAction.action
	// je manipule directement l'objet dans ma methode comme dans jsf
	// succes, si les sont valid
	// input: qd il y a une erreur de validation, je retourne à la page add
	// qd c une page je vais sur une jsp, qd c un action j arrive sur une
	// methode
	// si on a pas les plugins cette conf se fait en fichier xml
	// pour untiliser hibernate validator en struts on ajoute aprés "addAction"
	// et avant "Result": interceptorRefs
	// =@InterceptorRef("basicStackHibernate')")

	@Action(value = "addAction", results = {
			@Result(name = "success", type = "redirectAction", location = "listAction.action"),
			@Result(name = "input", location = "/employee/add.jsp") })
	public String addEmployee() throws Exception {

		employeeService.add(employee);

		return "success";
	}

	@Action(value = "listAction", results = { @Result(name = "success", location = "/employee/list.jsp") })
	@SkipValidation
	public String listEmployees() throws Exception {
		employees = employeeService.getAll();

		return "success";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}