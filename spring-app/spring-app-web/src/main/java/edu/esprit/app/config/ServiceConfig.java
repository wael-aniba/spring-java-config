package edu.esprit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.esprit.app.dao.CatalogDaoImpl;
import edu.esprit.app.service.CatalogServiceImpl;
import edu.esprit.app.utils.LoggingAspect;

@Configuration
@ComponentScan("edu.esprit.app")
public class ServiceConfig {

}
