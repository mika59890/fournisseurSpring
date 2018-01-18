package com.mika.dao;

import java.util.List;

import com.mika.model.Panier;


public interface PanierDao {
	public void addPanier(Panier panier);

	public List<Panier> listPaniers();
	
	public Panier getPanier(int panid);
	
	public void deletePanier(Panier panier);
}
