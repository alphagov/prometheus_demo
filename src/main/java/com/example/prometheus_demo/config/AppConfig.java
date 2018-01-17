package com.example.prometheus_demo.config;

import com.example.prometheus_demo.interceptor.RequestCounterInterceptor;
import com.example.prometheus_demo.interceptor.RequestTimingInterceptor;
import io.prometheus.client.Collector;
import io.prometheus.client.hibernate.HibernateStatisticsCollector;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private RequestCounterInterceptor requestCounterInterceptor;

	@Autowired
	private RequestTimingInterceptor requestTimingInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestCounterInterceptor);
		registry.addInterceptor(requestTimingInterceptor);
	}
}
