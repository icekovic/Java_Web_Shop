<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/stilovi.css">
        <link rel="stylesheet"  href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <title>Profil kupca</title>
    </head>
    <body>
        <div class="container-fluid padding-top">
            <div class="panel panel-default">
                <div class="panel-heading headingKupac">
                    Popis kupnji za kupca ${sessionScope.kupac.ime} ${sessionScope.kupac.prezime}
                    <a href="odjava" class="lblOdjava">Odjavite se</a>
                </div>
                <div class="panel-body">
                    <table class="table table-borderless table-responsive">
                        <thead>
                            <tr>
                                <td>Proizvod</td>
                                <td>Vrijeme kupnje</td>
                                <td>Način plaćanja</td>
                            </tr>
                        </thead>  
                        <tbody>
                        <c:forEach items="${kupnje}" var="kupnja">
                            <tr>
                                <td>${kupnja.nazivProizvoda}</td>
                                <td>${kupnja.vrijemeKupnje}</td>
                                <td>${kupnja.nacinPlacanja}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
