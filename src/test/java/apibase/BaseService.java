package apibase;

import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response; 

public class BaseService {
	private static final String BASE_URL= ConfigReader.get("BASE_URL");
	
	private RequestSpecification requestSpecification;

	public BaseService() {
		requestSpecification =given().baseUri(BASE_URL);
	
	}

	protected Response postRequest(Object payload,String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization","Bearer "+token);
		
	}
	
	protected Response putRequest(Object payload,String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	

}
