package edu.esprit.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.esprit.app.entities.Product;

@Repository
@Transactional
public class CatalogDaoImpl implements ICatalogDao {
	
	@PersistenceContext
	public EntityManager em;
	
	@Override
	public void addProduct(Product p) {

		em.merge(p);
	}

	@Override
	public List<Product> getAllProducts() {

		return em.createQuery("select p from Product p").getResultList();
	}

	@Override
	public List<Product> getAllProductByCriteria(String criteria) {

		return em
				.createQuery(
						"select p from Product p where p.designation=:param")
				.setParameter("param", criteria).getResultList();
	}

	@Override
	public Product getProductByReference(String ref) {

		return em.find(Product.class, ref);
	}

	@Override
	public void deleteProduct(String ref) {

		em.remove(getProductByReference(ref));
	}

	@Override
	public void updateProduct(Product p) {

		em.merge(p);
	}
	
}
