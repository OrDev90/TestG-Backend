package application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
public class InputField {

    private int id;
    String projectName;
    int projectId;
    List<Parameter> parameters;
    List<Condition> conditions;

    public InputField(@JsonProperty("projectName") String projectName,
                      @JsonProperty("projectId") int projectId,
                      @JsonProperty("parameters") List<Parameter> parameters,
                      @JsonProperty("conditions") List<Condition> conditions) {
        ObjectId objectId = new ObjectId();
        this.id = objectId.hashCode() > 0 ? objectId.hashCode() : objectId.hashCode() * (-1);
        this.projectName = projectName;
        this.projectId = projectId;
        this.parameters = parameters;
        this.conditions = conditions;
    }
}
