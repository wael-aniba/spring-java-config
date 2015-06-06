package edu.esprit.app.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySources({
	@PropertySource({ "classpath:edu/esprit/app/config/datasource.properties" }),
	@PropertySource({ "classpath:edu/esprit/app/config/infrastructure.properties" }) })
public class JPAConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("datasource.driver.class.name"));
		dataSource.setUrl(env.getProperty("datasource.url"));
		dataSource.setUsername(env.getProperty("datasource.username"));
		dataSource.setPassword(env.getProperty("datasource.password"));
		return dataSource;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[] { env.getProperty("packages.toscan") });
		factoryBean.setJpaVendorAdapter(jpaVendorAdaper());
		factoryBean.setJpaPropertyMap(additionalProperties());
		return factoryBean;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdaper() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(env.getProperty("hibernate.showSql", Boolean.class));
		vendorAdapter.setGenerateDdl(env.getProperty("hibernate.generateDdl", Boolean.class));
		return vendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Map<String, Object> additionalProperties() {

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.generate_statistics", env.getProperty("hibernate.generate.statistics", Boolean.class));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.schema.generation"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.formatSql", Boolean.class));
		return properties;
	}

}
