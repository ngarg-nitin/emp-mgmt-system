package com.nitin.studies.empmgmt.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "api_token")
public class APIToken {

	@Id
	private String tokenValue;

	protected APIToken() {
		super();
	}

	public APIToken(String tokenValue) {
		super();
		this.tokenValue = tokenValue;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	@Override
	public String toString() {
		return String.format("APIToken [tokenValue=%s]", tokenValue);
	}
}
