package tests_generators.combination_generator.definitions;

import org.cornutum.tcases.generator.TupleGenerator;

public class TupleGeneratorDefinition {

    final private TupleGenerator tupleGenerator;

    protected TupleGeneratorDefinition() {
        this.tupleGenerator = new TupleGenerator();
    }

    protected TupleGeneratorDefinition(int defaultTupleSize) {
        this.tupleGenerator = new TupleGenerator(defaultTupleSize);
    }

    protected TupleGenerator getTupleGenerator() {
        return this.tupleGenerator;
    }

    protected long getRandomSeed() {
        return this.tupleGenerator.getRandomSeed();
    }

    protected void setRandomSeed(long seed) {
        this.tupleGenerator.setRandomSeed(seed);
    }

    protected int getDefaultTupleSize() {
        return this.tupleGenerator.getDefaultTupleSize();
    }

    protected void setDefaultTupleSize(int tupleSize) {
        this.tupleGenerator.setDefaultTupleSize(tupleSize);
    }
}
