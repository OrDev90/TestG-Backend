package tests_generators.utils;

import lombok.Getter;
import tests_generators.combination_generator.definitions.Combination;
import tests_generators.condition_generator.definitions.TestType;
import tests_generators.output.objects.OutputField;
import tests_generators.output.objects.Test;
import tests_generators.output.objects.TestResult;

import java.util.ArrayList;
import java.util.List;

public class UnifiedReportGenerator {

    private static UnifiedReportGenerator unifiedReportGenerator = null;

    private static OutputField outputField = null;

    @Getter
    private int commonProjectId;
    private String commonProjectName;

    private UnifiedReportGenerator() {
        outputField = new OutputField();
    }

    public static UnifiedReportGenerator getInstance() {
        if(unifiedReportGenerator == null) {
            unifiedReportGenerator = new UnifiedReportGenerator();
        }
        return unifiedReportGenerator;
    }

    public static void resetUnifiedReportGenerator() {
        unifiedReportGenerator = null;
    }

    public OutputField getOutputField() {
        return this.removeDuplicates(outputField);
    }

    private OutputField removeDuplicates(OutputField outputField) {
        List<Test> tests = new ArrayList<>();
        for(int i = 0 ; i < outputField.getTests().size() ; i++) {
            Test testI = outputField.getTests().get(i);
            for(int j = 0 ; j < outputField.getTests().size() ; j++) {
                Test testJ = outputField.getTests().get(j);
                if(i != j) {
                    if(testI.equals(testJ)) {
                        if(testI.getType().contentEquals(TestType.SUCCESS.getTestType()) &&
                                testJ.getType().contentEquals(TestType.SUCCESS.getTestType())) {
                            if(!tests.contains(testJ)) {
                                tests.add(testJ);
                            }
                        } else if(testI.getType().contentEquals(TestType.FAILURE.getTestType()) &&
                                testJ.getType().contentEquals(TestType.SUCCESS.getTestType())) {
                            if(!tests.contains(testI)) {
                                tests.add(testI);
                            }
                        } else if(testI.getType().contentEquals(TestType.FAILURE.getTestType()) &&
                                testJ.getType().contentEquals(TestType.FAILURE.getTestType())) {
                            if(!tests.contains(testI)) {
                                tests.add(testI);
                            }
                        } else {
                            if(!tests.contains(testJ)) {
                                tests.add(testJ);
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0 ; i < outputField.getTests().size() ; i++) {
            Test testI = outputField.getTests().get(i);
            if(!tests.contains(testI)) {
                tests.add(testI);
            }
        }
        outputField.setTests(tests);
        return outputField;
    }

    public void setProjectID(int projectId) {
        this.commonProjectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.commonProjectName = projectName;
    }

    public void getResults(List<TestResult> testResults) {
        for(TestResult testResult : testResults) {
            outputField.getTests().add(new Test(testResult.getTestName(),
                    testResult.getTestType(), this.commonProjectId,
                    this.commonProjectName,
                    testResult.getCombinationList()));
        }
    }

//    public void getConditions(List<TestConditionResult> successTestsResults,
//                                     List<TestConditionResult> failureTestsResults) {
//        for(TestConditionResult testConditionResult : successTestsResults) {
//            List<ParameterData> parameterData = new ArrayList<>();
//            parameterData.add(new ParameterData(testConditionResult.getFirstParameterName(),
//                    testConditionResult.getFirstParameterType(),
//                    testConditionResult.getFirstParameterValue()));
//            parameterData.add(new ParameterData(testConditionResult.getSecondParameterName(),
//                    testConditionResult.getSecondParameterType(),
//                    testConditionResult.getSecondParameterValue()));
//            outputObject.getTests().add(new Output_Field(testConditionResult.getTestName(),
//                    testConditionResult.getTestType(),
//                    testConditionResult.getTestID(),
//                    this.commonProjectId,
//                    parameterData));
//        }
//        for(TestConditionResult testConditionResult : failureTestsResults) {
//            List<ParameterData> parameterData = new ArrayList<>();
//            parameterData.add(new ParameterData(testConditionResult.getFirstParameterName(),
//                    testConditionResult.getFirstParameterType(),
//                    testConditionResult.getFirstParameterValue()));
//            parameterData.add(new ParameterData(testConditionResult.getSecondParameterName(),
//                    testConditionResult.getSecondParameterType(),
//                    testConditionResult.getSecondParameterValue()));
//            outputObject.getTests().add(new Output_Field(testConditionResult.getTestName(),
//                    testConditionResult.getTestType(),
//                    testConditionResult.getTestID(),
//                    this.commonProjectId,
//                    parameterData));
//        }
//    }

    public void printAll() {
        for(Test output_field : outputField.getTests()) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Test Name: " + output_field.getName() + "\n");
            System.out.println("Test Type: " + output_field.getType() + "\n");
            System.out.println("Project ID: " + output_field.getProjectId() + "\n");
            for(Combination combination : output_field.getCombinations()) {
                System.out.println("Parameter Name: " + combination.getParameterName() + "\n");
                System.out.println("Parameter Type: " + combination.getParameterType() + "\n");
                System.out.println("Parameter Value: " + combination.getParameterValue() + "\n");
            }
            System.out.println("---------------------------------------------------------------");
        }
    }
}
