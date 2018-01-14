<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/> 
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
	    <script type="text/javascript" src="resources/js/validation.js"></script>
	    <title>Toutbois-fournisseur</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
        <form:form method="post" modelAttribute="fournisseurBean" action="saveFournisseur.html">
            <fieldset>
                <legend>Ajout fournisseur</legend>
			   	
			   	<form:label for="idF" path="idF">ID:</form:label>
				<form:input id="idF" path="idF" value="${fournisseur.idF}" readonly="true"/>
				<br>
				<form:label for="enseigne" path="enseigne">Enseigne: <span class="requis">*</span></form:label>
				<form:input id="enseigne" path="enseigne" value="${fournisseur.enseigne}"/>
				<span class="erreur" id="enseigneJQuery"></span>
				<br>
				<form:label for="adresse" path="adresse">Adresse: <span class="requis">*</span></form:label>
				<form:input id="adresse" path="adresse" value="${fournisseur.adresse}"/>
				<span class="erreur" id="adresseJQuery"></span>
				<br>
				<form:label for="codePostal" path="codePostal">CodePostal: <span class="requis">*</span></form:label>
				<form:input id="codePostal" path="codePostal" value="${fournisseur.codePostal}"/>
				<span class="erreur" id="codePostalJQuery"></span>
				<br>
				<form:label for="ville" path="ville">Ville: <span class="requis">*</span></form:label>
				<form:input id="ville" path="ville" value="${fournisseur.ville}"/>
				<span class="erreur" id="villeJQuery"></span>
				<br>
				<form:label for="telephone" path="telephone">Telephone: <span class="requis">*</span></form:label>
				<form:input id="telephone" path="telephone" value="${fournisseur.telephone}"/>
				<span class="erreur" id="telephoneJQuery"></span>
				<br>
				<form:label for="email" path="email">Email: <span class="requis">*</span></form:label>
				<form:input id="email" path="email" value="${fournisseur.email}"/>
				<span class="erreur" id="emailJQuery"></span>
				<br>
				<form:label for="siret" path="siret">Siret: <span class="requis">*</span></form:label>
				<form:input id="siret" path="siret" value="${fournisseur.siret}"/>
				<span class="erreur" id="siretJQuery"></span>
				<br>
				<input type="submit" value="Valider" id="envoiFournisseur" class="sansLabel"/>
				<br>
			</fieldset>					
		</form:form>
	</body>
</html>