package com.mika.dao;

import java.util.List;

import com.mika.model.Produit;

public interface ProduitDao {
	
	public void addProduit(Produit produit);

	public List<Produit> listProduits();
	
	public Produit getProduit(int codeProduit);
	
	public void deleteProduit(Produit produit);
}
