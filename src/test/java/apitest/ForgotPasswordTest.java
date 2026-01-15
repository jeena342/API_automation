package apitest;

import org.testng.annotations.Test;

import apibase.AuthService;
import io.restassured.response.Response;
import utils.ConfigReader;

public class ForgotPasswordTest {
	@Test
	public void forgotPasswordTest() {
	String email = ConfigReader.get("EMAIL");
	AuthService authService=new AuthService();
	Response response=authService.forgotPassword(email);
	System.out.println(response.asPrettyString());
	}
}
