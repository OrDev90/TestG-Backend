package application.repositories;

import application.entities.OutputField;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputFieldRepository extends MongoRepository<OutputField, Integer> {
}
