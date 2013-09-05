package fr.treeptik.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.EmployeeDao;
import fr.treeptik.entity.Employee;
import fr.treeptik.service.EmployeeService;

@Service(value = "employeeManager")
public class EmployeeServiceImpl implements EmployeeService {
    
    
    @Autowired
    private EmployeeDao employeeDao;
    
    @PersistenceContext
	private EntityManager entityManager;

    @Override
    @Transactional
    public void add(Employee employee) {
        employeeDao.save(employee);
    }
    

    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee get(Integer id) {
        return employeeDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Integer employeeId) {
        employeeDao.delete(employeeId);
    }
    
}
