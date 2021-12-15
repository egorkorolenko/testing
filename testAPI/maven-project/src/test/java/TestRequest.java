import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestRequest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGET(){
        Response response = given().
                contentType(ContentType.JSON)
                .when()
                .get("/posts/1")
                .then()
                .extract().response();

        assertEquals(200,response.statusCode());
        assertEquals("1",response.jsonPath().getString("userId"));
        assertEquals("quia et suscipit\n" +
                "suscipit recusandae consequuntur expedita et cum\n" +
                "reprehenderit molestiae ut ut quas totam\n" +
                "nostrum rerum est autem sunt rem eveniet architecto",response.jsonPath().getString("body"));
    }

    @Test
    public void testPOST(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "  \"title\": \"title\",\n" +
                        "  \"body\": \"body\",\n" +
                        "  \"userId\": \"2\" \n}")
                .when()
                .post("/posts")
                .then()
                .extract().response();

        assertEquals(201,response.statusCode());
        assertEquals("body",response.jsonPath().getString("body"));
        assertEquals("2",response.jsonPath().getString("userId"));
    }


    @Test
    public void testPUT(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "  \"title\": \"NEWtitle\",\n" +
                        "  \"body\": \"NEWbody\",\n" +
                        "  \"userId\": \"3\" \n}")
                .when()
                .put("/posts/1")
                .then()
                .extract().response();

        assertEquals(200,response.statusCode());
        assertEquals("NEWbody",response.jsonPath().getString("body"));
        assertEquals("3",response.jsonPath().getString("userId"));

    }


    @Test
    public void testDELETE(){
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/posts/1")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertNull(response.jsonPath().getString("body"));
        assertNull(response.jsonPath().getString("userId"));
        assertNull(response.jsonPath().getString("title"));
    }
}
