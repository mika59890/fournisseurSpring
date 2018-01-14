package com.mika.service;

import java.util.List;

import com.mika.model.Fournisseur;

public interface FournisseurService {
	
	public void addFournisseur(Fournisseur fournisseur);

	public List<Fournisseur> listFournisseurs();
	
	public Fournisseur getFournisseur(int fournid);
	
	public void deleteFournisseur(Fournisseur fournisseur);
}
