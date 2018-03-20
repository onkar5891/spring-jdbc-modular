package com.ok.spring.jdbc.entity;

public class KeyVal {
	private String key;
	private String value;

	public KeyVal(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return this.key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "{" + this.key + ": " + this.value + "}";
	}
}

