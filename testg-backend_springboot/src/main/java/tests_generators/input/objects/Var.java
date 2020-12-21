package tests_generators.input.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Var {

    private String name;
    private String type;
    private List<Value> value_list;

    public Var() {
        this.value_list = new ArrayList<>();
    }
}
