package com.mika.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mika.bean.EmployeeBean;

@Controller
public class ConnexionController {
	
	
	private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "password";
    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
  
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    @RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public ModelAndView connexion() {
		return new ModelAndView("connexion");
	}
	@RequestMapping(value = "/accueil", method = RequestMethod.POST)
	public ModelAndView connexion(@ModelAttribute("command") EmployeeBean employee, 
			BindingResult result) throws Exception {
		erreurs.clear();
		String email = getValeurChamp(employee.getEmail());
		String password = getValeurChamp(employee.getPassword());
		/* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( password );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
		if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
            return new ModelAndView("accueil");
        } else {
            resultat = "Échec de la connexion.";
        }
		System.out.println("mail :"+email +" pass :"+password+" erreurs :"+erreurs);
		return new ModelAndView("connexion");
    
	}
	private static String getValeurChamp( String nomChamp ) {
        if ( nomChamp == null || nomChamp.trim().length() == 0 ) {
        	System.out.println(nomChamp.trim().length());
            return null;
        } else {
        	System.out.println(nomChamp.trim().length());
            return nomChamp;
        }
    }
	private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.trim().matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );        
        } else if ( email == null){
            throw new Exception( "Merci de saisir une adresse email." );
        }      
    }
	private void validationMotDePasse( String password ) throws Exception {
        if ( password != null ) {
            if ( password.trim().length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
}
