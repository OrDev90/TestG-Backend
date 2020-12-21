package tests_generators.input.objects;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.ImmutablePair;
import tests_generators.utils.enums.ConditionsEnum;
import tests_generators.utils.enums.ValueUtilsEnum;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Value {

    private String name;
    private ValueUtilsEnum.Type type;
    private List<String> properties;
    private List<ImmutablePair<ConditionsEnum, List<ImmutablePair<ConditionsEnum, List<String>>>>>[] conditions;

    public Value() {
        this.properties = new ArrayList<>();
        this.conditions[0] = new ArrayList<>();
    }
}
