package com.mika.bean;

public class FournisseurBean {
	
	private Integer idF;
	private String enseigne;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private String email;
	private String siret;
	
	public Integer getIdF() {return idF;}

	public void setIdF(Integer idF) {this.idF = idF;}

	public String getEnseigne() {return enseigne;}
	
	public void setEnseigne(String enseigne) {this.enseigne = enseigne;}
	
	public String getAdresse() {return adresse;}
	
	public void setAdresse(String adresse) {this.adresse = adresse;}
	
	public String getCodePostal() {return codePostal;}
	
	public void setCodePostal(String codePostal) {this.codePostal = codePostal;}
	
	public String getVille() {return ville;}
	
	public void setVille(String ville) {this.ville = ville;}
	
	public String getTelephone() {return telephone;}
	
	public void setTelephone(String telephone) {this.telephone = telephone;}
	
	public String getEmail() {return email;}
	
	public void setEmail(String email) {this.email = email;}
	
	public String getSiret() {return siret;}
	
	public void setSiret(String siret) {this.siret = siret;}
}
