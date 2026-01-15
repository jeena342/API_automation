package apitest;

import org.testng.annotations.Test;

import apibase.AuthService;
import apibase.UserProfileManagementService;
import io.restassured.response.Response;
import models.request.LoginRequest;
import models.response.LoginResponse;
import utils.ConfigReader;

public class GetProfileRequestTest {
	@Test
	public void getProfileInfoTest() {
		String username = ConfigReader.get("USERNAME");
		String password = ConfigReader.get("PASSWORD");
		AuthService authService=new AuthService();
		Response response=authService.login(new LoginRequest(username,password));
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
		response =userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
	}
}
