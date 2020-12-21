package application.repositories;

import application.entities.InputField;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputFieldRepository extends MongoRepository<InputField, Integer> {

    InputField findTopByOrderByIdAsc();
}
