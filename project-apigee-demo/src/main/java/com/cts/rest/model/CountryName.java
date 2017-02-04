package com.cts.rest.model;

import java.io.Serializable;

public class CountryName implements Serializable{

	private String countryNm;

	public String getCountryNm() {
		return countryNm;
	}

	public void setCountryNm(String countryNm) {
		this.countryNm = countryNm;
	}

	@Override
	public String toString() {
		return "CountryName [countryNm=" + countryNm + "]";
	}

	public CountryName(String countryNm) {
		super();
		this.countryNm = countryNm;
	}

	
	
}
