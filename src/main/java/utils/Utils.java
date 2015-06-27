package utils;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

public class Utils {
    public static String getRandomString() {
        return getRandomString(10);
    }

    public static String getRandomString(Integer numberOfChars) {
        return RandomStringUtils.randomAlphabetic(numberOfChars);
    }

    public static Integer getRandomInt() {
        return new Random().nextInt(1000);
    }
}
