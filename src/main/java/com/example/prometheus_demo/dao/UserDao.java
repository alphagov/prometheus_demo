package com.example.prometheus_demo.dao;

import com.example.prometheus_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long>, UserDaoCustom {
}
