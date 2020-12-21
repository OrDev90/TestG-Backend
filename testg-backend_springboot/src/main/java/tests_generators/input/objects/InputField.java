package tests_generators.input.objects;

import lombok.Getter;

import java.util.List;

@Getter
public class InputField {

    private String projectName;
    private int projectId;
    private List<InputParameter> parameters;
    private List<InputCondition> conditions;
}
