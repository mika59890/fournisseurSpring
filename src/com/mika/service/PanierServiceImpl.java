package com.mika.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mika.dao.PanierDao;
import com.mika.model.Panier;

@Service("panierService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PanierServiceImpl implements PanierService{
	
	@Autowired
	private PanierDao panierDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPanier(Panier panier){
		panierDao.addPanier(panier);
	}

	public List<Panier> listPaniers(){
		return panierDao.listPaniers();
	}

	public Panier getPanier(int numUtilisateur){
		return panierDao.getPanier(numUtilisateur);
	}

	public void deletePanier(Panier panier){
		panierDao.deletePanier(panier);
		
	}

}
