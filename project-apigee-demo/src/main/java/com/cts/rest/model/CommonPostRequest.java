
package com.cts.rest.model;

/**
 * This class is used to hold the common attributes of all GET services which
 * will be passed from request
 * 
 */
public class CommonPostRequest {

	private String countryName;

	private String ipAddress;

	public CommonPostRequest() {

	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "CommonPostRequest [countryName=" + countryName + ", ipAddress=" + ipAddress + "]";
	}

}
