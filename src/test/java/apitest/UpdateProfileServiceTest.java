package apitest;

import org.testng.annotations.Test;

import apibase.AuthService;
import apibase.UserProfileManagementService;
import io.restassured.response.Response;
import models.request.LoginRequest;
import models.request.ProfileRequest;
import models.response.LoginResponse;
import utils.ConfigReader;

public class UpdateProfileServiceTest {
	@Test
	public void UpdateProfileTest() {
	String username = ConfigReader.get("USERNAME");
	String password = ConfigReader.get("PASSWORD");
	String firstname = ConfigReader.get("FIRSTNAME");
	String lastname = ConfigReader.get("LASTNAME");
	String email = ConfigReader.get("EMAIL");
	String mobilenumber = ConfigReader.get("MOBILENUMBER");
	AuthService authService=new AuthService();
	Response response=authService.login(new LoginRequest(username,password));
	LoginResponse loginResponse=response.as(LoginResponse.class);
	System.out.println(loginResponse.getToken());
	System.out.println("------------------------------");
	UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
	response =userProfileManagementService.getProfile(loginResponse.getToken());
	System.out.println(response.asPrettyString());
	System.out.println("--------------------------------");
	ProfileRequest profileRequest=new ProfileRequest.Builder().lastName(lastname).firstName(firstname).email(email).mobileNumber(mobilenumber).build();
	response = userProfileManagementService.updateProfile(loginResponse.getToken(),profileRequest);
	System.out.println(response.asPrettyString());
	
	}
	
}
