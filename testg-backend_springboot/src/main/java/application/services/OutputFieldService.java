package application.services;

import application.entities.OutputField;
import application.entities.OutputFieldUpdatePayload;
import application.entities.Test;
import application.repositories.OutputFieldRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OutputFieldService {

    @Autowired
    OutputFieldRepository outputFieldRepository;

    public List<OutputField> getOutputField() {
        return this.outputFieldRepository.findAll();
    }

    public OutputField createOutputField(OutputField outputField) {
        ObjectId objectId = new ObjectId();
        outputField.setId(objectId.hashCode() > 0 ? objectId.hashCode() : objectId.hashCode() * (-1));
        return this.outputFieldRepository.insert(outputField);
    }

    public Optional<OutputField> getOutputFieldById(int id) {
        return this.outputFieldRepository.findById(id);
    }

    public Optional<OutputField> deleteOutputFieldById(int id) {
        Optional<OutputField> outputField = this.outputFieldRepository.findById(id);
        outputField.ifPresent(o -> this.outputFieldRepository.delete(o));
        return outputField;
    }

    public Optional<OutputField> updateOutputFieldById(int id, OutputFieldUpdatePayload outputFieldUpdatePayload) {
        Optional<OutputField> outputField = this.outputFieldRepository.findById(id);
        outputField.ifPresent(o -> o.setTests(outputFieldUpdatePayload.getTests()));
        outputField.ifPresent(o -> this.outputFieldRepository.save(o));
        return outputField;
    }

    public List<Test> getTestsByProjectId(int projectId) {
        List<Test> tests = new ArrayList<>();
        List<OutputField> outputFields = this.outputFieldRepository.findAll();
        for(OutputField outputField : outputFields) {
            for(Test test : outputField.getTests()) {
                if(test.getProjectId() == projectId) {
                    tests.add(test);
                }
            }
        }
        return tests;
    }

    public List<OutputField> deleteTestsByProjectId(int projectId) {
        List<OutputField> outputFields = this.outputFieldRepository.findAll();
        for(OutputField outputField : outputFields) {
            for(Test test : outputField.getTests()) {
                if(test.getProjectId() == projectId) {
                    this.outputFieldRepository.delete(outputField);
                }
            }
        }
        return outputFields;
    }

    public List<Test> findLastOutputFieldTests() {
        List<OutputField> outputFields = this.outputFieldRepository.findAll();
        if(outputFields.size() > 0) {
            return outputFields.get(outputFields.size() - 1).getTests();
        }
        return new ArrayList<>();
    }
}
