package application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
public class OutputField {

    private int id;
    List<Test> tests;

    public OutputField(@JsonProperty("tests") List<Test> tests) {
        ObjectId objectId = new ObjectId();
        this.id = objectId.hashCode() > 0 ? objectId.hashCode() : objectId.hashCode() * (-1);
        this.tests = tests;
    }
}
