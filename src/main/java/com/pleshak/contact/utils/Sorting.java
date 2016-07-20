package com.pleshak.contact.utils;

public enum Sorting {

	DESC("DESC"), ASC("ASC"), DEFAULT("");

	private String type;

	private Sorting(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static Sorting reverse(Sorting sort) {

		return ASC.equals(sort) ? DESC : ASC;
	}

}
