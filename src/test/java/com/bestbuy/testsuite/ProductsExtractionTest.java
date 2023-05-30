package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Created By Kashyap patel
 */
public class ProductsExtractionTest {

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

    //Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the name of 5th product
    @Test
    public void test003() {
        String storeName = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the names of all the products
    @Test
    public void test004() {
        List<String> namesAllProducts = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the products is : " + namesAllProducts);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the productId of all the products
    @Test
    public void test005() {
        List<Integer> productsIDs = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The productId of all the products is : " + productsIDs);
        System.out.println("------------------End of Test---------------------------");
    }

    //Print the size of the data list
    @Test
    public void test006() {
        List<HashMap<String, ?>> size = response.extract().path("data");
        int listSize = size.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list is : " + listSize);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the product where product name = Energizer - MAX Batteries AA (4-Pack) is : " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test008() {

        List<String> model = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack) is : " + model);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get all the categories of 8th products
    @Test
    public void test009() {
        List<HashMap<String, ?>> categories = response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of 8th products is : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get categories of the store where product id = 150115
    @Test
    public void test010() {
        List<HashMap<String, ?>> categoriesMap = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of the store where product id = 150115 is : " + categoriesMap);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get all the descriptions of all the products
    @Test
    public void test011() {
        List<Object> descriptions = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The descriptions of all the products is : " + descriptions);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get id of all the all categories of all the products
    @Test
    public void test012() {
        List<Object> ids = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id of all the all categories of all the products : " + ids);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the product names Where type = HardGood
    @Test
    public void test013() {
        List<HashMap<String, ?>> names = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The he product names Where type = HardGood is : " + names);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the Total number of categories for the product where product name = Duracell - AA
    //1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test014() {
        List<HashMap<String, ?>> numberOfCategories = response.extract().path("data.findAll{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories.id");
        int sizeOfCategories = numberOfCategories.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Total number of categories for the product : " + sizeOfCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the createdAt for all products whose price < 5.49
    @Test
    public void test015() {
        List<HashMap<String, ?>> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        Object object = createdAt.toString();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.49 is : " + object);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-
    //Pack)”
    @Test
    public void test016() {
        List<HashMap<String, ?>> nameOfCategories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all categories is : " + nameOfCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the manufacturer of all the products
    @Test
    public void test017() {
        List<Object> manufacturer = response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The manufacturer of all the products is : " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the image of products whose manufacturer is = Energizer
    @Test
    public void test018() {
        List<HashMap<String, ?>> image = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image of products whose manufacturer is = Energizer is : " + image);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test019() {
        List<HashMap<String, ?>> createdAt = response.extract().path("data.findAll{it.price > 5.99}.categories.createdAt");
        Object object = createdAt.toString();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all categories products whose price > 5.99 is : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //Find the uri of all the products
    @Test
    public void test020() {
        List<Object> url = response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The uri of all the products is : " + url );
        System.out.println("------------------End of Test---------------------------");
    }

}
