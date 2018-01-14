package com.mika.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mika.dao.FournisseurDAO;
import com.mika.model.Fournisseur;

@Service("fournisseurService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FournisseurServiceImpl implements FournisseurService{
	
	@Autowired
	private FournisseurDAO fournisseurDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFournisseur(Fournisseur fournisseur) {
		fournisseurDao.addFournisseur(fournisseur);
	}

	public List<Fournisseur> listFournisseurs() {
		return fournisseurDao.listFournisseurs();
	}

	public Fournisseur getFournisseur(int fournid) {
		return fournisseurDao.getFournisseur(fournid);
	}

	public void deleteFournisseur(Fournisseur fournisseur) {
		fournisseurDao.deleteFournisseur(fournisseur);
		
	}
	
	
}
