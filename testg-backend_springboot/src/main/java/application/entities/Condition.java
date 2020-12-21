package application.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Condition {

    String condition;
    String firstParameter;
    String firstValue;
    String firstSign;
    String secondParameter;
    String secondValue;
    String secondSign;

    public Condition(String condition,
                     String firstParameter,
                     String firstValue,
                     String firstSign,
                     String secondParameter,
                     String secondValue,
                     String secondSign) {
        this.condition = condition;
        this.firstParameter = firstParameter;
        this.firstValue = firstValue;
        this.firstSign = firstSign;
        this.secondParameter = secondParameter;
        this.secondValue = secondValue;
        this.secondSign = secondSign;
    }
}
