package com.mika.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mika.model.Panier;
import com.mika.model.Produit;

@Repository("panierDao")
public class PanierDaoImpl implements PanierDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addPanier(Panier panier) {
		sessionFactory.getCurrentSession().saveOrUpdate(panier);
		
	}

	@SuppressWarnings("unchecked")
	public List<Panier> listPaniers() {
		return (List<Panier>) sessionFactory.getCurrentSession().createCriteria(Produit.class).list();
	}

	public Panier getPanier(int panid) {
		return (Panier) sessionFactory.getCurrentSession().get(Produit.class, panid);
	}

	public void deletePanier(Panier panier) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Panier WHERE panid = "+panier.getNumUtilisateur()).executeUpdate();
		
	}

}
