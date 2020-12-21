package application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InputFieldUpdatePayload {

    String projectName;
    int projectId;
    List<Parameter> parameters;
    List<Condition> conditions;

    public InputFieldUpdatePayload(@JsonProperty("projectName") String projectName,
                                   @JsonProperty("projectId") int projectId,
                                   @JsonProperty("parameters") List<Parameter> parameters,
                                   @JsonProperty("conditions") List<Condition> conditions) {
        this.projectName = projectName;
        this.projectId = projectId;
        this.parameters = parameters;
        this.conditions = conditions;
    }
}
