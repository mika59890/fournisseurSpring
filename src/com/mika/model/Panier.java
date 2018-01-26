package com.mika.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="panier")
public class Panier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idUtilisateur")
	private String numUtilisateur;
	@Column(name = "codeProduit")
	private Integer codeProduitp;
	@Column(name = "designation")
	private String designationp;
	@Column(name = "prixachatunitaire")
	private double pAchatp;
	@Column(name = "pventep")
	private double pVentep;
	@Column(name = "quantite")
	private Integer quantitep;
	
	public String getNumUtilisateur() {
		return numUtilisateur;
	}
	public void setNumUtilisateur(String string) {
		this.numUtilisateur = string;
	}
	public Integer getCodeProduitp() {
		return codeProduitp;
	}
	public void setCodeProduitp(Integer codeProduitp) {
		this.codeProduitp = codeProduitp;
	}
	public String getDesignationp() {
		return designationp;
	}
	public void setDesignationp(String designationp) {
		this.designationp = designationp;
	}
	public double getpAchatp() {
		return pAchatp;
	}
	public void setpAchatp(double pAchatp) {
		this.pAchatp = pAchatp;
	}
	public double getpVentep() {
		return pVentep;
	}
	public void setpVentep(double pVentep) {
		this.pVentep = pVentep;
	}
	public Integer getQuantitep() {
		return quantitep;
	}
	public void setQuantitep(Integer quantitep) {
		this.quantitep = quantitep;
	}
	
	
}
