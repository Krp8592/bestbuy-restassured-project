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
public class StoresExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

      RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
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
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    //Extract the name of 5th store
    @Test
    public void test003() {
        String storeName = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store : " + storeName);
        System.out.println("------------------End of Test---------------------------");

    }

    //Extract the names of all the store
    @Test
    public void test004() {
        List<String> namesAllStores = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the store is : " + namesAllStores);
        System.out.println("------------------End of Test---------------------------");

    }

    //Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> storeIDs = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store is : " + storeIDs);
        System.out.println("------------------End of Test---------------------------");
    }

    //Print the size of the data list
    @Test
    public void test006() {
        List<Object> objectList = response.extract().path("data");
        int sizeOfDataList = objectList.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list is : " + sizeOfDataList);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store where store name = St Cloud is : " + values);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<String> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name = Rochester is : " + address );
        System.out.println("------------------End of Test---------------------------");

    }

    //Get all the services of 8th store
    @Test
    public void test009() {
        List<HashMap<String, ?>> services = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of 8th store : " + services);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {
        List<HashMap<String ,?>> storeServices=response.extract().path("data.services*.find{it.name=='Windows Store'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Storeservices of the store where service name = Windows Store is : " + storeServices);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get all the storeId of all the store
    @Test
    public void test011() {
        List<Object> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store is : " + storeId);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get id of all the store
    @Test
    public void test012() {
        List<Integer> storeIDs = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + storeIDs );
        System.out.println("------------------End of Test---------------------------");

    }

    //Find the store names Where state = ND
    @Test
    public void test013() {
        List<String> state = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names Where state = ND is : " + state);
        System.out.println("------------------End of Test---------------------------");

    }

    //Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {
        List<Object> services = response.extract().path("data.findAll{it.name == 'Rochester'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + services );
        System.out.println("------------------End of Test---------------------------");

    }

    //Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015() {
        List<String> createdAt = response.extract().path("data.services*.find{it.name == 'Windows Store'}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all services whose name = “Windows Store” is : " + createdAt);
        System.out.println("------------------End of Test---------------------------");

    }

    //Find the name of all services Where store name = “Fargo”
    @Test
    public void test016() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all services Where store name = “Fargo” is : " + values );
        System.out.println("------------------End of Test---------------------------");

    }

    //Find the zip of all the store
    @Test
    public void test017() {
        List<Integer> storeZips = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of all the store is : " + storeZips);
        System.out.println("------------------End of Test---------------------------");

    }

    //Find the zip of store name = Roseville
    @Test
    public void test018() {
        List<Object> storeZip = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of store name = Roseville is : " + storeZip);
        System.out.println("------------------End of Test---------------------------");

    }

    //Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
        //List<HashMap<String, ?>> storeServicesMap = response.extract().path("data.services.findAll{it.name == 'Magnolia Home Theater'}!=null.storeservices");
        List<HashMap<String,?>> name = response.extract().path("data.findAll{it.services.find{it.name == 'Magnolia Home Theater'}!=null}.services.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeservices details of the service name = Magnolia Home Theater is : " + name);
        System.out.println("------------------End of Test---------------------------");

    }

    //Find the lat of all the stores
    @Test
    public void test020() {
        List<Object> objectList = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The lat of all the stores is : " + objectList);
        System.out.println("------------------End of Test---------------------------");

    }
}
