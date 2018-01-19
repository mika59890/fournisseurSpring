<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="resources/css/style.css"/>" />
    </head>
    <body>
    	<form method="post" action="<c:url value="/accueil.html" />">
            <fieldset>
                <legend>Connexion</legend>

                <label for="nom">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${employee.email}"/>" size="20" maxlength="60" />
                <br />

                <label for="password">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="password" name="password"  size="20" maxlength="20" />
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
          
            </fieldset>
        </form>
    </body>
</html>