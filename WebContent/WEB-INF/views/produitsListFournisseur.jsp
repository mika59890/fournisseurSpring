<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/> "/>
		<title>Liste produits</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
		<form:form method="POST"  modelAttribute="produit"  action="savePanier.html">
			<table>
				<caption class="bleu">Liste produits <c:out value="${fournisseur.enseigne}"/></caption>
				<tr>
					<th class="bleu">Code produit</th>
					<th class="bleu">D�signation</th>
					<th class="bleu">Prix d'achat</th>
					<th class="bleu">Prix de vente</th>
					<th class="bleu">Quantit�</th>
					<th class="bleu">Actions</th>
				</tr>
				
				<c:forEach items="${produits}" var="produit">
			
					<c:if test="${fournisseur.idF == produit.fournisseurb}">
						
						<tr>
						
							<td><form:input type="text" path="codeProduitb" value="${produit.codeProduitb}" readonly="true"/></td>
							<td><form:input type="text" path="designationb" value="${produit.designationb}" readonly="true"/></td>
							<td><form:input type="text" path="pAchatb" value="${produit.pAchatb}" readonly="true"/></td>
							<td><form:input type="text" path="pVenteb" value="${produit.pVenteb}" readonly="true"/></td>
					
							<td><input type="submit" value="Ajouter au panier"></td>
							
						</tr>
						
					</c:if>	
			
					</c:forEach>
					
			</table>
		</form:form>
	</body>
</html>