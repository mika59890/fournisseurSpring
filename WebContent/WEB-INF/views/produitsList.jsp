<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/> "/>
		<title>Liste produits</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
			<table>
				<caption class="bleu">Liste produits</caption>
				<tr>
					<th class="bleu">Code produit</th>
					<th class="bleu">Désignation</th>
					<th class="bleu">Prix d'achat</th>
					<th class="bleu">Prix de vente</th>
					<th class="bleu">Stock</th>
					<th class="bleu">Fournisseur</th>
					<th class="bleu">Actions</th>
				</tr>
				<c:if test="${!empty produits}">
					<c:forEach items="${produits}" var="produit">
						<tr>
							<td><c:out value="${produit.codeProduitb}"/></td>
							<td><c:out value="${produit.designationb}"/></td>
							<td><c:out value="${produit.pAchatb}"/></td>
							<td><c:out value="${produit.pVenteb}"/></td>
							<td><c:if test = "${produit.fournisseurb == fournisseur.idF}">
							<c:out value="${fournisseur.enseigne}"/>
							</c:if>
							</td>
							<td><a class="noir" href="editP.html?codeProduitb=${produit.codeProduitb}">Modifier</a> | <a class="noir" href="deleteP.html?codeProduitb=${produit.codeProduitb}">Supprimer</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
	</body>
</html>