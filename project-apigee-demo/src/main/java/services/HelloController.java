package services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rest.delegate.CountryBusinessDelegate;
import com.cts.rest.model.CityCountry;
import com.cts.rest.model.CityDetailResponse;
import com.cts.rest.model.CommonPostRequest;
import com.cts.rest.model.CountryName;
import com.cts.rest.model.RequestBuilder;
@SpringBootApplication
@ComponentScan("com.cts.rest")
@RestController
public class HelloController {

	@Autowired
	private RequestBuilder requestBuilder;

	@Autowired
	private CountryBusinessDelegate countryBusinessDelegate;

	@RequestMapping("/sdfsd")
	public String index() {
		System.out.println("In index Method");
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/country")
	public Response getCitiesData(@RequestBody CommonPostRequest reqBody, @HeaderParam("app_id") String appId,
			@QueryParam("country_cd") String marketCd, @Context HttpHeaders headers) {
		System.out.println("in the country method");
		CountryName countryNm = null;
		if (reqBody != null) {
			System.out.println("GCCSCommonPostRequest" + reqBody);
			System.out.println("requestBuilder" + requestBuilder);
			countryNm = requestBuilder.buildRequest(reqBody);
		}
		CityDetailResponse result = countryBusinessDelegate.getCityDetails(countryNm);
		return Response.status(200).entity(result).build();

	}
	
	
	@RequestMapping("/city/{countryName}")
	public Response getCitiesListData(@PathVariable("countryName") String countryName, @Context HttpHeaders headers) {
		System.out.println("in the cities  method");
		List<CityCountry> result = countryBusinessDelegate.getCityCountriesList(countryName);
		return Response.status(200).entity(result).build();

	}

}
