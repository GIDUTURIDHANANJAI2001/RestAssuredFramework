package Stepdef;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utiles.utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import postinputpojo1.postInputPojo;
import postinputpojo1.postOutputPojo;
import Stepdef.nt_thai_seeting_01;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class nt_thai_post_stepdef extends utils {


    private RequestSpecification request;

    private Response response;

    static RequestSpecification requestSpec;

    @Given("to set the uri of that site in nt thai")
    public void to_set_the_uri_of_that_site_in_nt_thai() {

        requestSpec = given().spec(givenHeader());


    }
    @When("set the values as {double} and {string}")
    public void set_the_values_as_and(double price1, String description1) throws JsonProcessingException {

        nt_thai_seeting_01 ntThaiSeeting01 = new nt_thai_seeting_01();
        ntThaiSeeting01.setPriceAndDescription(price1, description1);
//        sending request
        request = requestSpec.body(convertObjectToJson(ntThaiSeeting01.requestPayLoad()));
//        getting response
        response = request.when().post("products");

    }
    @Then("validate the id is present or not in nt thai")
    public void validate_the_id_is_present_or_not_in_nt_thai() {

        postOutputPojo responseBody = response.getBody().as(postOutputPojo.class);

        String responseBody11 = response.asString();
        System.out.println("output payload is --> "  + responseBody11);
        responseBody11.getBytes();
        JsonPath jsnPath = response.jsonPath();
        String id = jsnPath.getString("id");


//validating

        assertEquals(response.statusCode(), 200);
        assertNotEquals(responseBody.getId(),null);
        assertNotNull("the test case failed with title is null : -- ",responseBody.getTitle());
        assertNotNull("the test case failed with price is null : -- ",responseBody.getPrice());
        assertNotNull("the test case failed with description is null : -- ",responseBody.getDescription());
        assertNotNull("the test case failed with image is null : -- ",responseBody.getImage());





    }

}
