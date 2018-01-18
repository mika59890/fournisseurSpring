package com.mika.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idLigneCommande;
	@ManyToOne
	@JoinColumn(name = "codeProduit")
	private Produit produit;
	@ManyToOne
	@JoinColumn(name = "idCommande")
	private Commande commande;
	
	private int quantite;
	
	private int prixUnitaire;

	public Integer getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(Integer idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
}
