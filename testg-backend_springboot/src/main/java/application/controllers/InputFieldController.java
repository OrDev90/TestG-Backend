package application.controllers;

import application.entities.InputField;
import application.entities.InputFieldUpdatePayload;
import application.services.InputFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/input_field")
@CrossOrigin(origins = "http://localhost:4200")
public class InputFieldController {

    @Autowired
    InputFieldService inputFieldService;

    @GetMapping
    public List<InputField> getInputFields() {
        return this.inputFieldService.getInputFields();
    }

    @PostMapping
    public InputField createInputField(@RequestBody InputField inputField) {
        return this.inputFieldService.createInputField(inputField);
    }

    @GetMapping(value = "/{id}")
    public Optional<InputField> getInputFieldById(@PathVariable("id") int id) {
        return this.inputFieldService.getInputFieldById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Optional<InputField> deleteInputFieldById(@PathVariable("id") int id) {
        return this.inputFieldService.deleteInputFieldById(id);
    }

    @PutMapping(value = "/{id}")
    public Optional<InputField> updateInputFieldById(@PathVariable("id") int id,
                                                     @RequestBody InputFieldUpdatePayload inputFieldUpdatePayload) {
        return this.inputFieldService.updateInputFieldById(id, inputFieldUpdatePayload);
    }

    @GetMapping(value = "/last")
    public InputField getInputFieldByOrderById() {
        return this.inputFieldService.findTopByOrderByIdAsc();
    }
}
