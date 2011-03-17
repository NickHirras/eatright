package com.eatrightapp.service.v1.datastore;

import javax.persistence.Id;
import javax.persistence.Transient;

public class RestaurantDSO {
	@Id String id;
	Boolean chain;
	String chainId;
	
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
}
