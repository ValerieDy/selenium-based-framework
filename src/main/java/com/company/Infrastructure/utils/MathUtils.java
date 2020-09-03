package com.company.Infrastructure.utils;

public class MathUtils {
    public static int randomFromRange (int min, int max) {
        if (max < min)
            throw new IllegalArgumentException();
        return min + (int) Math.random()*((max - min)+1);

    }
}
