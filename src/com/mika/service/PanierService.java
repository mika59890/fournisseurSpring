package com.mika.service;

import java.util.List;

import com.mika.model.Panier;

public interface PanierService {
	
	public void addPanier(Panier panier);

	public List<Panier> listPaniers();
	
	public Panier getPanier(int numUtilisateur);
	
	public void deletePanier(Panier panier);
}
