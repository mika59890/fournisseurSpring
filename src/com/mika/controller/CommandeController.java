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
import com.mika.bean.PanierBean;
import com.mika.bean.ProduitBean;
import com.mika.model.Fournisseur;
import com.mika.model.Panier;
import com.mika.model.Produit;
import com.mika.service.FournisseurService;
import com.mika.service.PanierService;
import com.mika.service.ProduitService;

@Controller
public class CommandeController {
	
	@Autowired
	private ProduitService produitService;
	
	@Autowired
	private FournisseurService fournisseurService;
	
	@Autowired
	private PanierService panierService;
	
	@RequestMapping(value = "/savePanier", method = RequestMethod.GET)
	public ModelAndView savePanier(@ModelAttribute("panier") PanierBean panierBean, 
			BindingResult result) {
		
		if (result.hasErrors()) {
            //Traitement de l'erreur
			return new ModelAndView("redirect:/fournisseursList.html");
       }
		System.out.println(panierBean.getCodeProduitpb());
		Panier panier = prepareModel(panierBean);
		System.out.println(panier.getCodeProduitp());
		panierService.addPanier(panier);
		return new ModelAndView("redirect:/ajoutPanier.html");
	}
	
	@RequestMapping(value="/editProduitFournisseur", method = RequestMethod.GET)
	public ModelAndView listProduitsParFournisseur(@ModelAttribute("fournisseurBean") FournisseurBean fournisseurBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fournisseur", prepareFournisseurBean(fournisseurService.getFournisseur(fournisseurBean.getIdF())));
		model.put("produits",  prepareListofBeanProduit(produitService.listProduits()));
		return new ModelAndView("produitsListFournisseur",model);
	}
	@RequestMapping(value="/ajoutPanier", method = RequestMethod.GET)
	public ModelAndView ajoutPanier(@ModelAttribute("panier") PanierBean panierBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("paniers",  prepareListofBeanPanier(panierService.listPaniers()));
		return new ModelAndView("panier");
	}
	@RequestMapping(value="/editCommande", method = RequestMethod.GET)
	public ModelAndView affichageCommande() {
		return new ModelAndView("commande");
	}
	private PanierBean preparePanierBean(Panier panier){
		PanierBean bean = new PanierBean();
		bean.setNumUtilisateurb(panier.getNumUtilisateur());
		bean.setCodeProduitpb(panier.getCodeProduitp());
		bean.setDesignationpb(panier.getDesignationp());
		bean.setpAchatpb(panier.getpAchatp());
		bean.setpVentepb(panier.getpVentep());
		bean.setQuantitepb(panier.getQuantitep());
		return bean;
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
	private List<ProduitBean> prepareListofBeanProduit(List<Produit> produits){
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
	private List<PanierBean> prepareListofBeanPanier(List<Panier> paniers){
		List<PanierBean> beans = null;
		if(paniers != null && !paniers.isEmpty()){
			beans = new ArrayList<PanierBean>();
			PanierBean bean = null;
			for(Panier panier : paniers){
				bean = new PanierBean();
				bean.setNumUtilisateurb(panier.getNumUtilisateur());
				bean.setCodeProduitpb(panier.getCodeProduitp());
				bean.setDesignationpb(panier.getDesignationp());
				bean.setpAchatpb(panier.getpAchatp());
				bean.setpVentepb(panier.getpVentep());
				bean.setQuantitepb(panier.getQuantitep());
				beans.add(bean);
			}
		}
		return beans;
	}
	private Panier prepareModel(PanierBean panierBean){
		Panier panier = new Panier();
		panier.setNumUtilisateur(panierBean.getNumUtilisateurb());
		panier.setCodeProduitp(panierBean.getCodeProduitpb());
		panier.setDesignationp(panierBean.getDesignationpb());
		panier.setpAchatp(panierBean.getpAchatpb());
		panier.setpVentep(panierBean.getpVentepb());
		panier.setQuantitep(panierBean.getQuantitepb());
		panier.setNumUtilisateur(null);
		return panier;
	}
}
