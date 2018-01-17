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
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	
	@Autowired
	private FournisseurService fournisseurService;
	
	
	
	@RequestMapping(value = "/saveProduit", method = RequestMethod.POST)
	public ModelAndView saveProduit(@ModelAttribute("produitBean") ProduitBean produitBean, 
			BindingResult result) {
		
		if (result.hasErrors()) {
            //Traitement de l'erreur
			return new ModelAndView("redirect:/addP.html");
       }
		
		Produit produit = prepareModelProduit(produitBean);
		produitService.addProduit(produit);
		return new ModelAndView("redirect:/addP.html");
	}
	@RequestMapping(value="/produits", method = RequestMethod.GET)
	public ModelAndView listProduits() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("produits",  prepareListofBean(produitService.listProduits()));
		model.put("fournisseurs",  prepareListofBeanF(fournisseurService.listFournisseurs()));
		return new ModelAndView("produitsList", model);
	}
	@RequestMapping(value="/addP", method = RequestMethod.GET)
	public ModelAndView addProduit(@ModelAttribute("produitBean")  ProduitBean produitBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("produits",  prepareListofBean(produitService.listProduits()));
		model.put("fournisseurs",  prepareListofBeanF(fournisseurService.listFournisseurs()));
		return new ModelAndView("addProduit", model);
	}
	@RequestMapping(value = "/deleteP", method = RequestMethod.GET)
	public ModelAndView editProduit(@ModelAttribute("produitBean") ProduitBean produitBean,
			BindingResult result) {
		produitService.deleteProduit(prepareModelProduit(produitBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("produit", null);
		model.put("produits",  prepareListofBean(produitService.listProduits()));
		return new ModelAndView("produitsList", model);
		
	}
	@RequestMapping(value = "/editP", method = RequestMethod.GET)
	public ModelAndView deleteProduit(@ModelAttribute("produitBean") ProduitBean produitBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("produit", prepareProduitBean(produitService.getProduit(produitBean.getCodeProduitb())));
		model.put("produits",  prepareListofBean(produitService.listProduits()));
		model.put("fournisseurs",  prepareListofBeanF(fournisseurService.listFournisseurs()));
		return new ModelAndView("addProduit", model);
	}
	private Produit prepareModelProduit(ProduitBean produitBean){
		Produit produit = new Produit();
		produit.setProdCodeProduit(produitBean.getCodeProduitb());
		produit.setProdDesignation(produitBean.getDesignationb());
		produit.setProdPAchat(produitBean.getpAchatb());
		produit.setProdPVente(produitBean.getpVenteb());
		produit.setProdStock(produitBean.getStockb());
		produit.setProdFournisseur(produitBean.getFournisseurb());
		produit.setProdNomFournisseur(produitBean.getNomFournisseur());
		produitBean.setCodeProduitb(null);
		return produit;
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
	private ProduitBean prepareProduitBean(Produit produit){
		ProduitBean bean = new ProduitBean();
		bean.setCodeProduitb(produit.getProdCodeProduit());
		bean.setDesignationb(produit.getProdDesignation());
		bean.setpAchatb(produit.getProdPAchat());
		bean.setpVenteb(produit.getProdPVente());
		bean.setStockb(produit.getProdStock());
		bean.setFournisseurb(produit.getProdFournisseur());
		bean.setNomFournisseur(produit.getProdNomFournisseur());
		return bean;
	}
	private List<FournisseurBean> prepareListofBeanF(List<Fournisseur> fournisseurs){
		List<FournisseurBean> beans = null;
		if(fournisseurs != null && !fournisseurs.isEmpty()){
			beans = new ArrayList<FournisseurBean>();
			FournisseurBean bean = null;
			for(Fournisseur fournisseur : fournisseurs){
				bean = new FournisseurBean();
				bean.setIdF(fournisseur.getFournId());
				bean.setEnseigne(fournisseur.getFournEnseigne());
				bean.setAdresse(fournisseur.getFournAdresse());
				bean.setCodePostal(fournisseur.getFournCodePostal());
				bean.setVille(fournisseur.getFournVille());
				bean.setTelephone(fournisseur.getFournTelephone());
				bean.setEmail(fournisseur.getFournEmail());
				bean.setSiret(fournisseur.getFournSiret());
				beans.add(bean);
			}
		}
		return beans;
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
}
