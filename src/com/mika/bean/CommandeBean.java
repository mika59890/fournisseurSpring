package com.mika.bean;

import java.util.Date;
import java.util.List;

public class CommandeBean {
	
	private Integer idCommandeb;
	private double montantCommandeb;
	private Integer idUtilisateurCommandeb;
	private String nomFournisseurCommandeb;
	private Date dateb;
	private List<LigneCommandeBean> ligneCommandeb;
	
	public Integer getIdCommandeb() {
		return idCommandeb;
	}
	public void setIdCommandeb(Integer idCommandeb) {
		this.idCommandeb = idCommandeb;
	}
	public double getMontantbCommandeb() {
		return montantCommandeb;
	}
	public void setMontantCommandeb(double montantCommandeb) {
		this.montantCommandeb = montantCommandeb;
	}
	public Integer getIdUtilisateurCommandeb() {
		return idUtilisateurCommandeb;
	}
	public void setIdUtilisateurCommandeb(Integer idUtilisateurCommandeb) {
		this.idUtilisateurCommandeb = idUtilisateurCommandeb;
	}
	public String getNomFournisseurCommandeb() {
		return nomFournisseurCommandeb;
	}
	public void setNomFournisseurCommandeb(String nomFournisseurCommandeb) {
		this.nomFournisseurCommandeb = nomFournisseurCommandeb;
	}
	public Date getDateb() {
		return dateb;
	}
	public void setDateb(Date dateb) {
		this.dateb = dateb;
	}
	public List<LigneCommandeBean> getLigneCommandeb() {
		return ligneCommandeb;
	}
	public void setLigneCommandeb(List<LigneCommandeBean> ligneCommandeb) {
		this.ligneCommandeb = ligneCommandeb;
	}
	
	
}
