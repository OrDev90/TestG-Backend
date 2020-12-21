package application.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OutputFieldUpdatePayload {

    List<Test> tests;

    public OutputFieldUpdatePayload(List<Test> tests) {
        this.tests = tests;
    }
}
