package tests_generators.input.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Func {

    private String name;
    private List<VarSet> var_set_list;
    private List<Var> var_list;

    public Func() {
        this.var_set_list = new ArrayList<>();
        this.var_list = new ArrayList<>();
    }
}
