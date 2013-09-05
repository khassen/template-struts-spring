package fr.treeptik.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ProductDao;
import fr.treeptik.entity.Product;
import fr.treeptik.service.ProductService;


@Service(value = "productManager")
public class ProductServiceImpl implements  ProductService{

	@Autowired
	private ProductDao productDao;

	
	
    @PersistenceContext
	private EntityManager entityManager;
    
    
    @Transactional
    public void update(Product product) {
        entityManager.merge(product);
    }
	
	@Override
    @Transactional
	public void add(Product product) {
		productDao.save(product);
		
	}

	@Override
	public List<Product> getAll() {
		
		return productDao.findAll();
	}

	@Override
	public Product get(Integer id) {
		return productDao.findOne(id);
	}

	@Override
    @Transactional
	public void delete(Integer productid) {
		productDao.delete(productid);
		
	}

}
