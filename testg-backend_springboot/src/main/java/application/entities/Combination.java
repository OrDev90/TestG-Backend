package application.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Combination {

    String parameterName;
    String parameterType;
    String parameterValue;

    public Combination(String parameterName, String parameterType, String parameterValue) {
        this.parameterName = parameterName;
        this.parameterType = parameterType;
        this.parameterValue = parameterValue;
    }
}
