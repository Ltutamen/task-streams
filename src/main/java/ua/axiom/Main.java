package ua.axiom;

import java.util.Random;

public class Main {
    private static int ARR_SIZE = 32;

    public static void main(String[] args) {
        int[] arr = new int[32];
        Random random = new Random(123L);

        for (int i = 0; i < ARR_SIZE; i++) {
            arr[i] = random.nextInt(1024);
        }


        Exercise.ex2v1(arr);
    }
}
