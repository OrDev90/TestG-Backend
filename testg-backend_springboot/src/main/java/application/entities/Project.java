package application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
public class Project {

    private int id;
    private String name;
    private String type;
    private String description;
    private int existingTests;

    public Project(@JsonProperty("name") String name,
                   @JsonProperty("type") String type,
                   @JsonProperty("description") String description,
                   @JsonProperty("existingTests") int existingTests) {
        ObjectId objectId = new ObjectId();
        this.id = objectId.hashCode() > 0 ? objectId.hashCode() : objectId.hashCode() * (-1);
        this.name = name;
        this.type = type;
        this.description = description;
        this.existingTests = existingTests;
    }
}
