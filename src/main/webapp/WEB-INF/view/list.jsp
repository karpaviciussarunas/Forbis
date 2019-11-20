<%-- 
    Document   : list
    Created on : Nov 17, 2019, 4:53:12 PM
    Author     : Sars
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>List</title>
    </head>
    <body>
        <h1>List</h1>
<table id="result">
                <thead>
                    <tr>
                        <th class="header">List of analyses</th>
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
        <a href="back"><button>Back</button></a><br>
    </body>
</html>
