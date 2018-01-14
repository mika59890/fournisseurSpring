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
import com.mika.model.Fournisseur;
import com.mika.service.FournisseurService;

@Controller
public class FournisseurController {
	
	@Autowired
	private FournisseurService fournisseurService;
	
	@RequestMapping(value = "/saveFournisseur", method = RequestMethod.POST)
	public ModelAndView saveFournisseur(@ModelAttribute("fournisseurBean") FournisseurBean fournisseurBean, 
			BindingResult result) {
		
		if (result.hasErrors()) {
            //Traitement de l'erreur
			return new ModelAndView("redirect:/addF.html");
       }
		
		Fournisseur fournisseur = prepareModelFournisseur(fournisseurBean);
		fournisseurService.addFournisseur(fournisseur);
		System.out.println(fournisseur.getFournId());
		return new ModelAndView("redirect:/addF.html");
	}
	@RequestMapping(value="/fournisseurs", method = RequestMethod.GET)
	public ModelAndView listFournisseurs() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fournisseurs",  prepareListofBean(fournisseurService.listFournisseurs()));
		return new ModelAndView("fournisseursList", model);
	}
	@RequestMapping(value="/addF", method = RequestMethod.GET)
	public ModelAndView addFournisseur(@ModelAttribute("fournisseurBean")  FournisseurBean fournisseurBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fournisseurs",  prepareListofBean(fournisseurService.listFournisseurs()));
		return new ModelAndView("addFournisseur", model);
	}
	@RequestMapping(value = "/deleteFournisseur", method = RequestMethod.GET)
	public ModelAndView editFournisseur( FournisseurBean fournisseurBean,
			BindingResult result) {
		fournisseurService.deleteFournisseur(prepareModelFournisseur(fournisseurBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fournisseur", null);
		model.put("fournisseurs",  prepareListofBean(fournisseurService.listFournisseurs()));
		return new ModelAndView("fournisseursList", model);
	}
	@RequestMapping(value = "/editFournisseur", method = RequestMethod.GET)
	public ModelAndView deleteFournisseur( FournisseurBean fournisseurBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fournisseur", prepareFournisseurBean(fournisseurService.getFournisseur(fournisseurBean.getIdF())));
		model.put("fournisseurs",  prepareListofBean(fournisseurService.listFournisseurs()));
		return new ModelAndView("addFournisseur", model);
	}
	private Fournisseur prepareModelFournisseur(FournisseurBean fournisseurBean){
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setFournId(fournisseurBean.getIdF());
		fournisseur.setFournAdresse(fournisseurBean.getAdresse());
		fournisseur.setFournEnseigne(fournisseurBean.getEnseigne());
		fournisseur.setFournCodePostal(fournisseurBean.getCodePostal());
		fournisseur.setFournVille(fournisseurBean.getVille());
		fournisseur.setFournTelephone(fournisseurBean.getTelephone());
		fournisseur.setFournEmail(fournisseurBean.getEmail());
		fournisseur.setFournSiret(fournisseurBean.getSiret());
		fournisseurBean.setIdF(null);
		return fournisseur;
	}
	private List<FournisseurBean> prepareListofBean(List<Fournisseur> fournisseurs){
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
