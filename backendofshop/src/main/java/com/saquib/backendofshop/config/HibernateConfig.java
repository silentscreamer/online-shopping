package com.saquib.backendofshop.config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.saquib.backendofshop.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");

		return dataSource;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	@Bean
	public SessionFactory getsfactory(DataSource ds) {
		LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(ds);
		lsfb.addProperties(additionalProperties());
		lsfb.scanPackages("com.saquib.backendofshop.dto");
		return lsfb.buildSessionFactory();
	}


	@Bean
	public HibernateTransactionManager getTransactionmanaget(SessionFactory sf) {
		HibernateTransactionManager htm = new HibernateTransactionManager(sf);
		return htm;
	}
}
