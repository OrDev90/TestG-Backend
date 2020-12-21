package tests_generators.output.objects;

import lombok.Getter;
import tests_generators.combination_generator.definitions.Combination;

import java.util.List;

@Getter
public class Test {

    private final String name;
    private final String type;
    private final int projectId;
    private final String projectName;
    private final List<Combination> combinations;

    public Test(String name, String type, int projectId,
                String projectName, List<Combination> combinations) {
        this.name = name;
        this.type = type;
        this.projectId = projectId;
        this.projectName = projectName;
        this.combinations = combinations;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Test that = (Test) o;
        return projectId == that.projectId &&
                projectName.equals(that.projectName) &&
                combinations.equals(that.combinations);

    }
}
