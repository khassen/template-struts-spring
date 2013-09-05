package fr.treeptik.action;

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

import fr.treeptik.entity.Department;
import fr.treeptik.service.DepartmentService;


@Component(value = "departmentAction")
@Scope("prototype")

@Namespace("/department")
public class DepartmentAction extends ActionSupport implements
ModelDriven<Department> {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DepartmentService departmentService;
	
	private Department department = new Department();
	private List<Department> departments;
	
	@Override
	public Department getModel() {
		return department;
	}

	
	public void validate() {
		System.out.println("lol2");
		if (department.getName().trim().length() == 0) {
			addFieldError("name", "Name is required.");
			System.out.println("lol3");
		}

	}

	
	@Action(value = "addAction", results = {
			@Result(name = "success", type = "redirectAction", location = "listAction.action"),
			@Result(name = "input", location = "/department/add.jsp")})
	public String addDepartment(){
		
		departmentService.add(department);
		return "success";

	}
	
	@Action(value = "listAction", results = {
			@Result(name = "success", location = "/department/list.jsp")})
	@SkipValidation
	public String listDepartment(){
		
       departments = departmentService.getAll();
		return "success";
		
	}
	
	
	
	
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	
	

}
