import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


/**
 * Created by Waseem on 7/19/2017.
 */
public class TestCaseOne {

    Response response;

    @Before
    public void setUp() throws MalformedURLException {

        URL url = new URL("http://api.postcodes.io/postcodes/n12qp");
        response = given().accept(ContentType.JSON).when().get(url);
        //System.out.println(response.asString());
    }

    @Test
    public void verifyResponseCode() throws MalformedURLException {

        response.then().assertThat().statusCode(200);
    }

    @Test
    public void verifyPostcode(){

        response.then().assertThat().body("result.postcode", equalTo("N1 2QP"));
    }

    @Test
    public void verifyCountry(){

        response.then().assertThat().body("result.country", equalTo("England"));
    }
}
