package tests_generators.condition_generator.definitions;

import lombok.Getter;
import tests_generators.combination_generator.definitions.Combination;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TestConditionResult {

    private String testName;
    private String testID;
    private String testType;

    private List<Combination> combinationList;

    public TestConditionResult(String testName, String testID, String testType) {
        this.testName = testName;
        this.testID = testID;
        this.testType = testType;
        this.combinationList = new ArrayList<>();
    }
}
