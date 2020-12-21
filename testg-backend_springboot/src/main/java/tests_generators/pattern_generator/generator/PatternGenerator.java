package tests_generators.pattern_generator.generator;

import application.entities.InputField;
import application.entities.Parameter;
import tests_generators.pattern_generator.definitions.*;

import java.util.List;
import java.util.stream.Collectors;

public class PatternGenerator {

    private IntegerManager integerManager = null;
    private StringManager stringManager = null;
    private BooleanManager booleanManager = null;

    public PatternGenerator() { }

    public PatternGenerator setInputField(InputField inputField) {
        for(Parameter parameter : inputField.getParameters()) {
            switch (parameter.getType()) {
                case "Integer": {
                    if(parameter.getFrom().isPresent() && parameter.getTo().isPresent()) {
                        this.getIntegerPattern(inputField.getProjectName(),
                                parameter.getName(),
                                Integer.valueOf(parameter.getFrom().get()),
                                Integer.valueOf(parameter.getTo().get()),
                                this.filterParameter(parameter.getName(), inputField.getParameters()));
                    }
                }
                case "String": {

                }
                case "Boolean": {

                }
            }
        }
        return this;
    }

    private List<Parameter> filterParameter(String parameterNameToRemove, List<Parameter> parametersList) {
        return parametersList.stream()
                .filter(parameter -> !parameter.getName().contentEquals(parameterNameToRemove))
                .collect(Collectors.toList());
    }

    private void getIntegerPattern(String projectName, String name, Integer from, Integer to, List<Parameter> parametersList) {
        this.integerManager = new IntegerManager(projectName, name, IntegerValuesSet.getValuesSet(from, to), parametersList);
    }

    private void getStringPattern(String name, String string) {
        this.stringManager = new StringManager(name, StringValuesSet.getValuesSet(string));
    }

    private void getBooleanPattern(String name, Boolean bool) {
        this.booleanManager = new BooleanManager(name, BooleanValuesSet.getValuesSet(bool));
    }

    public PatternGenerator initTests() {
        if(this.integerManager != null) {
            this.integerManager.generateTests();
        } else if(this.stringManager != null) {
            this.stringManager.generateTests();
        } else if(this.booleanManager != null) {
            this.booleanManager.generateTests();
        }
        return this;
    }
}
