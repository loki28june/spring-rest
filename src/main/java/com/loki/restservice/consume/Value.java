package com.loki.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

	private Integer id;
	private String quote;

	Value() {

	}

	public Value(Integer id, String quote) {
		super();
		this.id = id;
		this.quote = quote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "Value [id=" + id + ", quote=" + quote + "]";
	}
}
