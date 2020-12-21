package tests_generators.condition_generator.definitions;

import lombok.Getter;

@Getter
public enum TestType {

    SUCCESS("SUCCESS"),
    FAILURE("FAILURE");

    private final String testType;

    TestType(String testType) {
        this.testType = testType;
    }
}
