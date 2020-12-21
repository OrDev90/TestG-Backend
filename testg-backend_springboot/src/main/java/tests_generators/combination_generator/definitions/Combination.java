package tests_generators.combination_generator.definitions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Combination {

    private final String parameterName;
    private final String parameterType;
    private final String parameterValue;

    public Combination(String parameterName, String parameterType, String parameterValue) {
        this.parameterName = parameterName;
        this.parameterType = parameterType;
        this.parameterValue = parameterValue;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Combination that = (Combination) o;
        return parameterName.equals(that.parameterName) &&
                parameterType.equals(that.parameterType) &&
                parameterValue.equals(that.parameterValue);
    }
}
