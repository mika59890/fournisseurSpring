package com.mika.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mika.model.Fournisseur;

@Repository("fournisseurDao")
public class FournisseurDAOImpl implements FournisseurDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addFournisseur(Fournisseur fournisseur) {
		sessionFactory.getCurrentSession().saveOrUpdate(fournisseur);
		
	}

	@SuppressWarnings("unchecked")
	public List<Fournisseur> listFournisseurs() {
		return (List<Fournisseur>) sessionFactory.getCurrentSession().createCriteria(Fournisseur.class).list();
	}

	public Fournisseur getFournisseur(int fournid) {
		return (Fournisseur) sessionFactory.getCurrentSession().get(Fournisseur.class, fournid);
	}

	public void deleteFournisseur(Fournisseur fournisseur) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Fournisseur WHERE fournid = "+fournisseur.getFournId()).executeUpdate();
	}

}
