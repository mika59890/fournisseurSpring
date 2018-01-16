package com.mika.service;

import java.util.List;

import com.mika.model.Produit;

public interface ProduitService {
	
	public void addProduit(Produit produit);

	public List<Produit> listProduits();
	
	public Produit getProduit(int codeProduit);
	
	public void deleteProduit(Produit produit);
}
