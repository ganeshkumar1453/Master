package com.cts.rest.model;

import java.io.Serializable;
import java.util.List;

public class CityDetailResponse implements Serializable{

	private List<CityCountry> cityCountryList = null;

	public List<CityCountry> getCityCountryList() {
		return cityCountryList;
	}

	public void setCityCountryList(List<CityCountry> cityCountryList) {
		this.cityCountryList = cityCountryList;
	}

	@Override
	public String toString() {
		return "CityDetailResponse [cityCountryList=" + cityCountryList + "]";
	}

}
