<%-- 
    Document   : index
    Created on : Nov 11, 2019, 4:54:15 PM
    Author     : Sars
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Forbis project</h1>
        <fieldset>
            <legend>Informacia apie programą</legend>
            <p>Ši programa priima jusų įvestą tekstą, 
                iš jo pašalina visus simbolius kurie neatitinka lotyniško alfabeto paliekant tarpus tarp žodžių.
                Surenka visų žodžių unikalias paskutines raides ir išrūšiuoja jas pagal alfabetą.
                Išrenkami ir suskaičiuojami žodžiai kurie pasibaigia kiekviena paduota unikalia raide.
                Rezultatas atvaizduojamas naršyklėje nurodant rūšiavimo raidė, pasikartojimų skaičių ir visus atitikusius žodžius atskiriant juos tarpu.
                list mygtukas užkrauna naują langą kuriame atvaizduojami užklausų istorijos duomenys.

            </p>
            <p>
                Programa rašyta naudojantis Spring MVC, maven, JSTL. 
                Sistemaoje aktyvuoti saugigikiai nuo nepageidautino išorinio poveikio. Visos užklausos keliauja į kontrolerį ir iš jo gražinamas rezultatas, atidaromi leistini puslapiai.
                Taip pat sutvarkyta tolerancija puslapio stilizavimui. Prikabintas CSS failas, lengvai galima prikabint JS ir kitus be apribojimų pasiekiamus dokumentus reikalingus.
            </p>

        </form>
    </fieldset>
    <form action="result" method="POST">
        <fieldset>
            <legend>Information:</legend>
            <p>write your text below, press submit and get the analysis</p>
            <input type="text" name="inputText" placeholder="write your text heare"><br>
            <input type="submit" value="Submit">
            </form>
        </fieldset>

        <table id="result">
            <thead>
                <tr>
                    <th class="header">Results</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${lastText}" var="text">
                    <tr>
                        <td title="words"><c:out value ="${text}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <form action="list" method="POST">
            <input type="submit" value="List" >    
        </form>

</body>
</html>
