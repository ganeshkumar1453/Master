package com.cts.rest.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class RequestBuilder {


	public CountryName buildRequest(CommonPostRequest reqBody) {
		CountryName countryName = null;
		if (reqBody != null) {
			System.out.println(reqBody);
			countryName = new CountryName(reqBody.getCountryName());
		}
		return countryName;
	}

}
