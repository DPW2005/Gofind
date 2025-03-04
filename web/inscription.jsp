<%-- 
    Document   : inscription
    Created on : 29 mai 2024, 12:28:56
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF_8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Inscription</title>
        <link href="css/inscription.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="C:\Users\USER\Desktop\LSI3-INFO\Programmation web\fontawesome-free-6.2.1-web\css\all.min.css"/>
    </head>
    <body> 
        <div class="form-container">
            <form method="post" action="inscription" id="signUpForm">
                <h2>Inscription</h2>
                <div class="form-group">
                    <label for="name">Nom</label>
                    <input type="text" id="name" name="nom" required/>
                </div>
                <div class="form-group">
                    <label for="email">E-mail</label>
                    <input type="email" id="email" name="email" required/>
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe</label>
                    <input type="password" id="password" name="password" required/>
                </div>
                <div class="form-group">
                    <label for="confirmpassword">Confirmer le mot de passe</label>
                    <input type="password" id="confirmpassword" name="confirmpassword" required/>
                    <span id="passwordError" class="error-message"></span>
                </div>
                <button type="submit" class="submit-button">Envoyer</button>
                <button type="reset" class="submit-button">Annuler</button>
            </form>
        </div>
    </body>
</html>