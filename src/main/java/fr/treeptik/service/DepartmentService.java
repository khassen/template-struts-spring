package fr.treeptik.service;

import java.util.List;

import fr.treeptik.entity.Department;

public interface DepartmentService {

	
    public void add(Department department);
    public List<Department> getAll();
    public Department get(Integer id);
    public void delete(Integer departmentId);
	
}
