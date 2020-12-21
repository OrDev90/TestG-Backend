package tests_generators.output.objects;

import lombok.Getter;
import lombok.Setter;
import tests_generators.combination_generator.definitions.Combination;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TestResult {

    private String testName;
    private String testType;
    private List<Combination> combinationList;

    public TestResult(String testName, String testType) {
        this.testName = testName;
        this.testType = testType;
        this.combinationList = new ArrayList<>();
    }
}
