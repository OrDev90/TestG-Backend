package tests_generators.condition_generator.definitions;

import lombok.Getter;

@Getter
public enum Arithmetics {

    EQUAL("Equal"),
    NOT_EQUAL("Not_Equal"),
    GREATER_THAN("Greater_Than"),
    LESS_THAN("Less_Than");

    private final String arithmetic;

    Arithmetics(String arithmetic) {
        this.arithmetic = arithmetic;
    }

    public static String oppositeArithmetic(String arithmetic) {
       switch (arithmetic) {
           case "Equal" -> {
               return NOT_EQUAL.getArithmetic();
           }
           case "Not_Equal" -> {
               return EQUAL.getArithmetic();
           }
           case "Greater_Than" -> {
               return LESS_THAN.getArithmetic();
           }
           case "Less_Than" -> {
               return GREATER_THAN.getArithmetic();
           }
           default -> {
               return "";
           }
       }
    }
}
