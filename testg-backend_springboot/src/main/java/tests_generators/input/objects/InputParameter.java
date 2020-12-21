package tests_generators.input.objects;

import lombok.Getter;

import java.util.List;

@Getter
public class InputParameter {

    private final String name;
    private final String type;
    private final String notes;
    private final List<String> values;
    private final String from;
    private final String to;
    private final String interval;

    public InputParameter(String name, String type, List<String> values) {
        this.name = name;
        this.type = type;
        this.notes = null;
        this.values = values;
        this.from = null;
        this.to = null;
        this.interval = null;
    }
}
