package tests_generators.combination_generator.generator;

import application.entities.Parameter;
import lombok.Getter;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.cornutum.tcases.*;
import org.cornutum.tcases.conditions.ICondition;
import tests_generators.combination_generator.definitions.*;
import tests_generators.input.objects.VarSet;
import tests_generators.input.objects.*;
import tests_generators.output.objects.TestResult;
import tests_generators.utils.RandomUtils;
import tests_generators.utils.UnifiedReportGenerator;
import tests_generators.utils.enums.CharactersUtils;
import tests_generators.utils.enums.ConditionsEnum;
import tests_generators.utils.enums.ValueUtilsEnum;

import java.util.*;

@Getter
public class CombinationGenerator {

    private SystemDefinition systemDefinition;
    private GeneratorDefinition generatorDefinition;
    private final List<FunctionDefinition> functionDefinitionList;
    private final List<VariableSetDefinition> variableSetDefinitionList;
    private final List<VariableDefinition> variableDefinitionList;
    private final List<ValueDefinition> valueDefinitionsList;
    private SystemTestDef tcasesResults;

    private final List<TestResult> testResults;

    public CombinationGenerator() {
        this.functionDefinitionList = new ArrayList<>();
        this.variableSetDefinitionList = new ArrayList<>();
        this.variableDefinitionList = new ArrayList<>();
        this.valueDefinitionsList = new ArrayList<>();
        this.testResults = new ArrayList<>();
    }

    public CombinationGenerator setupGenerator(String functionName) {
        this.generatorDefinition = new GeneratorDefinition(functionName);
        return this;
    }

    public CombinationGenerator setupGenerator(int defaultTupleSize, String functionName) {
        this.generatorDefinition = new GeneratorDefinition(defaultTupleSize, functionName);
        return this;
    }

    public CombinationGenerator generateSystem() {
        this.systemDefinition = new SystemDefinition();
        return this;
    }

    public CombinationGenerator generateSystem(String name) {
        this.systemDefinition = new SystemDefinition(name);
        return this;
    }

    public CombinationGenerator generateFunction() {
        this.functionDefinitionList.add(new FunctionDefinition());
        return this;
    }

    public CombinationGenerator generateFunction(String name) {
        this.functionDefinitionList.add(new FunctionDefinition(name));
        return this;
    }

    public CombinationGenerator generateFunction(String[] names) {
        for (String name : names) {
            this.functionDefinitionList.add(new FunctionDefinition(name));
        }
        return this;
    }

    public CombinationGenerator generateVarSet() {
        this.variableSetDefinitionList.add(new VariableSetDefinition());
        return this;
    }

    public CombinationGenerator generateVarSet(String name) {
        this.variableSetDefinitionList.add(new VariableSetDefinition(name));
        return this;
    }

    public CombinationGenerator generateVarSet(String[] names) {
        for (String name : names) {
            this.variableSetDefinitionList.add(new VariableSetDefinition(name));;
        }
        return this;
    }

    public CombinationGenerator generateVarSet(String name, String type) {
        this.variableSetDefinitionList.add(new VariableSetDefinition(name, type));
        return this;
    }

    public CombinationGenerator generateVarSet(VarSet varSet) {
        this.variableSetDefinitionList.add(new VariableSetDefinition(varSet.getName(), varSet.getType()));
        return this;
    }

    public CombinationGenerator generateVarSet(VarSet[] varSets) {
        for (VarSet varSet : varSets) {
            this.variableSetDefinitionList.add(new VariableSetDefinition(varSet.getName(), varSet.getType()));
        }
        return this;
    }

    public CombinationGenerator generateVarDef() {
        this.variableDefinitionList.add(new VariableDefinition());
        return this;
    }

    public CombinationGenerator generateVarDef(String name) {
        this.variableDefinitionList.add(new VariableDefinition(name));
        return this;
    }

    public CombinationGenerator generateVarDef(String[] names) {
        for (String name : names) {
            this.variableDefinitionList.add(new VariableDefinition(name));;
        }
        return this;
    }

    public CombinationGenerator generateVarDef(String name, String type) {
        this.variableDefinitionList.add(new VariableDefinition(name, type));
        return this;
    }

    public CombinationGenerator generateVarDef(Var var) {
        this.variableDefinitionList.add(new VariableDefinition(var.getName(), var.getType()));
        return this;
    }

    public CombinationGenerator generateVarDef(Var[] vars) {
        for (Var var : vars) {
            this.variableDefinitionList.add(new VariableDefinition(var.getName(), var.getType()));
        }
        return this;
    }

    public CombinationGenerator generateVarValue() {
        this.valueDefinitionsList.add(new ValueDefinition());
        return this;
    }

    public CombinationGenerator generateVarValue(String name) {
        this.valueDefinitionsList.add(new ValueDefinition(name));
        return this;
    }

    public CombinationGenerator generateVarValue(String[] names) {
        for (String name : names) {
            this.valueDefinitionsList.add(new ValueDefinition(name));;
        }
        return this;
    }

    public CombinationGenerator generateVarValue(String name, ValueUtilsEnum.Type type) {
        this.valueDefinitionsList.add(new ValueDefinition(name, type));
        return this;
    }

    public CombinationGenerator generateVarValue(String name, ValueUtilsEnum.Type type, Collection<String> properties) {
        this.valueDefinitionsList.add(new ValueDefinition(name, type, properties));
        return this;
    }

    @SafeVarargs
    public final CombinationGenerator generateVarValue(String name, ValueUtilsEnum.Type type, Collection<String> properties, List<ImmutablePair<ConditionsEnum,
            List<ImmutablePair<ConditionsEnum, List<String>>>>>... conditions) {
        if (properties == null && conditions == null) {
            this.valueDefinitionsList.add(new ValueDefinition(name, type));
        } else if (properties != null && conditions == null) {
            this.valueDefinitionsList.add(new ValueDefinition(name, type, properties));
        } else {
            this.valueDefinitionsList.add(new ValueDefinition(name, type, properties, conditions[0]));
        }
        return this;
    }

    public CombinationGenerator generateVarValue(Value value) {
        if (value.getProperties() == null && value.getConditions() == null) {
            this.valueDefinitionsList.add(new ValueDefinition(value.getName(), value.getType()));
        } else if (value.getProperties() != null && value.getConditions() == null) {
            this.valueDefinitionsList.add(new ValueDefinition(value.getName(), value.getType(), value.getProperties()));
        } else {
            this.valueDefinitionsList.add(new ValueDefinition(value.getName(), value.getType(), value.getProperties(), value.getConditions()[0]));
        }
        return this;
    }

    public CombinationGenerator generateVarValue(Value[] values) {
        for (Value value : values) {
            if (value.getProperties() == null && value.getConditions() == null) {
                this.valueDefinitionsList.add(new ValueDefinition(value.getName(), value.getType()));
            } else if (value.getProperties() != null && value.getConditions() == null) {
                this.valueDefinitionsList.add(new ValueDefinition(value.getName(), value.getType(), value.getProperties()));
            } else {
                this.valueDefinitionsList.add(new ValueDefinition(value.getName(), value.getType(), value.getProperties(), value.getConditions()[0]));
            }
        }
        return this;
    }

    public CombinationGenerator attachFunctionsToSystem() {
        for (FunctionDefinition functionDefinition : functionDefinitionList) {
            this.systemDefinition.addFunctionInputDefinition(functionDefinition);
            break;
        }
        return this;
    }

    public CombinationGenerator attachVarSetToFunction(String varSetName, String functionName) {
        for (FunctionDefinition functionDefinition : this.functionDefinitionList) {
            if (functionDefinition.getName().contentEquals(functionName)) {
                for (VariableSetDefinition variableSetDefinition : this.variableSetDefinitionList) {
                    if (variableSetDefinition.getName().contentEquals(varSetName)) {
                        functionDefinition.addVarSetDefinition(variableSetDefinition);
                        break;
                    }
                }
                break;
            }
        }
        return this;
    }

    public CombinationGenerator attachVarDefToFunction(String varDefName, String functionName) {
        for (FunctionDefinition functionDefinition : this.functionDefinitionList) {
            if (functionDefinition.getName().contentEquals(functionName)) {
                for (VariableDefinition variableDefinition : this.variableDefinitionList) {
                    if (variableDefinition.getName().contentEquals(varDefName)) {
                        functionDefinition.addVarDefinition(variableDefinition);
                        break;
                    }
                }
                break;
            }
        }
        return this;
    }

    public CombinationGenerator attachVarDefToVarSet(String varDefName, String varSetName) {
        for (VariableSetDefinition variableSetDefinition : this.variableSetDefinitionList) {
            if (variableSetDefinition.getName().contentEquals(varSetName)) {
                for (VariableDefinition variableDefinition : this.variableDefinitionList) {
                    if (variableDefinition.getName().contentEquals(varDefName)) {
                        variableSetDefinition.addMember(variableDefinition);
                        break;
                    }
                }
                break;
            }
        }
        return this;
    }

    public CombinationGenerator attachVarValueToVarDef(String varValueName, String varDefName) {
        for (VariableDefinition variableDefinition : this.variableDefinitionList) {
            if (variableDefinition.getName().contentEquals(varDefName)) {
                for (ValueDefinition valueDefinition : this.valueDefinitionsList) {
                    if (valueDefinition.getName().contentEquals(varValueName)) {
                        variableDefinition.addValue(valueDefinition);
                        break;
                    }
                }
                break;
            }
        }
        return this;
    }

    public CombinationGenerator addTypeToVarValue(String varValueName, VarValueDef.Type type) {
        for(ValueDefinition valueDefinition : this.valueDefinitionsList) {
            if (valueDefinition.getName().contentEquals(varValueName)) {
                valueDefinition.setType(type);
                break;
            }
        }
        return this;
    }

    public CombinationGenerator addPropertyToVarValue(String varValueName, String property) {
        for(ValueDefinition valueDefinition : this.valueDefinitionsList) {
            if (valueDefinition.getName().contentEquals(varValueName)) {
                valueDefinition.setProperties(Collections.singleton(property));
                break;
            }
        }
        return this;
    }

    public void generateTests() {
        this.tcasesResults = this.getTestResults(this.systemDefinition, this.generatorDefinition);
        this.setTestCases();
    }

    public void generateTests(String testType) {
        this.tcasesResults = this.getTestResults(this.systemDefinition, this.generatorDefinition);
        this.setTestCases(testType);
    }

    public void generateTests(String parameterName, String min, String max) {
        this.tcasesResults = this.getTestResults(this.systemDefinition, this.generatorDefinition);
        this.setTestCases(parameterName, min, max);
    }

    public CombinationGenerator initTests() {
        this.generateTests();
        return this;
    }

    public void setTestCases() {
        for (Iterator<FunctionTestDef> functionTestDefIterator = this.tcasesResults.getFunctionTestDefs(); functionTestDefIterator.hasNext(); ) {
            FunctionTestDef functionTestDef = functionTestDefIterator.next();
            for (Iterator<TestCase> testCaseIterator = functionTestDef.getTestCases(); testCaseIterator.hasNext(); ) {
                TestCase testCase = testCaseIterator.next();
                this.testResults.add(new TestResult(RandomUtils.getRandomTestName(),
                        testCase.getType().toString()));
                for (Iterator<VarBinding> varBindingIterator = testCase.getVarBindings(); varBindingIterator.hasNext();) {
                    VarBinding varBinding = varBindingIterator.next();
                    Combination combination = new Combination(varBinding.getVar(),
                            varBinding.getType(), CharactersUtils.stringToCharacter(varBinding.getValue().toString()));
                    this.testResults.get(this.testResults.size() - 1)
                            .getCombinationList().add(combination);
                }
            }
        }
        this.attachToReport();
    }

    public void setTestCases(String testType) {
        for (Iterator<FunctionTestDef> functionTestDefIterator = this.tcasesResults.getFunctionTestDefs(); functionTestDefIterator.hasNext(); ) {
            FunctionTestDef functionTestDef = functionTestDefIterator.next();
            for (Iterator<TestCase> testCaseIterator = functionTestDef.getTestCases(); testCaseIterator.hasNext(); ) {
                TestCase testCase = testCaseIterator.next();
                this.testResults.add(new TestResult(RandomUtils.getRandomTestName(),
                        testType));
                for (Iterator<VarBinding> varBindingIterator = testCase.getVarBindings(); varBindingIterator.hasNext();) {
                    VarBinding varBinding = varBindingIterator.next();
                    Combination combination = new Combination(varBinding.getVar(),
                            varBinding.getType(), CharactersUtils.stringToCharacter(varBinding.getValue().toString()));
                    this.testResults.get(this.testResults.size() - 1)
                            .getCombinationList().add(combination);
                }
            }
        }
        this.attachToReport();
    }

    public void setTestCases(String parameterName, String min, String max) {
        for (Iterator<FunctionTestDef> functionTestDefIterator = this.tcasesResults.getFunctionTestDefs(); functionTestDefIterator.hasNext(); ) {
            FunctionTestDef functionTestDef = functionTestDefIterator.next();
            for (Iterator<TestCase> testCaseIterator = functionTestDef.getTestCases(); testCaseIterator.hasNext(); ) {
                TestCase testCase = testCaseIterator.next();
                this.testResults.add(new TestResult(RandomUtils.getRandomTestName(),
                        testCase.getType().toString()));
                for (Iterator<VarBinding> varBindingIterator = testCase.getVarBindings(); varBindingIterator.hasNext();) {
                    VarBinding varBinding = varBindingIterator.next();
                    Combination combination = new Combination(varBinding.getVar(),
                            varBinding.getType(), CharactersUtils.stringToCharacter(varBinding.getValue().toString()));
                    this.testResults.get(this.testResults.size() - 1)
                            .getCombinationList().add(combination);
                    if(parameterName.contentEquals(combination.getParameterName())) {
                        if(RandomUtils.isNotCharacter(combination.getParameterValue())) {
                            if(!(Integer.parseInt(combination.getParameterValue()) >= Integer.parseInt(min))) {
                                this.testResults.get(this.testResults.size() - 1).setTestType("FAILURE");
                            }
                            if(!(Integer.parseInt(combination.getParameterValue()) <= Integer.parseInt(max))) {
                                this.testResults.get(this.testResults.size() - 1).setTestType("FAILURE");
                            }
                        } else {
                            this.testResults.get(this.testResults.size() - 1).setTestType("FAILURE");
                        }
                    }
                }
            }
        }
        this.attachToReport();
    }

    private SystemTestDef getTestResults(SystemDefinition systemDefinition, GeneratorDefinition generatorDefinition) {
        return Tcases.getTests(systemDefinition.getSystemInputDef(), generatorDefinition.getGeneratorSet(), null);
    }

    public void printValuesProperties() {
        for (ValueDefinition varValueDef : this.valueDefinitionsList) {
            for (String property : varValueDef.getProperties()) {
                System.out.println("Value: " + varValueDef.getName() + " ------ Property: " + property);
            }
        }
    }

    public void printValuesConditions() {
        for (ValueDefinition varValueDef : this.valueDefinitionsList) {
            if(varValueDef.hasConditions()) {
                for (Iterator<ICondition> conditionIterator = varValueDef.getConditions(); conditionIterator.hasNext();) {
                    ICondition condition = conditionIterator.next();
                    System.out.println(condition.toString());
                }
            }
        }
    }

    public CombinationGenerator attachToReport() {
        UnifiedReportGenerator.getInstance().getResults(this.testResults);
        return this;
    }

    public CombinationGenerator setInputField(application.entities.InputField inputField) {
        this.generateSystem(inputField.getProjectName())
                .generateFunction(inputField.getProjectName());
        for(Parameter parameter : inputField.getParameters()) {
            this.generateVarDef(parameter.getName(), parameter.getType());
            for(String value : parameter.getValues()) {
                this.generateVarValue(value)
                        .addPropertyToVarValue(value, value);
                this.attachVarValueToVarDef(value, parameter.getName());
            }
            this.attachVarDefToFunction(parameter.getName(),
                    inputField.getProjectName());
        }
        this.attachFunctionsToSystem().setupGenerator(0,
                inputField.getProjectName());
        return this;
    }
}