package com.pleshak.contact.domain;

public class BaseEntity {

	private transient Integer id;

	public BaseEntity() {
	}

	public BaseEntity(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
