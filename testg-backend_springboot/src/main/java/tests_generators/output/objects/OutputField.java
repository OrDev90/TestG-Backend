package tests_generators.output.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OutputField {

    private int id;
    private List<Test> tests;

    public OutputField() {
        this.tests = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        OutputField that = (OutputField) o;
        return tests.equals(that.tests);
    }
}
