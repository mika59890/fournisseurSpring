package com.mika.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mika.model.Produit;

@Repository("produitDao")
public class ProduitDaoImpl implements ProduitDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProduit(Produit produit) {
		sessionFactory.getCurrentSession().saveOrUpdate(produit);
	}

	@SuppressWarnings("unchecked")
	public List<Produit> listProduits() {
		return (List<Produit>) sessionFactory.getCurrentSession().createCriteria(Produit.class).list();
	}

	public Produit getProduit(int codeProduit) {
		return (Produit) sessionFactory.getCurrentSession().get(Produit.class, codeProduit);
	}

	public void deleteProduit(Produit produit) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Produit WHERE codeProduit = "+produit.getProdCodeProduit()).executeUpdate();
	}
}
