<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/> 
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
	    <script type="text/javascript" src="resources/js/validation.js"></script>
	    <title>Toutbois-utilisateur</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
        <form:form method="post" modelAttribute="utilisateur" action="save.html">
            <fieldset>
                <legend>Ajout utilisateur</legend>
			   	
			   	<form:label for="id" path="id">ID:</form:label>
				<form:input id="id" path="id" value="${employee.id}" readonly="true"/>
				<br>
				<form:label for="nom" path="nom">Nom: <span class="requis">*</span></form:label>
				<form:input id="nom" path="nom" value="${employee.nom}"/>
				<span class="erreur" id="nomJQuery"></span>
				<br>
				<form:label for="email" path="email">Email: <span class="requis">*</span></form:label>
				<form:input id="email" path="email" value="${employee.email}"/>
				<span class="erreur" id="emailJQuery"></span>
				<br>
				<form:label for="password" path="password">Mot de passe: <span class="requis">*</span></form:label>
				<form:input id="password" path="password" value="${employee.password}"/>
				<span class="erreur" id="passwordJQuery"></span>
				<br>
				<label for="confirmation">Confirmer le mot de passe: <span class="requis">*</span></label>
				<input id="confirmation" value=""/>	        
				<span class="erreur" id="confirmationJQuery"></span>
				<br>
				<input type="submit" value="Valider" id="envoi" class="sansLabel"/>
				<br>
			</fieldset>					
		</form:form>
	</body>
</html>