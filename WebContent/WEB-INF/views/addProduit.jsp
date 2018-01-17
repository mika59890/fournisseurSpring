<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/> 
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
	    <script type="text/javascript" src="resources/js/validation.js"></script>
	    <title>Toutbois-produit</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
        <form:form method="post" modelAttribute="produitBean" action="saveProduit.html">
            <fieldset>
                <legend>Ajout produit</legend>
			   	
			   	<form:label for="codeProduit" path="codeProduitb">Code produit:</form:label>
				<form:input id="codeProduit" path="codeProduitb" value="${produit.codeProduitb}" readonly="true"/>
				<br>
				<form:label for="designation" path="designationb">Designation: <span class="requis">*</span></form:label>
				<form:input id="designation" path="designationb" value="${produit.designationb}"/>
				<span class="erreur" id="designationJQuery"></span>
				<br>
				<form:label for="pAchat" path="pAchatb">Prix d'achat: <span class="requis">*</span></form:label>
				<form:input id="pAchat" path="pAchatb" value="${produit.pAchatb}"/>
				<span class="erreur" id="pAchatJQuery"></span>
				<br>
				<form:label for="pVente" path="pVenteb">Prix de vente: <span class="requis">*</span></form:label>
				<form:input id="pVente" path="pVenteb" value="${produit.pVenteb}"/>
				<span class="erreur" id="pVenteJQuery"></span>
				<br>
				<form:label for="stock" path="stockb">Stock: </form:label>
				<form:input id="stock" path="stockb" value="${produit.stockb}" readonly="true"/>
				<span class="erreur" id="stockJQuery"></span>
				<br>
				<form:label for="fournisseur" path="fournisseurb">Fournisseur: <span class="requis">*</span></form:label>
				<form:select path="fournisseurb" name="fournisseurb" id="fournisseurb" >
				<c:forEach items="${fournisseurs}" var="fournisseur" >
				<option value="${fournisseur.idF}" <c:if test = "${produit.fournisseurb == fournisseur.idF}">selected</c:if> ><c:out value="${fournisseur.enseigne}"/></option>
				</c:forEach>
				</form:select>
				<span class="erreur" id="fournisseurJQuery"></span>
				<br>
				<c:if test="${produit.codeProduitb == null}">
				<input type="submit" value="Valider" id="envoiProduit" class="sansLabel"/>
				</c:if>
				<c:if test="${produit.codeProduitb != null}">
				<input type="submit" value="Modifier" id="envoiProduit" class="sansLabel"/>
				<form:button><a class="noir" href="deleteP.html?codeProduitb=${produit.codeProduitb}">Supprimer</a></form:button>
				</c:if>
				<br>
				
			</fieldset>					
		</form:form>
	</body>
</html>