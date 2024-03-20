package Stepdef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Utiles.utils;

import static junit.framework.TestCase.assertEquals;


public class getProductsStep extends utils{



    public static JSONObject requestParams;

    static RequestSpecification httprequest;
    static Response response ;
    static int statuscode;

    static  String responsebody;
    static String id ;

    static int id1;




    @Given("to set the uri of that site")
    public void giving_value_of_products() {

//
        RestAssured.baseURI = "https://fakestoreapi.com/";


    }

    @When("to get the products from the site")
    public void get_all_values_of_an_api() {
        httprequest = RestAssured.given();
        response = httprequest.get("products");
        String responseBody = response.asString();
        System.out.println(responseBody);

        statuscode = response.statusCode();

        System.out.println(statuscode);


    }
    @Then("validate the products")
    public void validate_the_products() {
        Assert.assertEquals("output failed with the status code is not right " ,200,statuscode);
    }


    @When("set the values as {string} and {double} and {string} and {string} and {string}\"")
    public void set_the_values_as_and_and_and_and(String title, double price, String description, String image, String category) {
        httprequest = RestAssured.given();
        requestParams = new JSONObject();
        requestParams.put("title", title);
        requestParams.put("price", price);
        requestParams.put("description", description);
        requestParams.put("image", image);
        requestParams.put("category", category);

        String request = convertObjectToJson(requestParams);
        System.out.println("request is  : "  +request);

        response = httprequest.contentType("application/json").body(requestParams.toJSONString()).post("products");
        responsebody = response.asString();
        System.out.println("response body is " + responsebody);

        statuscode = response.statusCode();

        if (statuscode == 200) {
            JsonPath jsonPath = response.jsonPath();
            id = jsonPath.getString("id");
            System.out.println("ID: " + id);
        } else {
            id = null;
            System.out.println("Failed to retrieve ID, response status code: " + statuscode);
        }
    }

    @Then("validate the id is present or not")
    public void validate_the_id_is_present_or_not() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(200,statuscode);
        Assert.assertNotNull("the given id is not there ->",id);
    }

    @And("add the value as the userid as {int}")
    public void add_the_value_as_the_userid_as_value(int value)
    {
        httprequest = RestAssured.given();

        requestParams = new JSONObject();


        List<Map<String, Object>> products = new ArrayList<>();

        // Add products to the sub-array
        Map<String, Object> product1 = new HashMap<>();
        product1.put("productId", 5);
        product1.put("quantity", 1);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("productId", 1);
        product2.put("quantity", 5);


        products.add(product1);
        products.add(product2);

        requestParams.put("userId",value);
        requestParams.put("date",2020-02-03);
        requestParams.put("products",products);


// printing through gson

        String requestbody = convertObjectToJson(requestParams);
        //printing request
//        String requestBodyJson = "{\n" +
//                "  \"userId\": " + requestParams.get("userId") + ",\n" +
//                "  \"date\": \"" + requestParams.get("date") + "\",\n" +
//                "  \"products\": [\n" +
//                "    {\n" +
//                "      \"productId\": " + product1.get("productId") + ",\n" +
//                "      \"quantity\": " + product1.get("quantity") + "\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"productId\": " + product2.get("productId") + ",\n" +
//                "      \"quantity\": " + product2.get("quantity") + "\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
//
//        // Print the request body
//        System.out.println("Request Body:");
//        System.out.println(requestBodyJson);
    }

    @When("we called the the api and printing the id")
    public static void we_called_the_api_and_printing_the_id()
    {
        response = httprequest.contentType("application/json").body(requestParams.toJSONString()).post("products");
        String responsebody = response.asString();
        System.out.println("reponse is --->" + responsebody);
         statuscode = response.statusCode();
        System.out.println("status code is " + statuscode);

        JsonPath json = new JsonPath(responsebody);
         id1 = json.get("id");

         System.out.println("id is : " + responsebody);
    }

    @Then("validate the status code and id is not null")
    public static void check_status_code()
    {
        Assert.assertEquals(200,statuscode);
       Assert.assertNotNull(id1);

    }

}
