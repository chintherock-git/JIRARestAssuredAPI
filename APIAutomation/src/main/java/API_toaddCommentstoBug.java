
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import java.io.File;

public class API_toaddCommentstoBug {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="http://localhost:8080";
		SessionFilter session = new SessionFilter();
		
		
		//A session filter can be used record the session id returned from the server as well as automatically apply this 
		//session id in subsequent requests. For example:
		String response= given().header("Content-Type","application/json").body("{\r\n"+
        " \"username\": \"chinmayeebaitharu\",\r\n "+
        " \"password\": \"chinmayee\" \r\n"+
        "}").log().all().filter(session).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();
		
		System.out.println(response);
		
		//Add Issue to Jira to defined Project 
		response=given().header("Content-Type","application/json").log().all().body("{\n"
				+ "    \"fields\": {\n"
				+ "       \"project\":\n"
				+ "       {\n"
				+ "          \"key\": \"SEC\"\n"
				+ "       },\n"
				+ "       \"summary\": \"BUG010_Postman_something's wrong_From_RestAssured\",\n"
				+ "       \"description\": \"Creating of an issue using ids for projects and issue types using the REST API\",\n"
				+ "       \"issuetype\": {\n"
				+ "          \"id\": \"10004\"\n"
				+ "       }\n"
				+ "   }\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/").then().
				extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String bug_id=js.getString("id");
		
		//Add Comments to Bug
		response=given().header("Content-Type","application/json").log().all().body("{\n"
				+ "    \"body\": \"Added new Comment from Rest Assured Automation.\",\n"
				+ "    \"visibility\": {\n"
				+ "        \"type\": \"role\",\n"
				+ "        \"value\": \"Administrators\"\n"
				+ "    }\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/"+bug_id+"/comment").then().log().all().assertThat().statusCode(201).
				extract().response().asString();
		js= new JsonPath(response);
		String comment_id = js.getString("id");
		System.out.println(response);
		
		//Update comments to bug and having the comment id 
		response=given().header("Content-Type", "application/json").log().all().filter(session).when().body("{\n"
				+ "    \"body\": \"latest comment updated via automation.\",\n"
				+ "    \"visibility\": {\n"
				+ "        \"type\": \"role\",\n"
				+ "        \"value\": \"Administrators\"\n"
				+ "    }\n"
				+ "}").put("/rest/api/2/issue/"+bug_id+"/comment/"+comment_id+"").then().assertThat().statusCode(200).extract().response().asString();
	
	
	//Add atttachment to bug 
		//keep in mind the content_type to be multipart/form-data and multipart to add file needs file and new File to be created
		//here sample.doc is in the Project folder
		//Do not ,mention header().header() it gives exception
	            given().header("X-Atlassian-Token","no-check").filter(session).header("Content-Type","multipart/form-data").multiPart("file",new File("sample.doc")).
				when().post("/rests/api/2/issue/"+bug_id+"/attachments").then().assertThat().statusCode(200);
	
	
	}

}
