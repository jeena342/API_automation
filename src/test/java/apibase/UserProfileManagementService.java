package apibase;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {
	private static final String BASE_URL="/api/users/";
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_URL+"profile");
	}
	public Response updateProfile(String token,Object payload) {
		setAuthToken(token);
		return putRequest(payload,BASE_URL+"profile");
	}

}
