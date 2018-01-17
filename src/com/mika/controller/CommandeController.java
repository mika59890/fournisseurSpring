package com.mika.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mika.bean.FournisseurBean;
import com.mika.bean.ProduitBean;
import com.mika.model.Fournisseur;
import com.mika.model.Produit;
import com.mika.service.FournisseurService;
import com.mika.service.ProduitService;

@Controller
public class CommandeController {
	
	@Autowired
	private ProduitService produitService;
	
	@Autowired
	private FournisseurService fournisseurService;
	
	@RequestMapping(value="/editProduitFournisseur", method = RequestMethod.GET)
	public ModelAndView listProduitsParFournisseur(@ModelAttribute("fournisseurBean") FournisseurBean fournisseurBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fournisseur", prepareFournisseurBean(fournisseurService.getFournisseur(fournisseurBean.getIdF())));
		model.put("produits",  prepareListofBean(produitService.listProduits()));
		return new ModelAndView("produitsListFournisseur",model);
	}
	
	private FournisseurBean prepareFournisseurBean(Fournisseur fournisseur){
		FournisseurBean bean = new FournisseurBean();
		bean.setIdF(fournisseur.getFournId());
		bean.setEnseigne(fournisseur.getFournEnseigne());
		bean.setAdresse(fournisseur.getFournAdresse());
		bean.setCodePostal(fournisseur.getFournCodePostal());
		bean.setVille(fournisseur.getFournVille());
		bean.setTelephone(fournisseur.getFournTelephone());
		bean.setEmail(fournisseur.getFournEmail());
		bean.setSiret(fournisseur.getFournSiret());
		return bean;
	}
	private List<ProduitBean> prepareListofBean(List<Produit> produits){
		List<ProduitBean> beans = null;
		if(produits != null && !produits.isEmpty()){
			beans = new ArrayList<ProduitBean>();
			ProduitBean bean = null;
			for(Produit produit : produits){
				bean = new ProduitBean();
				bean.setCodeProduitb(produit.getProdCodeProduit());
				bean.setDesignationb(produit.getProdDesignation());
				bean.setpAchatb(produit.getProdPAchat());
				bean.setpVenteb(produit.getProdPVente());
				bean.setStockb(produit.getProdStock());
				bean.setFournisseurb(produit.getProdFournisseur());
				bean.setNomFournisseur(produit.getProdNomFournisseur());
				beans.add(bean);
			}
		}
		return beans;
	}
}
