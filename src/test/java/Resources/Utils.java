package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	public static RequestSpecification req;
	ResponseSpecification resspe;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		if (req==null) {
			
		PrintStream ps = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getgolbalvalue("baseURL"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(ps))
				.addFilter(ResponseLoggingFilter.logResponseTo(ps))
				.setContentType(ContentType.JSON).build();
		
		return req;
		}
		return req;
	}
	
	public ResponseSpecification responseSpecification() {
		resspe = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		return resspe;
	}
	
	public static String getgolbalvalue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\REST API\\Basic\\APIframework\\src\\test\\java\\Resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		

}
	
	public static String getJsonPath(Response responseobj ,String key) {
		
		String str = responseobj.asString();
		JsonPath js = new JsonPath(str);
		return js.get(key).toString();
		
		
	}
}
 