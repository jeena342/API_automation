package apitest;

import org.testng.annotations.Test;

import apibase.AuthService;
import io.restassured.response.Response;
import models.request.LoginRequest;
import models.response.LoginResponse;
import utils.ConfigReader;

public class LoginAPITest {
	@Test
	
	public void loginTest() {
		String username = ConfigReader.get("USERNAME");
		String password = ConfigReader.get("PASSWORD");
		LoginRequest loginRequest=new LoginRequest(username,password);
		AuthService authService=new AuthService();
		Response response=authService.login(loginRequest);
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		
	}
}
