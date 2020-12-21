package tests_generators.combination_generator.definitions;

import org.cornutum.tcases.generator.GeneratorSet;
import org.cornutum.tcases.generator.ITestCaseGenerator;

import java.util.Iterator;

public class GeneratorDefinition {

    final private GeneratorSet generatorSet;

    public GeneratorDefinition(String functionName) {
        this.generatorSet = new GeneratorSet();
        this.generatorSet.setGenerator(functionName,
                new TupleGeneratorDefinition().getTupleGenerator());
    }

    public GeneratorDefinition(int defaultTupleSize, String functionName) {
        this.generatorSet = new GeneratorSet();
        this.generatorSet.setGenerator(functionName,
                new TupleGeneratorDefinition(defaultTupleSize).getTupleGenerator());
    }

    public GeneratorSet getGeneratorSet() {
        return this.generatorSet;
    }

    public void getGenerator(String functionName) {
        this.generatorSet.getGenerator(functionName);
    }

    public void setGenerator(String functionName, ITestCaseGenerator generator) {
        this.generatorSet.setGenerator(functionName, generator);
    }

    public void addGenerator(String functionName, ITestCaseGenerator generator) {
        this.generatorSet.addGenerator(functionName, generator);
    }

    public String[] getGeneratorFunctions() {
        return this.generatorSet.getGeneratorFunctions();
    }

    public Iterator<ITestCaseGenerator> getGenerators() {
        return this.generatorSet.getGenerators();
    }
}
