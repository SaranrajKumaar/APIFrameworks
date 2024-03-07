package stepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Resources.APIResource;
import Resources.Utils;
import Resources.testData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class stepDefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification resspe;
	static Response responseobj;
	JsonPath js ;
	static String place_ID;

	static testData td = new testData();

	@Given("Add place from payload with {string} {string} {string}")
	public void add_place_from_payload_with(String name, String language, String address) throws IOException {

		res = given().log().all().spec(requestSpecification())
				.body(td.addplacePayload(name, language, address));

	}

	@When("User calls {string} with {string} http Request")
	public void user_calls_with_http_request(String resource, String method) {

		APIResource resourceAPI = APIResource.valueOf(resource);

		System.out.println(resourceAPI.getResource());
		if (method.equalsIgnoreCase("POST")) {

			responseobj = res.when().post(resourceAPI.getResource());
			
		} else if (method.equalsIgnoreCase("GET")) {

			responseobj = res.when().get(resourceAPI.getResource());
		}

		responseobj.then().log().all().assertThat().spec(responseSpecification()).extract().response();
	}

	@Then("the API Call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(responseobj.statusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String exceptedkeyValue) {
		
		
		assertEquals(getJsonPath(responseobj,keyValue), exceptedkeyValue);
	}

//get place
	
	@Then("verify place_ID created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName , String Resource) throws IOException {
	    //req spec
		
		place_ID=getJsonPath(responseobj, "place_id");
		res = given().log().all().spec(requestSpecification()).queryParam("place_id",place_ID );
		user_calls_with_http_request(Resource, "GET");
		String name =getJsonPath(responseobj, "name");

		assertEquals(name, expectedName);
	}


	//Delete payload
	


	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		
		
		res= given().spec(requestSpecification()).body(td.deletepayLoad(place_ID));
	   
	}
	





}
