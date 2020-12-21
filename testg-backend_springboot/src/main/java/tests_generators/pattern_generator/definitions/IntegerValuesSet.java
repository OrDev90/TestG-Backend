package tests_generators.pattern_generator.definitions;

import lombok.Getter;
import tests_generators.utils.RandomUtils;

@Getter
public class IntegerValuesSet {

    protected IllegalCharacter illegal;
    protected String negative;
    protected String below;
    protected String min;
    protected String mid;
    protected String max;
    protected String above;

    private IntegerValuesSet(String illegal, String negative, String below, String min, String mid, String max, String above) {
        this.illegal = new IllegalCharacter(illegal);
        this.negative = negative;
        this.below = below;
        this.min = min;
        this.mid = mid;
        this.max = max;
        this.above = above;
    }

    public static IntegerValuesSet getValuesSet(Integer from, Integer to) {
        return new IntegerValuesSet(setIllegal(), setNegative(from, to), setBelow(from),
                setMin(from), setMed(from, to), setMax(to), setAbove(to));
    }

    private static String setIllegal() {
        return RandomUtils.getRandomCharacter();
    }

    private static String setNegative(Integer from, Integer to) {
        return RandomUtils.getRandomNegativeInRange(from, to);
    }

    private static String setBelow(Integer from) {
        int value = from - 1;
        return String.valueOf(value);
    }

    private static String setMin(Integer from) {
        return String.valueOf(from);
    }

    private static String setMed(Integer from, Integer to) {
        int value = (from / 2) + (to / 2);
        return String.valueOf(value);
    }

    private static String setMax(Integer to) {
        return String.valueOf(to);
    }

    private static String setAbove(Integer to) {
        return String.valueOf(to + 1);
    }
}
