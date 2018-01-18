package com.mika.bean;

import com.mika.model.Commande;

public class LigneCommandeBean {
	
	private Integer idLigneCommandeb;
	private ProduitBean produitBean;
	private Commande commandeb;
	private int quantiteb;
	private int prixUnitaireb;
	
	public Integer getIdLigneCommandeb() {
		return idLigneCommandeb;
	}
	public void setIdLigneCommandeb(Integer idLigneCommandeb) {
		this.idLigneCommandeb = idLigneCommandeb;
	}
	public ProduitBean getProduitBean() {
		return produitBean;
	}
	public void setProduitBean(ProduitBean produitBean) {
		this.produitBean = produitBean;
	}
	public Commande getCommandeb() {
		return commandeb;
	}
	public void setCommandeb(Commande commandeb) {
		this.commandeb = commandeb;
	}
	public int getQuantiteb() {
		return quantiteb;
	}
	public void setQuantiteb(int quantiteb) {
		this.quantiteb = quantiteb;
	}
	public int getPrixUnitaireb() {
		return prixUnitaireb;
	}
	public void setPrixUnitaireb(int prixUnitaireb) {
		this.prixUnitaireb = prixUnitaireb;
	}
	
}
