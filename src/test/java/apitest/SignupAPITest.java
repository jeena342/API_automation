package apitest;

import org.testng.annotations.Test;

import apibase.AuthService;
import io.restassured.response.Response;

import models.request.SignUpRequest;
import utils.ConfigReader;


public class SignupAPITest {
	@Test
	public void createAccountTest() {
	String username = ConfigReader.get("USERNAME");
	String password = ConfigReader.get("PASSWORD");
	String firstname = ConfigReader.get("FIRSTNAME");
	String lastname = ConfigReader.get("LASTNAME");
	String email = ConfigReader.get("EMAIL");
	String mobilenumber = ConfigReader.get("MOBILENUMBER");
	SignUpRequest signUpRequest=new SignUpRequest.Builder().email(email).password(password).username(username).firstName(firstname).lastName(lastname).mobileNumber(mobilenumber).build();
	AuthService authService=new AuthService();
	Response response=authService.signup(signUpRequest);
	
	System.out.println(response.asPrettyString());
	
	}
}
