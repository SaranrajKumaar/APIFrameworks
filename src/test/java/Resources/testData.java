package Resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class testData {

	public AddPlace addplacePayload(String name, String language, String address) {

		AddPlace ap = new AddPlace();
		ap.setAccuracy(60);
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("www.saranmamu.com");
		List<String> mylist = new ArrayList<String>();
		mylist.add("saran");
		mylist.add("Mamatha");
		mylist.add("4 years");

		ap.setTypes(mylist);
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(+-33.427362);
		ap.setLocation(loc);

		return ap;

	}

	public String deletepayLoad(String placeID) {

		return "{\r\n" + "    \"place_id\":\""+placeID+"\"\r\n" + "}";
	}

}
