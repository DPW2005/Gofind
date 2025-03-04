<%-- 
    Document   : chauffeur
    Created on : 31 mai 2024, 17:36:42
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF_8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Trajet</title>
        <link href="css/connexion.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="C:\Users\USER\Desktop\LSI3-INFO\Programmation web\fontawesome-free-6.2.1-web\css\all.min.css"/>
    </head>
    <body> 
        <div class="form-container">
            <form method="post" action="chauffeur" id="signUpForm">
                <h2>Trajet</h2>
                <div class="form-group">
                    <label for="depart">Depart</label>
                    <input type="text" id="depart" name="depart" required/>
                </div>
                <div class="form-group">
                    <label for="arrivee">Arrivee</label>
                    <input type="text" id="arrivee" name="arrivee" required/>
                </div>
                <button type="submit" class="submit-button">Envoyer</button>
                <button type="reset" class="submit-button">Annuler</button>
            </form>
        </div>
    </body>
</html>