<%-- 
    Document   : gestionnaire_voiture
    Created on : 29 mai 2024, 12:21:56
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF_8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Gestionnaire</title>
        <link href="css/gestionnaire_voiture.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="C:\Users\USER\Desktop\LSI3-INFO\Programmation web\fontawesome-free-6.2.1-web\css\all.min.css"/>
    </head>
    <body> 
        <div class="form-container">
            <form method="post" action="co_voiturage" id="signUpForm">
                <h2>Gestionnaire</h2>
                <div class="form-group">
                    <label for="name">Nom</label>
                    <input type="text" id="name" name="nom" required/>
                </div>
                <div class="form-group">
                    <label for="id">Immatriculation</label>
                    <input type="text" id="id" name="id" required/>
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
                <div class="form-group">
                    <label for="place">Nombre de place</label>
                    <input type="text" id="place" name="place" required/>
                </div>
                <button type="submit" class="submit-button">Envoyer</button>
                <button type="reset" class="submit-button">Annuler</button>
            </form>
        </div>
        <script src="formulaie.js"></script>
    </body>
</html>