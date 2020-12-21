package application.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class Parameter {

    String name;
    String type;
    String notes;
    List<String> values;
    Optional<String> from;
    Optional<String> to;
    Optional<String> interval;


    public Parameter(String name,
                     String type,
                     String notes,
                     List<String> values,
                     Optional<String> from,
                     Optional<String> to,
                     Optional<String> interval) {
        this.name = name;
        this.type = type;
        this.notes = notes;
        this.values = values;
        this.from = from;
        this.to = to;
        this.interval = interval;
    }

    public static void main(String[] args) {
        Parameter parameter = new Parameter("", "", "", new ArrayList<>(), null, null, null);
    }
}
