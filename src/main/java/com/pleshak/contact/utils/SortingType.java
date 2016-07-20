package com.pleshak.contact.utils;

public enum SortingType {
	EMAIL("email"), LOGIN("login"), NAME("name"), PHONENUMBER("phoneNumber"), SURNAME("surname"), ID("id");

	private String value;

	public String getValue() {
		return value;
	}

	private SortingType(String value) {
		this.value = value;
	}

	public static SortingType safeValueOf(final String value) {
		try {
			return SortingType.valueOf(value.toUpperCase());
		} catch (IllegalArgumentException ex) {
			return NAME;
		}
	}
}
