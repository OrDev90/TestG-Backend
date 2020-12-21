package tests_generators.input.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VarSet {

    private String name;
    private String type;
    private List<Var> var_list;

    public VarSet() {
        this.var_list = new ArrayList<>();
    }
}
