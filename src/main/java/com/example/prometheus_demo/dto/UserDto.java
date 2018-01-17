package com.example.prometheus_demo.dto;

import com.example.prometheus_demo.entity.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class UserDto implements Serializable {

	private String name;
	private Long spaceId;

	public static UserDto toDto(final User user) {
		return new UserDto()
				.setName(user.getName());
	}

	public User toEntity() {
		return new User()
				.setName(this.name);
	}

	public String getName() {
		return name;
	}

	public UserDto setName(final String name) {
		this.name = name;
		return this;
	}

	public Long getSpaceId() {
		return spaceId;
	}

	public UserDto setSpaceId(final Long spaceId) {
		this.spaceId = spaceId;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final UserDto userDto = (UserDto) o;

		return new EqualsBuilder()
				.append(name, userDto.name)
				.append(spaceId, userDto.spaceId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.append(spaceId)
				.toHashCode();
	}
}

