package ade.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ade.beans.Secteur;
import ade.beans.SousSecteur;

public interface SecteurRepository extends MongoRepository<Secteur, Integer> {
	Secteur findByNom(String nom);
	Secteur findByCode(String code);
}
