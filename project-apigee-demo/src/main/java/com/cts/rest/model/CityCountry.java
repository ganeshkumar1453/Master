package com.cts.rest.model;

import java.io.Serializable;

public class CityCountry implements Serializable{

	private String cityNm;
	private String CountryNm;

	public String getCityNm() {
		return cityNm;
	}

	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}

	public String getCountryNm() {
		return CountryNm;
	}

	public void setCountryNm(String countryNm) {
		CountryNm = countryNm;
	}

	@Override
	public String toString() {
		return "CityCountry [cityNm=" + cityNm + ", CountryNm=" + CountryNm + "]";
	}

}
