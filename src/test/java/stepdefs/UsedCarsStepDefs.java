package stepdefs;

import cucumber.api.PendingException;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class UsedCarsStepDefs {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private String ENDPOINT_GET_BOOK_BY_ISBN = "https://api.trademe.co.nz/v1/Categories/UsedCars.json";

    @Given("I want to see subcategories as well")
    public void get_sub_categories(){
        request = given().param("depth", 1);
    }

    @When("I retrieve the list of used cars")
    public void a_user_retrieves_the_book_by_isbn(){
        response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
//        System.out.println("response: " + response.prettyPrint());
    }

    @Then("the status code is (\\d+)")
    public void verify_status_code(int statusCode){
        json = response.then().statusCode(statusCode);
    }

    @And("there should be at least one listing")
    public void validate_atleast_one_listing(){
        json.body("final_list", not(hasSize(0)));
    }

    @Then("(.+) must exist")
    public void make_must_exist(String make){
//        response.jsonPath().
//        json.body(contains(make));
        ResponseBody responseBody = response.body();
        String bodyAsAString = responseBody.asString();
        assert(bodyAsAString.contains(make));
    }

    @Given("I search for used cars")
    public void search_used_cars(){
        //To-Do Code to get the active listing IDs of used cars
        //https://developer.trademe.co.nz/api-reference/search-methods/used-motors-search/
        //Use https://api.trademe.co.nz/v1/Search/Motors/Used.{file_format}

    }

    @Given("I request for a particular listing")
    public void send_request_for_a_Listing(){
        //To-Do Code to get the a listing using the extracted Listing id from above
        //https://developer.trademe.co.nz/api-reference/listing-methods/retrieve-the-details-of-a-single-listing/
        //Use https://api.trademe.co.nz/v1/Listings/{listingId}.{file_format}
    }

    @Given("I should get all the used car details in response")
    public void Check_response_for_details(){
        //To-Do Code to check response for all the details
    }
}
