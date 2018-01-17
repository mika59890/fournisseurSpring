package com.mika.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mika.bean.EmployeeBean;
import com.mika.model.Employee;

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
    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
	public ModelAndView deconnexion(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	session.invalidate();
		return new ModelAndView("connexion");
	}
    
    
    @RequestMapping(value = "/acc", method = RequestMethod.GET )
	public ModelAndView logo() {
    	return new ModelAndView("accueil");
    }	
	@RequestMapping(value = "/accueil", method = RequestMethod.POST )
	public ModelAndView connexion(@ModelAttribute("command") EmployeeBean employeeBean, 
			BindingResult result , HttpServletRequest request) throws Exception {
		erreurs.clear();
		Employee employee = new Employee();
		employee.setEmpEmail(employeeBean.getEmail());
		employee.setEmpPassword(employeeBean.getPassword());
		String email = getValeurChamp(employee.getEmpEmail());
		String password = getValeurChamp(employee.getEmpPassword());
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
			HttpSession session = request.getSession();
			session.setAttribute( "sessionEmail", employee );
            resultat = "Succès de la connexion.";
            return new ModelAndView("accueil"," ",employee);
        } else {
            resultat = "Échec de la connexion.";
        }
		return new ModelAndView("connexion");
	}
	private static String getValeurChamp( String nomChamp ) {
        if ( nomChamp == null || nomChamp.trim().length() == 0 ) {
            return null;
        } else {
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
