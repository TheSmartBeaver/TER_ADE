package ade.repository;

import ade.beans.Association;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssociationRepository extends MongoRepository<Association, Integer> {
}
