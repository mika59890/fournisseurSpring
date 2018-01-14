<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/> "/>
		<title>Liste utilisateurs</title>
	</head>
	<body>
		<c:import url="inc/header.jsp"/>
			<table>
				<caption class="bleu">Liste utilisateurs</caption>
				<tr>
					<th class="bleu">ID</th>
					<th class="bleu">Nom</th>
					<th class="bleu">Email</th>
					<th class="bleu">Mot de passe</th>
					<th class="bleu">Actions</th>
				</tr>
				<c:if test="${!empty employees}">
					<c:forEach items="${employees}" var="employee">
						<tr>
							<td><c:out value="${employee.id}"/></td>
							<td><c:out value="${employee.nom}"/></td>
							<td><c:out value="${employee.email}"/></td>
							<td><c:out value="${employee.password}"/></td>
							<td><a class="noir" href="edit.html?id=${employee.id}">Modifier</a> | <a class="noir" href="delete.html?id=${employee.id}">Supprimer</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
	</body>
</html>