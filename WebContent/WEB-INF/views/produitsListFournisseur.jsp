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
					<th class="bleu">D�signation</th>
					<th class="bleu">Prix d'achat</th>
					<th class="bleu">Prix de vente</th>
					<th class="bleu">Quantit�</th>
					<th class="bleu">Actions</th>
				</tr>
				
				<c:forEach items="${produits}" var="produit">
						<tr>
							<td><c:out value="${produit.codeProduitb}"/></td>
							<td><c:out value="${produit.designationb}"/></td>
							<td><c:out value="${produit.pAchatb}"/></td>
							<td><c:out value="${produit.pVenteb}"/></td>
							<td><input type="number" value=""></td>
							<td><a class="noir" href="editCommande.html?codeProduitb=${produit.codeProduitb}">Commander</a></td>
						</tr>
					</c:forEach>
			</table>
	</body>
</html>