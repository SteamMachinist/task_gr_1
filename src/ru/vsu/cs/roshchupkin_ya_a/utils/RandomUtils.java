package ru.vsu.cs.roshchupkin_ya_a.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static int getRandomIntBetween(int min, int max) {
        return min + random.nextInt(max);
    }

    public static double getRandomDoubleBetween(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    public static boolean getRandomBool() {
        return random.nextBoolean();
    }

    public static int[] getRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int n = 0; n < size; n++) {
            array[n] = getRandomIntBetween(min, max);
        }
        return array;
    }

    public static double[] getRandomArray(int size, double min, double max) {
        double[] array = new double[size];
        for (int n = 0; n < size; n++) {
            array[n] = getRandomDoubleBetween(min, max);
        }
        return array;
    }
}
