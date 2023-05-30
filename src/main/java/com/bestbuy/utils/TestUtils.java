package com.bestbuy.utils;

import java.util.Random;

/**
 * Created By Kashyap patel
 */
public class TestUtils {
    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(1000);
        return Integer.toString(randomInt);
    }


}
