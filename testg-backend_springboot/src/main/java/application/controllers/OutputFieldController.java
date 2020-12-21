package application.controllers;

import application.entities.OutputField;
import application.entities.OutputFieldUpdatePayload;
import application.entities.Test;
import application.services.OutputFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/output_field")
@CrossOrigin(origins = "http://localhost:4200")
public class OutputFieldController {

    @Autowired
    OutputFieldService outputFieldService;

    @GetMapping
    public List<OutputField> getOutputField() {
        return this.outputFieldService.getOutputField();
    }

    @PostMapping
    public OutputField createOutputField(@RequestBody OutputField outputField) {
        return this.outputFieldService.createOutputField(outputField);
    }

    @GetMapping(value="/{id}")
    public Optional<OutputField> getOutputFieldById(@PathVariable("id") int id) {
        return this.outputFieldService.getOutputFieldById(id);
    }

    @DeleteMapping(value="/{id}")
    public Optional<OutputField> deleteOutputFieldById(@PathVariable("id") int id) {
        return this.outputFieldService.deleteOutputFieldById(id);
    }

    @PutMapping(value="/{id}")
    public Optional<OutputField> updateOutputFieldById(@PathVariable("id") int id,
                                               @RequestBody OutputFieldUpdatePayload outputFieldUpdatePayload) {
        return this.outputFieldService.updateOutputFieldById(id, outputFieldUpdatePayload);
    }

    @GetMapping(value = "/project_id/{projectId}")
    public List<Test> getTestsByProjectId(@PathVariable("projectId") int projectId) {
        return this.outputFieldService.getTestsByProjectId(projectId);
    }

    @DeleteMapping(value = "/project_id/{projectId}")
    public List<OutputField> deleteTestsByProjectId(@PathVariable("projectId") int projectId) {
        return this.outputFieldService.deleteTestsByProjectId(projectId);
    }

    @GetMapping(value = "/last")
    public List<Test> findLastOutputFieldTests() {
        return this.outputFieldService.findLastOutputFieldTests();
    }
}
