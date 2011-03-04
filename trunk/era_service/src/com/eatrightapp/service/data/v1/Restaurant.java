package com.eatrightapp.service.data.v1;

import javax.persistence.Id;
import javax.persistence.Transient;

public class Restaurant {
	@Id String id;
	Boolean chain;
	String chainId;
	@Transient ERAError error;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean isChain() {
		return chain;
	}
	public void setChain(Boolean chain) {
		this.chain = chain;
	}
	public String getChainId() {
		return chainId;
	}
	public void setChainId(String chainId) {
		this.chainId = chainId;
	}
	public ERAError getError() {
		return error;
	}
	public void setError(ERAError error) {
		this.error = error;
	}
}
