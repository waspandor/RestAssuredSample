/**
 * Created by Waseem on 7/20/2017.
 */

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class StepDefinitions {

    Response response;
    URL url;

    @Before
    public void setUp() throws MalformedURLException {

    }


    @Given("^user navigates to postcodeIo$")
    public void user_navigates_to_postcodeIo() throws Throwable {

        url = new URL("http://api.postcodes.io/postcodes/n12qp");

        response = given().accept(ContentType.JSON).
                when().get(url);

    }

    @Then("^a (\\d+) status is returned$")
    public void a_status_is_returned(int responseCode) throws Throwable {

        response.then().assertThat().statusCode(responseCode);

    }

}
