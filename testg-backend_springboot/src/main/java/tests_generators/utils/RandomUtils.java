package tests_generators.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomUtils {

    private final static String characters = ("~!@#$%^&*()_+=-;/*+.?|\\][}{'><,:");
    private static final Random random = null;

    public static boolean isNotCharacter(String value) {
        return !characters.contains(value);
    }

    public static String getRandomCharacter() {
        return String.valueOf(characters.charAt((int) ((Math.random() * (31)) + 0)));
    }

    public static String getRandomNegativeInRange(Integer min, Integer max) {
        Integer toValue = max;
        int tempNumber = (-1) * generateRandomNumber(toValue);
        if(tempNumber > min) {
            while (tempNumber > min) {
                toValue *= toValue;
                tempNumber = (-1) * generateRandomNumber(toValue);
            }
        } else if(tempNumber == 0) {
            tempNumber = (-1) * generateRandomNumber(1000);
        }
        return String.valueOf(tempNumber);
    }

    private static Integer generateRandomNumber(Integer max) {
        return getRandom().nextInt(max);
    }

    private static Random getRandom() {
        return Objects.requireNonNullElseGet(random, Random::new);
    }

    public static String getRandomValue(List<String> values) {
        int index = generateRandomNumber(values.size());
        return values.get(index);
    }

    public static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    private static Integer generateRandomNumberInRange(Integer min, Integer max) {
        return getRandom().nextInt(max - min) + max;
    }

    public static String getRandomTestName() {
        return "Test " + generateRandomNumberInRange(10000, 99999999);
    }
}
