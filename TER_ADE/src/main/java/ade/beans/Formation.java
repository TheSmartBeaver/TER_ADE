package ade.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Formation {

	@Id
    private Integer id;
	private String nom;
	private String code;
	private String type;
	private String domaines;
	
	public Formation(String nom, String type, String domaines, String code) {
		super();
		this.nom = nom;
		this.type = type;
		this.domaines = domaines;
		this.code = code;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDomaines() {
		return domaines;
	}
	public void setDomaines(String domaines) {
		this.domaines = domaines;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
