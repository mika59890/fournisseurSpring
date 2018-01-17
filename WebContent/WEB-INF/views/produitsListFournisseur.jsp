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
					<th class="bleu">Actions</th>
				</tr>
				
				<c:if test="${!empty produits}">
					<c:forEach items="${produits}" var="produit">
						<c:if test="${produit.fournisseurb == fournisseur.idF}">
							<tr>
								<td><c:out value="${produit.codeProduitb}"/></td>
								<td><c:out value="${produit.designationb}"/></td>
								<td><c:out value="${produit.pAchatb}"/></td>
								<td><c:out value="${produit.pVenteb}"/></td>
								<td><a class="noir" href="panier.html?codeProduitb=${produit.codeProduitb}">Commander</a></td>
							</tr>
						</c:if>	
					</c:forEach>
				</c:if>	
			</table>
	</body>
</html>