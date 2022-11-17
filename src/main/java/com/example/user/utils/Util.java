package com.example.user.utils;

/**
 * This class contains most commonly used methods in application
 */
public class Util {

    /**
     * Sorting order constant for  pagination
     */
    public static final int ASC = 1;

    /**
     * Sorting order constant for pagination
     */
    public static final int DESC = 2;

    /**
     * This method is used to generate random number for resetting password
     *
     * @return random token generator
     */
    public static String getRandomToken() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(30);

        for (int i = 0; i < 30; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}

