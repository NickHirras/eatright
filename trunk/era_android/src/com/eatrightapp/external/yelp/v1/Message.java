package com.eatrightapp.external.yelp.v1;

public class Message {
	private String text;
	private long code;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
}
