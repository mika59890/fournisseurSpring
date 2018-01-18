<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/> "/>
		<title>Panier</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
			<table>
				<caption class="bleu">Panier</caption>
				<tr>
					<th class="bleu">ID utilisateur</th>
					<th class="bleu">Code produit</th>
					<th class="bleu">Désignation</th>
					<th class="bleu">Prix unitaire</th>
					<th class="bleu">Prix de vente</th>
					<th class="bleu">Quantité</th>
				</tr>
				<form:form method="POST" modelAttribute="panier" action="commande.html">
				<c:forEach items="${paniers}" var="panier">
					<c:if test="${fournisseur.idF == produit.fournisseurb}">
						<tr>
						
							<td><c:out value="${panier.numUtilisateur}"/></td>
							<td><c:out value="${panier.codeProduitp}"/></td>
							<td><c:out value="${panier.designationp}"/></td>
							<td><c:out value="${panier.pAchatp}"/></td>
							<td><c:out value="${panier.pVentep}"/></td>
							<td><c:out value="${panier.quantitep}"/></td>
							
						</tr>
						<td><input type="submit" value="Valider la commande"></td>
					</c:if>	
					</c:forEach>
				</form:form>
			</table>
	</body>
</html>