<%-- 
    Document   : gestionnaire_location
    Created on : 29 mai 2024, 12:21:44
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF_8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Gestionnaire</title>
        <link href="css/gestionnaire_location.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="C:\Users\USER\Desktop\LSI3-INFO\Programmation web\fontawesome-free-6.2.1-web\css\all.min.css"/>
    </head>
    <body> 
        <div class="form-container">
            <form method="post" action="co_location" id="signUpForm">
                <h2>Gestionnaire</h2>
                <div class="form-group">
                    <label for="id">Identifiant</label>
                    <input type="text" id="id" name="id" required/>
                </div>
                <div class="form-group">
                    <label for="localite">Localite</label>
                    <input type="text" id="localite" name="localite" required/>
                </div>
                <div class="form-group">
                    <label for="type">Type</label>
                    <select id="type" name="type">
                        <option>STUDIO</option>
                        <option>CHAMBRE</option>
                        <option>APPARTEMENT</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="prix">Prix</label>
                    <input type="text" id="prix" name="prix" required/>
                </div>
                <div class="form-group">
                    <label for="contact">Contact</label>
                    <input type="contact" id="contact" name="proprio" required/>
                </div>
                <button type="submit" class="submit-button">Envoyer</button>
                <button type="reset" class="submit-button">Annuler</button>
            </form>
        </div>
        <script src="formulaie.js"></script>
    </body>
</html>