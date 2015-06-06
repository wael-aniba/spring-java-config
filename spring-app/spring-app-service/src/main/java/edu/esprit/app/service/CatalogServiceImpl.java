package edu.esprit.app.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.esprit.app.dao.ICatalogDao;
import edu.esprit.app.entities.Product;

@Service
@Transactional
public class CatalogServiceImpl implements ICatalogService {
	
	@Autowired
	private ICatalogDao dao;

	//Setter for dap required for dependency injection
	public void setDao(ICatalogDao dao) {
		this.dao = dao;
	}
	@Override
	public void addProduct(Product p) {

		dao.addProduct(p);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return dao.getAllProducts();
	}

	@Override
	public List<Product> getAllProductByCriteria(String criteria) {

		return dao.getAllProductByCriteria(criteria);
	}

	@Override
	public Product getProductByReference(String ref) {
		
		return dao.getProductByReference(ref);
	}

	@Override
	public void deleteProduct(String ref) {
		
		dao.deleteProduct(ref);
	}

	@Override
	public void updateProduct(Product p) {

		dao.updateProduct(p);
	}
	
	@PostConstruct
	public void init(){
		
		System.out.println("\n ---------------------------------------------- \n Initiating catalog \n ---------------------------------------------- \n");
		
		addProduct(new Product("ref1", "Sony", 1000.0, 12));
		addProduct(new Product("ref2", "Dell", 1500.0, 15));
		addProduct(new Product("ref3", "Lenovo", 2000.0, 12));
		
	}
	
}
