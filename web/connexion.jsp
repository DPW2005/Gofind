<%-- 
    Document   : connexion
    Created on : 29 mai 2024, 12:28:46
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF_8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Connexion</title>
        <link href="css/connexion.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="C:\Users\USER\Desktop\LSI3-INFO\Programmation web\fontawesome-free-6.2.1-web\css\all.min.css"/>
    </head>
    <body> 
        <div class="form-container">
            <form method="post" action="connexion" id="signUpForm">
                <h2>Connexion</h2>
                <div class="form-group">
                    <label for="email">E-mail</label>
                    <input type="email" id="email" name="email" required/>
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe</label>
                    <input type="password" id="password" name="password" required/>
                </div>
                <button type="submit" class="submit-button">Envoyer</button>
                <button type="reset" class="submit-button">Annuler</button>
            </form>
        </div>
    </body>
</html>