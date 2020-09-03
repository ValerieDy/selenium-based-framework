package com.company.Infrastructure.utils;

public class StringUtils {
    public static enum StringType{
        ALPHA,
        NUMERIC,
        ALPHANUMERIC

    }

        public static String getRandom (StringType type, int length) {
            String alphabet;

            switch (type) {
                case ALPHA:
                    alphabet = "abcdefghjk";
                    break;
                case NUMERIC:
                    alphabet = "1234567890";
                    break;
                case ALPHANUMERIC:
                    alphabet = "abcde12345";
                    break;

                    default: throw new IllegalArgumentException("Unknown Type");
            }

            String result = "";
            for (int i = 0; i < length; i++) {
                int index = (int) (Math.random() * alphabet.length());
                result += alphabet.charAt(index);
            }

            return result;
        }



}
