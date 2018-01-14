package com.mika.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fournisseur")
public class Fournisseur implements Serializable{
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "fournid")
	private Integer fournId;
	@Column(name = "fournenseigne")
	private String fournEnseigne;
	@Column(name = "fournadresse")
	private String fournAdresse;
	@Column(name = "fourncodepostal")
	private String fournCodePostal;
	@Column(name = "fournville")
	private String fournVille;
	@Column(name = "fourntelephone")
	private String fournTelephone;
	@Column(name = "fournemail")
	private String fournEmail;
	@Column(name = "fournsiret")
	private String fournSiret;
	
	public Integer getFournId() {
		return fournId;
	}
	public void setFournId(Integer fournId) {
		this.fournId = fournId;
	}
	public String getFournEnseigne() {
		return fournEnseigne;
	}
	public void setFournEnseigne(String fournEnseigne) {
		this.fournEnseigne = fournEnseigne;
	}
	public String getFournAdresse() {
		return fournAdresse;
	}
	public void setFournAdresse(String fournAdresse) {
		this.fournAdresse = fournAdresse;
	}
	public String getFournCodePostal() {
		return fournCodePostal;
	}
	public void setFournCodePostal(String fournCodePostal) {
		this.fournCodePostal = fournCodePostal;
	}
	public String getFournVille() {
		return fournVille;
	}
	public void setFournVille(String fournVille) {
		this.fournVille = fournVille;
	}
	public String getFournTelephone() {
		return fournTelephone;
	}
	public void setFournTelephone(String fournTelephone) {
		this.fournTelephone = fournTelephone;
	}
	public String getFournEmail() {
		return fournEmail;
	}
	public void setFournEmail(String fournEmail) {
		this.fournEmail = fournEmail;
	}
	public String getFournSiret() {
		return fournSiret;
	}
	public void setFournSiret(String fournSiret) {
		this.fournSiret = fournSiret;
	}
	
	
}
