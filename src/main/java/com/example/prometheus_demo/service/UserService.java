package com.example.prometheus_demo.service;

import com.example.prometheus_demo.dto.UserDto;

import java.util.List;

public interface UserService {

	void create(UserDto userDto);

	UserDto get(Long userId);

	List<UserDto> get();

	List<UserDto> getAll();

	void update(Long userId, UserDto userDto);

	void delete(Long userId);
}
