package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created By Kashyap patel
 */
public class ProductAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    //Verify the if the total is equal to 51980
    @Test
    public void test001() {
        response.body("total", equalTo(51980));
    }

    //Verify the if the stores of limit is equal to 10
    @Test
    public void test002() {
        response.body("limit", equalTo(10));
    }

    //Check the single ‘Name’ in the Array list (Duracell - AAA Batteries (4-Pack))
    @Test
    public void test003() {
        response.body("data.name",hasItem("Duracell - AAA Batteries (4-Pack)"));
    }

    //Check the multiple ‘Names’ in the ArrayList (Duracell - AA 1.5V CopperTop Batteries (4-Pack), Duracell - AA Batteries (8-Pack), Energizer - MAX Batteries AA (4-Pack))
    @Test
    public void test004() {
        response.body("data.name",hasItems("Duracell - AA Batteries (8-Pack)", "Duracell - AA 1.5V CopperTop Batteries (4-Pack)","Energizer - MAX Batteries AA (4-Pack)"));
    }

    //Verify the productId=150115 inside categories of the third name is “Household Batteries”
    @Test
    public void test005() {
        response.body("data[3].id", equalTo(150115));
    }

    //Verify the categories second name = “Housewares” of productID = 333179
    @Test
    public void test006() {
        response.body("data[8].categories[1].name", equalTo("Housewares"));
    }

    //Verify the price = 4.99 of forth product
    @Test
    public void test007() {
        response.body("data[3].price", Matchers.equalTo(4.99f));
    }

    //Verify the Product name = Duracell - D Batteries (4-Pack) of 6th product
    @Test
    public void test008() {
        response.body("data[5].name", equalTo("Duracell - D Batteries (4-Pack)"));
    }

    //Verify the ProductId = 333179 for the 9th product
    @Test
    public void test009() {
        response.body("data[8].id", equalTo(333179));
    }

    //Verify the prodctId = 346575 have 5 categories
    @Test
    public void test010() {
        response.body("data[9].categories", hasSize(5));
    }
}
