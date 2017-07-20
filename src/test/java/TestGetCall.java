import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by pandorw on 20/07/2017.
 */
public class TestGetCall {

    Response response;
    URL url;


    @Before
    public void setup() throws MalformedURLException {

        url = new URL("http://api.postcodes.io/postcodes/n12qp");

        response = given().accept(ContentType.JSON).
                when().get(url);
    }

    @Test
    public void verifyResponseCode() {

        response.then().assertThat().body("result.postcode", equalTo("N1 2QP"));
    }

    @Test
    public void verifyStatusCode() {

        response.then().assertThat().statusCode(200);

    }

    @Test
    public void verifyHeaders(){

        System.out.println(response.getHeaders());

        response.then().assertThat().header("Content-Length", equalTo("713"));
    }



}