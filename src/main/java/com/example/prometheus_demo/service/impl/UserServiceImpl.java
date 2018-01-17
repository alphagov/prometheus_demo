package com.example.prometheus_demo.service.impl;

import com.example.prometheus_demo.dao.UserDao;
import com.example.prometheus_demo.dto.UserDto;
import com.example.prometheus_demo.entity.User;
import com.example.prometheus_demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserDao userDao;

	@Autowired
	public UserServiceImpl(final UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void create(final UserDto userDto) {
		this.userDao.save(userDto.toEntity());
	}

	@Override
	public UserDto get(final Long userId) {
		LOGGER.info("Getting user - {}", userId);

		return UserDto.toDto(this.userDao.findOne(userId));
	}

	@Override
	public List<UserDto> get() {
		return this.userDao.findAll().stream().map(UserDto::toDto).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getAll() {
		return this.userDao.getAll().stream().map(UserDto::toDto).collect(Collectors.toList());
	}

	@Override
	public void update(final Long userId, final UserDto userDto) {
		final User user = this.userDao.findOne(userId);

		user.setName(userDto.getName());

		this.userDao.save(user);

	}

	@Override
	public void delete(final Long userId) {
		this.userDao.delete(userId);
	}
}
