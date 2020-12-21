package tests_generators.condition_generator.generator;

import application.entities.Condition;
import application.entities.InputField;
import application.entities.Parameter;
import org.apache.commons.lang3.tuple.ImmutablePair;
import tests_generators.combination_generator.generator.CombinationGenerator;
import tests_generators.condition_generator.definitions.Arithmetics;
import tests_generators.condition_generator.definitions.Statements;
import tests_generators.condition_generator.definitions.TestType;
import tests_generators.utils.RandomUtils;
import tests_generators.utils.enums.VarTypesEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class ConditionGenerator {

    private InputField input_field;

    public ConditionGenerator() { }

    public ConditionGenerator setInputField(InputField input_field) {
        this.input_field = input_field;
        return this;
    }

    private List<Parameter> filterParameters(String firstParameter, String secondParameter, List<Parameter> parametersList) {
        return parametersList.stream()
                .filter(parameter -> !parameter.getName().contentEquals(firstParameter))
                .collect(Collectors.toList())
                .stream()
                .filter(parameter -> !parameter.getName().contentEquals(secondParameter))
                .collect(Collectors.toList());
    }

    private void generate(CombinationGenerator combinationGenerator, List<Parameter> inputParameters, String testType) {
        combinationGenerator.generateSystem(this.input_field.getProjectName())
                .generateFunction(this.input_field.getProjectName());
        for(Parameter parameter : inputParameters) {
            combinationGenerator.generateVarDef(parameter.getName(), parameter.getType());
            for(String value : parameter.getValues()) {
                combinationGenerator.generateVarValue(value)
                        .addPropertyToVarValue(value, value);
                combinationGenerator.attachVarValueToVarDef(value, parameter.getName());
            }
            combinationGenerator.attachVarDefToFunction(parameter.getName(),
                    this.input_field.getProjectName());
        }
        combinationGenerator.attachFunctionsToSystem().setupGenerator(0,
                this.input_field.getProjectName()).generateTests(testType);
    }

    private void setSuccessTests(InputField input_field) {
        List<Parameter> parameters;
        for(Condition condition : input_field.getConditions()) {
            parameters = this.filterParameters(condition.getFirstParameter(),
                    condition.getSecondParameter(), input_field.getParameters());
            parameters.add(new Parameter(condition.getFirstParameter(),
                    this.getParameterType(condition.getFirstParameter()), null,
                    Collections.singletonList(this.getSuccessValue(condition.getFirstParameter(), condition.getFirstValue(), condition.getFirstSign(),
                            condition.getCondition(), "first")), null, null, null));
            parameters.add(new Parameter(condition.getSecondParameter(),
                    this.getParameterType(condition.getSecondParameter()), null,
                    Collections.singletonList(this.getSuccessValue(condition.getSecondParameter(), condition.getSecondValue(), condition.getSecondSign(),
                            condition.getCondition(), "second")), null, null, null));

            this.generate(new CombinationGenerator(), parameters, TestType.SUCCESS.getTestType());
        }
    }

    private void setFailureTests(InputField input_field) {
        for(Condition condition : input_field.getConditions()) {
            List<Parameter> parameters = this.filterParameters(condition.getFirstParameter(),
                    condition.getSecondParameter(), input_field.getParameters());
            parameters.add(new Parameter(condition.getFirstParameter(),
                    this.getParameterType(condition.getFirstParameter()), null,
                    Collections.singletonList(this.getFailureValue(condition.getFirstParameter(), condition.getFirstValue(), condition.getFirstSign(),
                            condition.getCondition(), "first")), null, null, null));
            parameters.add(new Parameter(condition.getSecondParameter(),
                    this.getParameterType(condition.getSecondParameter()), null,
                    Collections.singletonList(this.getFailureValue(condition.getSecondParameter(), condition.getSecondValue(), condition.getSecondSign(),
                            condition.getCondition(), "second")), null, null, null));
            this.generate(new CombinationGenerator(), parameters, TestType.FAILURE.getTestType());
        }

        for(Condition condition : input_field.getConditions()) {
            List<Parameter> parameters = this.filterParameters(condition.getFirstParameter(),
                    condition.getSecondParameter(), input_field.getParameters());
            parameters.add(new Parameter(condition.getFirstParameter(),
                    this.getParameterType(condition.getFirstParameter()),null,
                    Collections.singletonList(this.getSuccessValue(condition.getFirstParameter(), condition.getFirstValue(), condition.getFirstSign(),
                            condition.getCondition(), "first")), null, null, null));
            parameters.add(new Parameter(condition.getSecondParameter(),
                    this.getParameterType(condition.getSecondParameter()),null,
                    Collections.singletonList(this.getFailureValue(condition.getSecondParameter(), condition.getSecondValue(), condition.getSecondSign(),
                            condition.getCondition(), "second")), null, null, null));
            this.generate(new CombinationGenerator(), parameters, TestType.FAILURE.getTestType());
        }

        for(Condition condition : input_field.getConditions()) {
            List<Parameter> parameters = this.filterParameters(condition.getFirstParameter(),
                    condition.getSecondParameter(), input_field.getParameters());
            parameters.add(new Parameter(condition.getFirstParameter(),
                    this.getParameterType(condition.getFirstParameter()),null,
                    Collections.singletonList(this.getFailureValue(condition.getFirstParameter(), condition.getFirstValue(), condition.getFirstSign(),
                            condition.getCondition(), "first")), null, null, null));
            parameters.add(new Parameter(condition.getSecondParameter(),
                    this.getParameterType(condition.getSecondParameter()), null,
                    Collections.singletonList(this.getSuccessValue(condition.getSecondParameter(), condition.getSecondValue(), condition.getSecondSign(),
                            condition.getCondition(), "second")), null, null, null));
            this.generate(new CombinationGenerator(), parameters, TestType.FAILURE.getTestType());
        }
    }

    private String getSuccessValue(String name, String value, String sign, String condition, String position) {
        if(position.contentEquals("first")) {
            return this.getValue(name, value, sign);
        } else {
            if(condition.contentEquals(Statements.WHEN.getStatement())) {
                return this.getValue(name, value, sign);
            } else {
                return this.getOppositeValue(name, value, sign);
            }
        }
    }

    private String getFailureValue(String name, String value, String sign, String condition, String position) {
        if(position.contentEquals("first")) {
            return this.getOppositeValue(name, value, sign);
        } else {
            if(condition.contentEquals(Statements.WHEN.getStatement())) {
                return this.getOppositeValue(name, value, sign);
            } else {
                return this.getValue(name, value, sign);
            }
        }
    }

    private String getOppositeValue(String name, String value, String sign) {
        if(Objects.requireNonNull(this.getParameterType(name)).contentEquals(VarTypesEnum.INTEGER.getVarType())) {
            if(sign.contentEquals(Arithmetics.EQUAL.getArithmetic())) {
                return this.getRandomValueDifferentFromCurrentValue(name, value,
                        Objects.requireNonNull(this.getParameterType(name)));
            } else if(sign.contentEquals(Arithmetics.NOT_EQUAL.getArithmetic())) {
                return value;
            } else if(sign.contentEquals(Arithmetics.GREATER_THAN.getArithmetic())) {
                return this.getValueLessThanCurrentValue(name, value);
            } else {
                return this.getValueGreaterThanCurrentValue(name, value);
            }
        } else if(Objects.requireNonNull(this.getParameterType(name)).contentEquals(VarTypesEnum.STRING.getVarType())) {
            if(sign.contentEquals(Arithmetics.EQUAL.getArithmetic())) {
                return this.getRandomValueDifferentFromCurrentValue(name, value,
                        Objects.requireNonNull(this.getParameterType(name)));
            } else {
                return value;
            }
        } else {
            if(sign.contentEquals(Arithmetics.EQUAL.getArithmetic())) {
                return this.getOppositeBoolean(value);
            } else {
                return value;
            }
        }
    }

    private String getOppositeBoolean(String value) {
        if(value.contentEquals("False")) {
            return "True";
        }
        return "False";
    }

    private String getValue(String name, String value, String sign) {
        if(Objects.requireNonNull(this.getParameterType(name)).contentEquals(VarTypesEnum.INTEGER.getVarType())) {
            if(sign.contentEquals(Arithmetics.EQUAL.getArithmetic())) {
                return value;
            } else if(sign.contentEquals(Arithmetics.NOT_EQUAL.getArithmetic())) {
                return this.getRandomValueDifferentFromCurrentValue(name, value,
                        Objects.requireNonNull(this.getParameterType(name)));
            } else if(sign.contentEquals(Arithmetics.GREATER_THAN.getArithmetic())) {
                return this.getValueGreaterThanCurrentValue(name, value);
            } else {
                return this.getValueLessThanCurrentValue(name, value);
            }
        } else if(Objects.requireNonNull(this.getParameterType(name)).contentEquals(VarTypesEnum.STRING.getVarType())) {
            if(sign.contentEquals(Arithmetics.EQUAL.getArithmetic())) {
                return value;
            } else {
                return this.getRandomValueDifferentFromCurrentValue(name, value,
                        Objects.requireNonNull(this.getParameterType(name)));
            }
        } else {
            if(sign.contentEquals(Arithmetics.EQUAL.getArithmetic())) {
                return value;
            } else {
                return this.getOppositeBoolean(value);
            }
        }
    }

    private String getValueGreaterThanCurrentValue(String name, String value) {
        String currentValue = value;
        while(currentValue.contentEquals(value) || Integer.parseInt(currentValue) < Integer.parseInt(value)) {
            currentValue = RandomUtils.getRandomValue(this.getParameterFullRange
                    (Objects.requireNonNull(this.getParameterRange(name))));
        }
        return currentValue;
    }

    private String getValueLessThanCurrentValue(String name, String value) {
        String currentValue = value;
        while(currentValue.contentEquals(value) || Integer.parseInt(currentValue) > Integer.parseInt(value)) {
            currentValue = RandomUtils.getRandomValue(this.getParameterFullRange
                    (Objects.requireNonNull(this.getParameterRange(name))));
        }
        return currentValue;
    }

    private String getRandomValueDifferentFromCurrentValue(String name, String value, String type) {
        String currentValue = value;
        if(type.contentEquals(VarTypesEnum.INTEGER.getVarType())) {
            while(currentValue.contentEquals(value)) {
                currentValue = RandomUtils.getRandomValue(this.getParameterFullRange
                        (Objects.requireNonNull(this.getParameterRange(name))));
            }
        } else {
            while(currentValue.contentEquals(value)) {
                if(Objects.requireNonNull(this.getParameterValues(name)).size() == 1) {
                    currentValue = RandomUtils.getRandomString(value.length());
                } else {
                    currentValue = RandomUtils.getRandomValue(Objects.requireNonNull(this.getParameterValues(name)));
                }
            }
        }
        return currentValue;
    }

    private String getParameterType(String name) {
        for(Parameter parameter : this.input_field.getParameters()) {
            if(parameter.getName().contentEquals(name)) {
                return parameter.getType();
            }
        }
        return null;
    }

    private ImmutablePair<String, String> getParameterRange(String name) {
        for(Parameter parameter : this.input_field.getParameters()) {
            if(parameter.getName().contentEquals(name)) {
                return new ImmutablePair<>(parameter.getFrom().get(), parameter.getTo().get());
            }
        }
        return null;
    }

    private List<String> getParameterFullRange(ImmutablePair<String, String> range) {
        List<String> finalStringList = new ArrayList<>();
        for(int i = Integer.parseInt(range.getLeft()) ; i <= Integer.parseInt(range.getRight()) ; i++) {
            finalStringList.add(String.valueOf(i));
        }
        return finalStringList;
    }

    private List<String> getParameterValues(String name) {
        for(Parameter parameter : this.input_field.getParameters()) {
            if(parameter.getName().contentEquals(name)) {
                return parameter.getValues();
            }
        }
        return null;
    }

    public ConditionGenerator generateTests() {
        this.setSuccessTests(this.input_field);
        this.setFailureTests(this.input_field);
        return this;
    }

    public ConditionGenerator initTests() {
        this.generateTests();
        return this;
    }
}