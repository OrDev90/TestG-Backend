package application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectUpdatePayload {

    private String name;
    private String type;
    private String description;
    private int existingTests;

    public ProjectUpdatePayload(
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("description") String description,
            @JsonProperty("existingTests") int existingTests) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.existingTests = existingTests;
    }
}
