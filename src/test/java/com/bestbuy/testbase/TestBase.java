package com.bestbuy.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created By Kashyap patel
 */
public class TestBase {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
    }
}
