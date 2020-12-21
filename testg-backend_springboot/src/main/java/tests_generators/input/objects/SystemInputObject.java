package tests_generators.input.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SystemInputObject {

    private String system_name;
    private List<Func> function_list;

    public SystemInputObject() {
        this.function_list = new ArrayList<>();
    }
}