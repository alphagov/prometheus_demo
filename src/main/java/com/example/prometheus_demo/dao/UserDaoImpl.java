package com.example.prometheus_demo.dao;

import com.example.prometheus_demo.entity.QUser;
import com.example.prometheus_demo.entity.User;
import com.querydsl.jpa.impl.JPAQuery;
import io.prometheus.client.hibernate.HibernateStatisticsCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDaoCustom {

	@Autowired
	private HibernateStatisticsCollector hibernateStatisticsCollector;

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> getAll() {
		return new JPAQuery<User>(em).from(QUser.user).fetch();
	}
}
