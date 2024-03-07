package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@deleteplace")
	public void beforeScenario() throws IOException {

		stepDefinition sd = new stepDefinition();
		if (stepDefinition.place_ID == null) {

			sd.add_place_from_payload_with("mamusaran", "Tamil&Telugu", "Eroder and Khabhanm");

			sd.user_calls_with_http_request("AddPlaceAPI", "POST");
			sd.verify_place_id_created_maps_to_using("mamusaran", "GetPlaceAPI");
		}
	}

}
