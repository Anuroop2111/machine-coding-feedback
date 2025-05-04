package snakeAndLadder.util;

import java.util.Random;

public class RandomGenerator {

    private RandomGenerator() {
        throw new AssertionError("Cannot create an instance of RandomGenerator");
    }

    private static final Random r = new Random();

    // Generates a random number from 1 to n (both inclusive)
    public static Integer generate(int n) {
        return r.nextInt(1, n);
    }

}
