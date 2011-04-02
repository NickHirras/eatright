package com.eatrightapp.service.api.converter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.eatrightapp.service.api.model.ERAUser;
import com.eatrightapp.service.api.model.ERAUser.Status;

@XmlRootElement(name = "user")
public class ERAUserConverter {
	private ERAUser entity;

	public ERAUserConverter() {
		entity = new ERAUser();
	}

	public ERAUserConverter(ERAUser entity) {
		this.entity = entity;
	}

	public ERAUser getERAUser() {
		return entity;
	}

	@XmlElement
	public String getEmail() {
		return entity.getEmail();
	}

	public void setEmail(String setEmail) {
		entity.setEmail(setEmail);
	}	

	@XmlElement
	public String getNickname() {
		return entity.getNickname();
	}

	public void setNickname(String nickname) {
		entity.setNickname(nickname);
	}	

	@XmlElement
	public String getPasswordMD5() {
		return entity.getPasswordMD5();
	}

	public void setPasswordMD5(String passwordMD5) {
		entity.setPasswordMD5(passwordMD5);
	}	
	
	@XmlElement
	public Status getStatus() {
		return entity.getStatus();
	}

	public void setStatus(Status status) {
		entity.setStatus(status);
	}	
}
