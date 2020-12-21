package tests_generators.utils.enums;

import lombok.Getter;

@Getter
public enum VarTypesEnum {

    INTEGER("Integer"),
    STRING("String"),
    BOOLEAN("Boolean");

    private final String varType;

    VarTypesEnum(String varType) {
        this.varType = varType;
    }
}
