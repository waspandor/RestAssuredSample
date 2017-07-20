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
public class TestPostCall {

    Response response;
    URL url;


    @Before
    public void setup() throws MalformedURLException {

        url = new URL("http://putsreq.com/VnqmQjVRGLndiaaaZbW8");

        response = given().accept(ContentType.JSON).queryParam("name","Pablo").
                when().post(url);
    }

    @Test
    public void verifyResponseCode() {

        System.out.println(response.body().asString());
    }


}