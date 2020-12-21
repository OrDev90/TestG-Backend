package tests_generators.condition_generator.definitions;

import lombok.Getter;

@Getter
public enum Statements {

    WHEN("When"),
    WHEN_NOT("When_Not");

    private final String statement;

    Statements(String statement) {
        this.statement = statement;
    }

}
