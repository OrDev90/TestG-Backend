package application.services;

import application.entities.InputField;
import application.entities.InputFieldUpdatePayload;
import application.repositories.InputFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputFieldService {

    @Autowired
    InputFieldRepository inputFieldRepository;

    public List<InputField> getInputFields() {
        return this.inputFieldRepository.findAll();
    }

    public InputField createInputField(InputField inputField) {
        return this.inputFieldRepository.insert(inputField);
    }

    public Optional<InputField> getInputFieldById(int id) {
        return this.inputFieldRepository.findById(id);
    }

    public Optional<InputField> deleteInputFieldById(int id) {
        Optional<InputField> inputField = this.inputFieldRepository.findById(id);
        inputField.ifPresent(i -> this.inputFieldRepository.delete(i));
        return inputField;
    }

    public Optional<InputField> updateInputFieldById(int id, InputFieldUpdatePayload inputFieldUpdatePayload) {
        Optional<InputField> inputField = this.inputFieldRepository.findById(id);
        inputField.ifPresent(i -> i.setProjectName(inputFieldUpdatePayload.getProjectName()));
        inputField.ifPresent(i -> i.setProjectId(inputFieldUpdatePayload.getProjectId()));
        inputField.ifPresent(i -> i.setParameters(inputFieldUpdatePayload.getParameters()));
        inputField.ifPresent(i -> i.setConditions(inputFieldUpdatePayload.getConditions()));
        inputField.ifPresent(i -> this.inputFieldRepository.save(i));
        return inputField;
    }

    public InputField findTopByOrderByIdAsc() {
        return this.inputFieldRepository.findTopByOrderByIdAsc();
    }
}
