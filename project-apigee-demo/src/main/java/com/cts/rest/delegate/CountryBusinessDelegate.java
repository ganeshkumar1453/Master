package com.cts.rest.delegate;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import com.cts.rest.model.CityCountry;
import com.cts.rest.model.CityDetailResponse;
import com.cts.rest.model.CountryName;

import net.webservicex.GetWeather;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

@Component
public class CountryBusinessDelegate {

	public CityDetailResponse getCityDetails(CountryName countryName) {

		GlobalWeather globalWeather = new GlobalWeather();
		
		
		GlobalWeatherSoap globalWeatherSoap = globalWeather.getGlobalWeatherSoap();
		String city = globalWeatherSoap.getCitiesByCountry(countryName.getCountryNm());
		CityDetailResponse cityDetailResponse = new CityDetailResponse();
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(city));
			Document doc = builder.parse(src);
			NodeList cities = doc.getElementsByTagName("City");
			NodeList countries = doc.getElementsByTagName("Country");
			List<CityCountry> cityCountryList = new ArrayList<CityCountry>();
			for (int i = 0, j = 0; i < cities.getLength() && j < countries.getLength(); ++i, ++j) {
				CityCountry cityCountry = new CityCountry();
				Node fileCity = cities.item(i);
				Node fileCounty = cities.item(j);
				cityCountry.setCityNm(fileCity.getTextContent());
				cityCountry.setCountryNm(fileCounty.getTextContent());
				cityCountryList.add(cityCountry);
			}
			cityDetailResponse.setCityCountryList(cityCountryList);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cityDetailResponse;
	}
	
	
	
	public List<CityCountry> getCityCountriesList(String countryName) {
		System.out.println(countryName);
		GlobalWeather globalWeather = new GlobalWeather();
		GlobalWeatherSoap globalWeatherSoap = globalWeather.getGlobalWeatherSoap();
		String city = globalWeatherSoap.getCitiesByCountry(countryName);
		System.out.println(countryName);// United States
		CityDetailResponse cityDetailResponse = new CityDetailResponse();
		List<CityCountry> cityCountryList = new ArrayList<CityCountry>();
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(city));

			Document doc;

			doc = builder.parse(src);
			NodeList cities = doc.getElementsByTagName("City");
			NodeList countries = doc.getElementsByTagName("Country");
	

			for (int i = 0, j = 0; i < cities.getLength() && j < countries.getLength(); ++i, ++j) {
				CityCountry cityCountry = new CityCountry();
				Node fileCity = cities.item(i);
				Node fileCounty = cities.item(j);
				cityCountry.setCityNm(fileCity.getTextContent());
				cityCountry.setCountryNm(fileCounty.getTextContent());
				cityCountryList.add(cityCountry);
			}
			cityDetailResponse.setCityCountryList(cityCountryList);
			System.out.println(cityDetailResponse.toString());
			// while (doc.getElementsByTagName("City").item(2) != null) {
			//
			// String city1 =
			// doc.getElementsByTagName("City").item(0).getTextContent();
			// String country =
			// doc.getElementsByTagName("Country").item(0).getTextContent();
			//
			// System.out.println("99"+city1 + " " + country);
			// i++;
			// }
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cityCountryList;
	
	}
	
	public static void main(String[] args) {
//		CountryBusinessDelegate countryBusinessDelegate=new CountryBusinessDelegate();
//		countryBusinessDelegate.getCityCountriesList("US");
		try {
			int a=method1();
			System.out.println(a);
		}
		catch(Exception e) {
			
		}
	}



	@SuppressWarnings("finally")
	private static int method1() {
		// TODO Auto-generated method stub
		try {
		return 0/0;
		}
		catch(Exception e) {
			return 2;
		}
		finally {
			
			System.out.println("in finally");
			return 3;
		}
		
	}

}
