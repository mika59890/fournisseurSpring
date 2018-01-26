<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/> "/>
		<title>Liste produits</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
		
			<table>
				<caption class="bleu">Liste produits <c:out value="${fournisseur.enseigne}"/></caption>
				<tr>
					<th class="bleu">Code produit</th>
					<th class="bleu">Désignation</th>
					<th class="bleu">Prix d'achat</th>
					<th class="bleu">Prix de vente</th>
					<th class="bleu">Quantité</th>
					<th class="bleu">Actions</th>
				</tr>
				
				<c:forEach items="${produits}" var="produit">
				<form action="savePanier.html" method="GET">
					<c:if test="${fournisseur.idF == produit.fournisseurb}">
						
						<tr>
							<td><input type="text" name="codeProduit" value="${produit.codeProduitb}"/></td>
							<td><input type="text" name="designation" value="${produit.designationb}"/></td>
							<td><input type="text" name="prixAchat" value="${produit.pAchatb}"/></td>
							<td><input type="text" name="prixVente" value="${produit.pVenteb}"/></td>
							<td><input type="number" name="quantite"  value=""/></td>
							<td><input type="submit" value="Ajouter au panier"></td>
							
						</tr>
						
					</c:if>	
				</form>
					</c:forEach>
					
			</table>
			
	</body>
</html>