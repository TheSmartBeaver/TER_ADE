package ade.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Secteur {

	@Id
    private Integer id;
	private String code;
	private String nom;

	@DBRef(lazy = true)
	private List<SousSecteur> sousSecteurList;

	public Secteur(Integer id, String nom, String code) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
		sousSecteurList = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<SousSecteur> getSousSecteurList() {
		return sousSecteurList;
	}

	public void setSousSecteurList(List<SousSecteur> sousSecteurList) {
		this.sousSecteurList = sousSecteurList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
