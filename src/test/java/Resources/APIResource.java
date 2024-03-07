package Resources;

public enum APIResource {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");

	private String resource;
	
	APIResource(String resource) {
		
		this.resource=resource;
		// TODO Auto-generated constructor stub
	}

	public String getResource() {
		return resource;
		
	}
}
