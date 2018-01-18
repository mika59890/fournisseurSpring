<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/> "/>
		<title>Liste commandes</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
			<table>
				<caption class="bleu">Liste commandes</caption>
				<tr>
					<th class="bleu">Numéro de commande</th>
					<th class="bleu">Date</th>
					<th class="bleu">Code utilisateur</th>
					<th class="bleu">Montant total</th>
					<th class="bleu">Fournisseur</th>
				</tr>
				
				<c:forEach items="${commandes}" var="commande">
						<tr>
							<td><c:out value="${commande.idCommande}"/></td>
							<td><c:out value="${commande.date}"/></td>
							<td><c:out value="${commande.idutilisateurcommande}"/></td>
							<td><c:out value="${commande.montantCommande}"/></td>
							<td><c:out value="${commande.nomfournisseurcommande}"/></td>
						</tr>
				</c:forEach>
			</table>
			<table>
				<caption class="bleu">Détails commandes</caption>
				<tr>
					<th class="bleu">Numéro de commande</th>
					<th class="bleu">Article</th>
					<th class="bleu">Quantité</th>
					<th class="bleu">Prix unitaire</th>
					<th class="bleu">Montant</th>
					<th class="bleu">Actions</th>
				</tr>
				
				<c:forEach items="${ligneCommandes}" var="ligneCommande">
						<tr>
							<td><c:out value="${commande.idCommande}"/></td>
							<td><c:out value="${ligneCommande.designation}"/></td>
							<td><c:out value="${ligneCommande.quantite}"/></td>
							<td><c:out value="${ligneCommande.prixUnitaire}"/></td>
							<td><c:out value=""/></td>
							<td><c:out value=""/></td>
						</tr>
				</c:forEach>
			</table>
	</body>
</html>