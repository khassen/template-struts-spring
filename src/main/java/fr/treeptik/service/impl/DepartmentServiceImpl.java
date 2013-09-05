package fr.treeptik.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.DepartementDao;
import fr.treeptik.entity.Department;
import fr.treeptik.service.DepartmentService;

@Service(value = "departmentManager")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartementDao departmentDao;

	
    @PersistenceContext
	private EntityManager entityManager;
    
    
    @Transactional
    public void update(Department department) {
        entityManager.merge(department);
    }
    
    
	@Override
	@Transactional
	public void add(Department department) {
		departmentDao.save(department);

	}

	@Override
	public List<Department> getAll() {
		return departmentDao.findAll();
	}

	@Override
	public Department get(Integer id) {
		return departmentDao.findOne(id);
	}

	@Override
	public void delete(Integer departmentId) {
		departmentDao.delete(departmentId);
	}

}
