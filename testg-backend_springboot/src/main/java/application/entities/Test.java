package application.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Test {

    private String name;
    private String type;
    private int projectId;
    private String projectName;
    private List<Combination> combinations;

    public Test(String name,
                String type,
                int projectId,
                String projectName,
                List<Combination> combinations) {

        this.name = name;
        this.type = type;
        this.projectId = projectId;
        this.projectName = projectName;
        this.combinations = combinations;
    }
}
