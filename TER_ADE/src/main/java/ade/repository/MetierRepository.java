package ade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ade.beans.Metier;
import ade.beans.Secteur;

public interface MetierRepository extends MongoRepository<Metier, Integer> {
	Metier findByNom(String nom);
}
