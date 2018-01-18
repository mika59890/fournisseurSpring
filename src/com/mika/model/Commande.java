package com.mika.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Commande implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idCommande;
	@Column(name = "montantcommande")
	private double montantCommande;
	@Column(name = "idutilisateurcommande")
	private Integer idUtilisateurCommande;
	@Column(name = "nomfournisseurcommande")
	private String nomFournisseurCommande;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> ligneCommande;
	
	public Integer getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}
	public double getMontantCommande() {
		if(!ligneCommande.isEmpty()) {
			for(LigneCommande ligneCommandes : ligneCommande) {
				double totalLigne = ligneCommandes.getQuantite() * (ligneCommandes.getPrixUnitaire());
				montantCommande = montantCommande + totalLigne;
			}
		}
		return montantCommande;
	}
	public void setMontantCommande(double montantCommande) {
		this.montantCommande = montantCommande;
	}
	public Integer getIdUtilisateurCommande() {
		return idUtilisateurCommande;
	}
	public void setIdUtilisateurCommande(Integer idUtilisateurCommande) {
		this.idUtilisateurCommande = idUtilisateurCommande;
	}
	public String getNomFournisseurCommande() {
		return nomFournisseurCommande;
	}
	public void setNomFournisseurCommande(String nomFournisseurCommande) {
		this.nomFournisseurCommande = nomFournisseurCommande;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}
	public void setLigneCommande(List<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
}
