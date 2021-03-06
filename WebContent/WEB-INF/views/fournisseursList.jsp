<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/> "/>
		<title>Liste fournisseurs</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
			<table>
				<caption class="bleu">Liste fournisseurs</caption>
				<tr>
					<th class="bleu">ID</th>
					<th class="bleu">Enseigne</th>
					<th class="bleu">Adresse</th>
					<th class="bleu">Code postal</th>
					<th class="bleu">Ville</th>
					<th class="bleu">Telephone</th>
					<th class="bleu">Email</th>
					<th class="bleu">Siret</th>
					<th class="bleu">Actions</th>
				</tr>
				<c:if test="${!empty fournisseurs}">
					<c:forEach items="${fournisseurs}" var="fournisseur">
						<tr>
							<td><c:out value="${fournisseur.idF}"/></td>
							<td><a class="noir" href="editProduitFournisseur.html?idF=${fournisseur.idF}"  title="Afficher les articles de ${fournisseur.enseigne}"><c:out value="${fournisseur.enseigne}"/></a></td>
							<td><c:out value="${fournisseur.adresse}"/></td>
							<td><c:out value="${fournisseur.codePostal}"/></td>
							<td><c:out value="${fournisseur.ville}"/></td>
							<td><c:out value="${fournisseur.telephone}"/></td>
							<td><c:out value="${fournisseur.email}"/></td>
							<td><c:out value="${fournisseur.siret}"/></td>
							<td><a class="noir" href="editF.html?idF=${fournisseur.idF}">Modifier</a> | <a class="noir" href="deleteF.html?idF=${fournisseur.idF}">Supprimer</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
	</body>
</html>