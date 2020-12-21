package tests_generators.pattern_generator.definitions;

import application.entities.Parameter;
import lombok.Getter;
import tests_generators.combination_generator.generator.CombinationGenerator;
import tests_generators.utils.enums.VarTypesEnum;

import java.util.ArrayList;
import java.util.List;

public class IntegerManager {

    private final IntegerValuesSet integerValuesSet;

    @Getter
    private final List<String> integerValues;

    @Getter
    private final List<Parameter> inputParameterList;

    @Getter
    private final String name;

    @Getter
    private final String projectName;

    private final CombinationGenerator combinationGenerator;

    public IntegerManager(String projectName, String name, IntegerValuesSet integerValuesSet, List<Parameter> parametersList) {
        this.integerValuesSet = integerValuesSet;
        this.integerValues = new ArrayList<>();
        this.inputParameterList = parametersList;
        this.name = name;
        this.projectName = projectName;
        this.combinationGenerator = new CombinationGenerator();
    }

    public void generateTests() {
        this.attachValuesSetToList();
        this.generate();
    }

    private void generate() {
            this.inputParameterList.add(new Parameter(this.name, VarTypesEnum.INTEGER.getVarType(),
                    null, this.integerValues,
                    null, null, null));
        this.combinationGenerator.generateSystem(this.projectName)
                .generateFunction(this.projectName);
        for(Parameter parameter : this.inputParameterList) {
            this.combinationGenerator.generateVarDef(parameter.getName(), parameter.getType());
            for(String value : parameter.getValues()) {
                this.combinationGenerator.generateVarValue(value)
                        .addPropertyToVarValue(value, value);
                this.combinationGenerator.attachVarValueToVarDef(value, parameter.getName());
            }
            this.combinationGenerator.attachVarDefToFunction(parameter.getName(),
                    this.projectName);
        }
        this.combinationGenerator.attachFunctionsToSystem().setupGenerator(0,
                this.projectName).generateTests(this.name, this.integerValuesSet.getMin(), this.integerValuesSet.getMax());
    }

    private void attachValuesSetToList() {
        this.integerValues.add(this.integerValuesSet.getIllegal().alias);
        this.integerValues.add(this.integerValuesSet.getNegative());
        this.integerValues.add(this.integerValuesSet.getBelow());
        this.integerValues.add(this.integerValuesSet.getMin());
        this.integerValues.add(this.integerValuesSet.getMid());
        this.integerValues.add(this.integerValuesSet.getMax());
        this.integerValues.add(this.integerValuesSet.getAbove());
    }
}
