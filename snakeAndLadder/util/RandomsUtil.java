package snakeAndLadder.util;

import java.util.Random;

public class RandomsUtil {

    private static final Random r = new Random();

    public static Integer getRandomValueBetweenAAndBInclusive(int a, int b) {
        return r.nextInt(a, b + 1);
    }

    public static Integer getRandomValueBetweenAAndBExclusive(int a, int b) {
        return r.nextInt(a, b);
    }

}
