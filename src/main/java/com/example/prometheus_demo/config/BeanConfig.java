package com.example.prometheus_demo.config;

import io.prometheus.client.hibernate.HibernateStatisticsCollector;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class BeanConfig {

	@PersistenceContext
	private EntityManager entityManager;

	@Bean
	public HibernateStatisticsCollector hibernateStatisticsCollector() {
		return new HibernateStatisticsCollector(entityManager.getEntityManagerFactory().unwrap(SessionFactory.class), "myapp").register();
	}
}
