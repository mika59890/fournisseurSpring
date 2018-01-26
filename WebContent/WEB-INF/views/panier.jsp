<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/> "/>
		<title>Panier</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
		<form:form method="POST" modelAttribute="panier" action="commande.html">
			<table>
				<caption class="bleu">Commandes : statut saisi</caption>
				<tr>
					<th class="bleu">Nom utilisateur</th>
					<th class="bleu">Code produit</th>
					<th class="bleu">Désignation</th>
					<th class="bleu">Prix unitaire</th>
					<th class="bleu">Prix de vente</th>
					<th class="bleu">Quantité</th>
				</tr>
				<c:forEach items="${sessionScope.paniers}" var="panier">
						<tr>		
							<td><c:out value="${sessionUtilisateur.empNom}"/></td>
							<td><c:out value="${panier.value.getCodeProduitp()}"/></td>
							<td><c:out value="${panier.value.getDesignationp()}"/></td>
							<td><c:out value="${panier.value.getpAchatp()}"/></td>
							<td><c:out value="${panier.value.getpVentep()}"/></td>
							<td><c:out value="${panier.value.getQuantitep()}"/></td>
						</tr>	
					</c:forEach>
			</table>
			<input type="submit" value="Valider la commande">
			</form:form>
	</body>
</html>