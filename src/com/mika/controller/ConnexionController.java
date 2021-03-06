package com.mika.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mika.bean.EmployeeBean;
import com.mika.model.Employee;
import com.mika.service.EmployeeService;

@Controller
public class ConnexionController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "password";
    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    int idU;
  
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
        try {
            emailExist(email,password,request);
        } catch ( Exception e ) {
            setErreur( "emailValide", e.getMessage() );
        }
		if ( erreurs.isEmpty()) {
			
            return new ModelAndView("accueil");
        } else {
            resultat = "�chec de la connexion.";
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
	private void emailExist(String email,String password,HttpServletRequest request) throws Exception{
		String empl;
		String passw;
		boolean ok = false;
		ArrayList<EmployeeBean> arraylist = new ArrayList<EmployeeBean>();
		arraylist.addAll( prepareListofBean(employeeService.listEmployeess()));
		for(EmployeeBean emp : arraylist){
			empl = emp.getEmail().toString();
			passw = emp.getPassword().toString();
			if(empl.equals(email)){
				if(passw.equals(password)) {
					Employee employe = new Employee();
					employe.setEmpNom(emp.getNom());
					employe.setEmpEmail(emp.getEmail());
					employe.setEmpPassword(emp.getPassword());
					employe.setEmpId(emp.getId());
					HttpSession session = request.getSession();
					session.setAttribute( "sessionUtilisateur", employe );
					ok = true;
				}
			}
		}
		
		if( ok == false){
			throw new Exception("L'adresse mail saisie n'est pas enregistr�e.");
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
                throw new Exception( "Le mot de passe doit contenir au moins 3 caract�res." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
	private EmployeeBean prepareEmployeeBean(Employee employee){
		EmployeeBean bean = new EmployeeBean();
		bean.setNom(employee.getEmpNom());
		bean.setNom(employee.getEmpEmail());
		bean.setPassword(employee.getEmpPassword());
		bean.setId(employee.getEmpId());
		return bean;
	}
	private List<EmployeeBean> prepareListofBean(List<Employee> employees){
		List<EmployeeBean> beans = null;
		if(employees != null && !employees.isEmpty()){
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for(Employee employee : employees){
				bean = new EmployeeBean();
				bean.setNom(employee.getEmpNom());
				bean.setId(employee.getEmpId());
				bean.setEmail(employee.getEmpEmail());
				bean.setPassword(employee.getEmpPassword());
				beans.add(bean);
			}
		}
		return beans;
	}
}
