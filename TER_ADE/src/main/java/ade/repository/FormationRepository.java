package ade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ade.beans.Formation;
import ade.beans.Secteur;

public interface FormationRepository extends MongoRepository<Formation, Integer> {
	Formation findByNom(String nom);
}
