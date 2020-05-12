package ade.repository;

import ade.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ServiceADE {

	@Autowired
	private FormationRepository formationRepository;
	@Autowired
	private MetierRepository metierRepository;
	@Autowired
	private SousSecteurRepository sousSecteurRepository;
	@Autowired
	private SecteurRepository secteurRepository;
	@Autowired
	private  AssociationRepository associationRepository;

	int id_sous_secteur = 0;
	int id_metier = 0;
	int id_secteur = 0;
	int id_formation = 0;
	int id_association = 0;

	/**
	 * Efface toutes les collections de la BDD
	 */
	public void clearAll() {
		formationRepository.deleteAll();
		metierRepository.deleteAll();
		sousSecteurRepository.deleteAll();
		secteurRepository.deleteAll();
		associationRepository.deleteAll();
	}


	public void saveAssociationInSousSecteur(Metier metier, Formation formation, String nom_sous_secteur) {
		Metier metierForRepo = metierRepository.findByNom(metier.getNom());
		Formation formationForRepo = formationRepository.findByNom(formation.getNom());

		/*On évite les doublons et on crée si inexistant*/
		if(metierForRepo==null){
			metierForRepo = metier;
			metierForRepo.setId(id_metier++);
		}

		if(formationForRepo==null){
			formationForRepo = formation;
			formationForRepo.setId(id_formation++);
		}

		Association association = new Association(id_association++,metierForRepo,formationForRepo);

		associationRepository.save(association);
		metierRepository.save(metierForRepo);
		formationRepository.save(formationForRepo);

		//System.err.println("On veut sauvegarder assoc dans ss : "+nom_sous_secteur);
		SousSecteur ss = sousSecteurRepository.findByNom(nom_sous_secteur.trim());
		ss.getAssociationList().add(association);
		sousSecteurRepository.save(ss);
	}

	public void saveSecteur(String nom_secteur, String code_secteur) {
			Secteur secteur = new Secteur(id_secteur++, nom_secteur.trim(), code_secteur.trim());
			secteur.setSousSecteurList(new ArrayList<>());
			secteurRepository.save(secteur);
	}

	// TODO: Un sous-secteur peut-il appartenir à plusieurs secteurs ???
	public void saveSous_Secteur(String nom_sous_secteur, String code_sous_secteur, String code_secteurAppartenance) {
			SousSecteur sous_secteur = new SousSecteur(id_sous_secteur++, nom_sous_secteur.trim(), code_sous_secteur.trim());

			Secteur secteur = secteurRepository.findByCode(code_secteurAppartenance);
			secteur.getSousSecteurList().add(sous_secteur);

			secteurRepository.save(secteur);
			sousSecteurRepository.save(sous_secteur);
	}

	public List<Secteur> findAllSecteur() {
		return secteurRepository.findAll();
	}

	public List<SousSecteur> findAllSSOfS(String codeSecteur) {
		Secteur secteur =  secteurRepository.findByCode(codeSecteur);
		return secteur.getSousSecteurList();
	}

	public HashSet<Metier> findAllMetierOfSS(String codeSS) {
		System.err.println("Cherche métiers de SS:"+codeSS);
		SousSecteur ss =  sousSecteurRepository.findByCode(codeSS);
		List<Association> assosList = ss.getAssociationList();
		HashSet<Metier> metiers = new HashSet<>();

		for(Association asso : assosList){
			metiers.add(asso.getMetier());
		}
		return metiers;
	}

	public HashSet<Formation> findAllFormationOfMetierinSS(String codeSS, String codeMetier) {
		System.err.println("Cherche formations de SS:"+codeSS+" pour le métier "+codeMetier);
		SousSecteur ss =  sousSecteurRepository.findByCode(codeSS);
		List<Association> assosList = ss.getAssociationList();
		HashSet<Formation> formations = new HashSet<>();

		for(Association asso : assosList){
			if(asso.getMetier().getCode().equals(codeMetier))
				formations.add(asso.getFormation());
		}
		return formations;
	}
}
