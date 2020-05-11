package ade.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ade.beans.SousSecteur;

public interface SousSecteurRepository extends MongoRepository<SousSecteur, Integer> {
	SousSecteur findByNom(String nom);
}
