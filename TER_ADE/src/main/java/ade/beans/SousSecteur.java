package ade.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SousSecteur {

	@Id
    private Integer id;
	private String nom;
	private String code;
	
	private List<Association> associationList;
	
	public SousSecteur(Integer id, String nom, String code) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
		associationList = new ArrayList<>();
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public List<Association> getAssociationList() {
		return associationList;
	}

	public void setAssociationList(List<Association> associationList) {
		this.associationList = associationList;
	}
}
