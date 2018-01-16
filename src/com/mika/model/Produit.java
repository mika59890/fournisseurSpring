package com.mika.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produit")
public class Produit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "codeProduit")
	private Integer prodCodeProduit;
	
	@Column(name = "designation")
	private String prodDesignation;
	
	@Column(name = "pu")
	private double prodPAchat;
	
	@Column(name = "pa")
	private double prodPVente;
	
	@Column(name = "quantite")
	private int prodStock;
	
	@Column(name = "fournid")
	private Integer prodFournisseur;

	public Integer getProdCodeProduit() {
		return prodCodeProduit;
	}

	public void setProdCodeProduit(Integer prodCodeProduit) {
		this.prodCodeProduit = prodCodeProduit;
	}

	public String getProdDesignation() {
		return prodDesignation;
	}

	public void setProdDesignation(String prodDesignation) {
		this.prodDesignation = prodDesignation;
	}

	public double getProdPAchat() {
		return prodPAchat;
	}

	public void setProdPAchat(double prodPAchat) {
		this.prodPAchat = prodPAchat;
	}

	public double getProdPVente() {
		return prodPVente;
	}

	public void setProdPVente(double prodPVente) {
		this.prodPVente = prodPVente;
	}

	public int getProdStock() {
		return prodStock;
	}

	public void setProdStock(int prodStock) {
		this.prodStock = prodStock;
	}

	public Integer getProdFournisseur() {
		return prodFournisseur;
	}

	public void setProdFournisseur(Integer prodFournisseur) {
		this.prodFournisseur = prodFournisseur;
	}
	
	

}
