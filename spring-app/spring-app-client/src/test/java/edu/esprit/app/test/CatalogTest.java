package edu.esprit.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.esprit.app.config.JPAConfig;
import edu.esprit.app.config.MvcConfig;
import edu.esprit.app.config.ServiceConfig;
import edu.esprit.app.service.ICatalogService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { JPAConfig.class, ServiceConfig.class, MvcConfig.class })
public class CatalogTest {

	@Autowired
	private ICatalogService service;

	@Test
	
	public void itShouldAddProduct() {

		assertEquals(3, service.getAllProducts().size());
	}

	public void setService(ICatalogService service) {
		this.service = service;
	}
}
