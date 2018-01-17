package com.example.prometheus_demo.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends AbstractPersistable<Long> {

	private String name;

	public String getName() {
		return name;
	}

	public User setName(final String name) {
		this.name = name;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final User user = (User) o;

		return new EqualsBuilder()
				.append(name, user.name)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.toHashCode();
	}
}
