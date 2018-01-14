$(document).ready(function(){
    var $email = $('#email'),
    	$emailJQuery = $('#emailJQuery'),
    	$password = $('#password'),
    	$passwordJQuery = $('#passwordJQuery'),
    	$confirmation = $('#confirmation'),
    	$confirmationJQuery = $('#confirmationJQuery'),
    	$nom = $('#nom'),
    	$enseigneJQuery = $('#enseigneJQuery'),
    	$enseigne = $('#enseigne'),
    	$adresseJQuery = $('#adresseJQuery'),
    	$adresse = $('#adresse'),
    	$codePostalJQuery = $('#codePostalJQuery'),
    	$codePostal = $('#codePostal'),
    	$villeJQuery = $('#villeJQuery'),
    	$ville = $('#ville'),
    	$telephoneJQuery = $('#telephoneJQuery'),
    	$telephone = $('#telephone'),
    	$siretJQuery = $('#siretJQuery'),
    	$siret = $('#siret'),
    	$designationJQuery = $('#designationJQuery'),
    	$designation = $('#designation'),
    	$fournisseurJQuery = $('#fournisseurJQuery'),
    	$fournisseur = $('#fournisseur'),
    	$referenceFournisseurJQuery = $('#referenceFournisseurJQuery'),
    	$referenceFournisseur = $('#referenceFournisseur'),
    	$referenceInterneJQuery = $('#referenceInterneJQuery'),
    	$referenceInterne = $('#referenceInterne'),
    	$matiereJQuery = $('#matiereJQuery'),
    	$matiere = $('#matiere'),
    	$couleur = $('#couleur'),
    	$couleurJQuery = $('#couleurJQuery'),
    	$lot = $('#lot'),
    	$lotJQuery = $('#lotJQuery'),
    	$prixHT = $('#prixHT'),
    	$prixHTJQuery = $('#prixHTJQuery'),
    	$hauteur = $('#hauteur'),
    	$hauteurJQuery = $('#hauteurJQuery'),
    	$largeur = $('#largeur'),
    	$largeurJQuery = $('#largeurJQuery'),
    	$longueur = $('#longueur'),
    	$longueurJQuery = $('#longueurJQuery'),
    	$diametre = $('#diametre'),
    	$diametreJQuery = $('#diametreJQuery'),
    	$siret = $('#siret'),
    	$envoiArticle = $('#envoiArticle'),
    	$envoiFournisseur = $('#envoiFournisseur'),
    	$envoi = $('#envoi');
    	
    
    function verifConfirm(){
    	if($confirmation.val() != ""){
	    	if($confirmation.val() != $password.val()){ // si la confirmation est différente du mot de passe
	    		$confirmation.css({ // on rend le champ rouge
	    	    borderColor : '#900',
	    	    color : '#900'});
	            $confirmationJQuery.html("<span>Les mots de passe entrés sont différents, merci de les saisir à nouveau.</span>");
	            $confirmation.value = " ";
	            $password.value = " ";
	            return false;
    		}else{
    			$confirmation.css({ 
    	    	    borderColor : '#999',
    	    	    color : 'black'});
    	        $confirmationJQuery.html("");
    	        return true;
    		}
        }else{
     	   verifier($confirmation);
     	  return false;
        }
    }
    function verifier(champ){
        if(champ.val() == ""){ // si le champ est vide
            champ.css({ // on rend le champ rouge
        	    borderColor : '#900',
        	    color : '#900'});
        }
    }
    function verifChamp(champ){
    	if(champ.val() != ""){
    		champ.css({ 
	       	    borderColor : '#999',
	       	    color : 'black'});
    		return true;
    	}else{
     	   verifier(champ);
     	  return false;
        }
    }
    function verifMail(){
       if($email.val() != ""){
       var regex = new RegExp('^[0-9a-z._-]+@{1}[0-9a-z.-]{2,}[.]{1}[a-z]{2,5}$');
	       if(!regex.test($email.val()))
	       {
	    	   $email.css({ // on rend le champ rouge
	       	    borderColor : '#900',
	       	    color : '#900'});
	    	   $emailJQuery.html("<span>Merci de saisir une adresse mail valide.</span>");
	    	   return false;
	       }else{
	    	   $email.css({ 
		    	borderColor : '#999',
		    	backgroundcolor : 'white',
		    	color : 'black'});
		       $emailJQuery.html("");
		       return true;
	       }
       }else{
    	   verifier($email);
    	   return false;
       }    
    }
    function verifPass(){
    	if($password.val() != ""){
	    	if($password.val().length < 4 ){
	    		$password.css({ // on rend le champ rouge
	           	    borderColor : '#900',
	           	    color : '#900'});
	    	$passwordJQuery.html("<span>Les mots de passe doivent contenir au moins 4 caractères.</span>");
	    	return false;
	    	}else{
	    		$password.css({ 
		    	    borderColor : '#999',
		    	    color : 'black'});
		        $passwordJQuery.html("");
		        return true;
	    	}
    	}else{
     	   verifier($password);
     	  return false;
        }	
    }
    function verifTelephone(){
    	if($telephone.val() != ""){
    		var regex = new RegExp('^[0-9._-]{4,18}$');
 	       if(!regex.test($telephone.val()))
 	       {
 	    	  $telephone.css({ // on rend le champ rouge
 	       	    borderColor : '#900',
 	       	    color : '#900'});
 	    	   $telephoneJQuery.html("<span>Merci de saisir un numéro de téléphone valide.</span>");
 	    	   return false;
 	       }else{
 	    	  $telephone.css({ 
 		    	borderColor : '#999',
 		    	backgroundcolor : 'white',
 		    	color : 'black'});
 		       $telephoneJQuery.html("");
 		       return true;
 	       }
    	}else{
      	   verifier($telephone);
      	  return false;
         }	
    }
    function verifSiret(){
    	if($siret.val() != ""){
    	   var regex = new RegExp('^[0-9]{14}$');
 	       if(!regex.test($siret.val()))
 	       {
 	    	  $siret.css({ // on rend le champ rouge
 	       	    borderColor : '#900',
 	       	    color : '#900'});
 	    	   $siretJQuery.html("<span>Merci de saisir un numéro de SIRET valide.</span>");
 	    	   return false;
 	       }else{
 	    	  $siret.css({ 
 		    	borderColor : '#999',
 		    	backgroundcolor : 'white',
 		    	color : 'black'});
 		       $siretJQuery.html("");
 		       return true;
 	       }
    	}else{
      	   verifier($siret);
      	  return false;
         }	
    }
    function verifNombre(champ){
    	if(champ.val() != ""){
    		var regex = new RegExp('^[0-9.]+$');
 	       if(!regex.test(champ.val()))
 	       {
 	    	  champ.css({ // on rend le champ rouge
 	       	    borderColor : '#900',
 	       	    color : '#900'});
 	    	   if(champ == $lot){
 	    		  $lotJQuery.html("<span>Merci de saisir un nombre.</span>");
 	    	   }
 	    	   if(champ == $prixHT){
	    	    	$prixHTJQuery.html("<span>Merci de saisir un nombre.</span>");
	    	   }
 	    	   if(champ == $longueur){
	    	    	$longueurJQuery.html("<span>Merci de saisir un nombre.</span>");
	    	   }
 	    	   if(champ == $hauteur){
	    	    	$hauteurJQuery.html("<span>Merci de saisir un nombre.</span>");
	    	   }
 	    	   if(champ == $largeur){
	    	    	$largeurJQuery.html("<span>Merci de saisir un nombre.</span>");
	    	   }
 	    	   if(champ == $diametre){
 	    		   $diametreJQuery.html("<span>Merci de saisir un nombre.</span>");
    	       }
 	    	   return false;
 	       }else{
 	    	  champ.css({ 
 		    	borderColor : '#999',
 		    	color : 'black'});
 	    	 if(champ == $lot){
	    	    	$lotJQuery.html("");
	    	   }
	    	   if(champ == $prixHT){
	    	    	$prixHTJQuery.html("");
	    	   }
	    	   if(champ == $longueur){
	    	    	$longueurJQuery.html("");
	    	   }
	    	   if(champ == $hauteur){
	    	    	$hauteurJQuery.html("");
	    	   }
	    	   if(champ == $largeur){
	    	    	$largeurJQuery.html("");
	    	   }
	    	   if(champ == $diametre){
	    		   $diametreJQuery.html("");
 	       }
 		       return true;
 	       }
    	}else{
    		verifChamp(champ);
    	}
    }	
    /*Validation nouvel utilisateur*/
    $envoi.click(function(e){
    	if(verifMail() == false || verifPass() == false || verifConfirm() == false || verifChamp($nom) == false) {
        	e.preventDefault(); // on annule la fonction par défaut du bouton d'envoi
        }
        // puis on lance les fonctions de vérification
        verifMail();
        verifPass();
        verifConfirm();
        verifChamp($nom);
    });
    /*Validation fournisseur*/
    $envoiFournisseur.click(function(e){
    	if(verifMail() == false || verifTelephone() == false || verifSiret() == false || verifChamp($enseigne) == false || 
    			verifChamp($adresse) == false || verifChamp($codePostal) == false || verifChamp($ville) == false) {
        	e.preventDefault(); // on annule la fonction par défaut du bouton d'envoi
    	}
        // puis on lance les fonctions de vérification
        verifChamp($enseigne);	
        verifChamp($adresse);
        verifChamp($codePostal);
        verifChamp($ville);
        verifMail();
        verifTelephone();
        verifSiret();
    });
    $envoiArticle.click(function(e){
    	//if(verifMail() == false || verifTelephone() == false || verifSiret() == false || verifChamp($enseigne) == false || 
    			//verifChamp($adresse) == false || verifChamp($codePostal) == false || verifChamp($ville) == false) {
        	e.preventDefault(); // on annule la fonction par défaut du bouton d'envoi
    	//}
        // puis on lance les fonctions de vérification
        verifChamp($designation);	
        verifChamp($fournisseur);
        verifChamp($referenceFournisseur);
        verifChamp($referenceInterne);
        verifChamp($matiere);	
        verifChamp($couleur);
        verifNombre($lot);
        verifNombre($prixHT);
        verifNombre($hauteur);
        verifNombre($largeur);
        verifNombre($longueur);
        verifNombre($diametre);
        
    });
});
