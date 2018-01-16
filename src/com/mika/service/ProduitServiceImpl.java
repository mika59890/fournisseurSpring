package com.mika.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mika.dao.ProduitDao;
import com.mika.model.Produit;

@Service("produitService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	private ProduitDao produitDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProduit(Produit produit) {
		produitDao.addProduit(produit);
		
	}

	public List<Produit> listProduits() {
		return produitDao.listProduits();
	}

	public Produit getProduit(int codeProduit) {
		return produitDao.getProduit(codeProduit);
	}

	public void deleteProduit(Produit produit) {
		produitDao.deleteProduit(produit);
	}
	
	
}
