<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <title>Informatika.net</title>
        <link rel="stylesheet" href="bootstrap/css/stilovi.css">
        <link rel="stylesheet"  href="bootstrap/css/bootstrap.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet'  type='text/css'>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid padding-top">
            <div>
                <h1 class="text-center">Informatika.net</h1>
            </div>
            <div>
                <nav class="navbar navbar-default navigacija">
                    <div class="container-fluid">
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-right">
                                <c:if test="${!empty kupac}">
                                    <li class="lblPrijavljenKupac">Prijavljeni ste kao <a href="kupac" class="prijavljenkupac">${sessionScope.kupac.ime} ${sessionScope.kupac.prezime}</a></li>
                                    <li><a href="pregledKosarice">Pregledaj košaricu</a></li>
                                </c:if>
                                <c:if test="${empty kupac}">
                                    <li><a href="registracija">Registrirajte se</a></li>
                                    <li><a href="prijava">Prijavite se</a></li>
                                    <li><a href="pregledKosarice">Pregledaj košaricu</a></li>
                                </c:if>                               
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <c:forEach items="${kategorije}" var="kategorija">
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div>
                                <img src="${initParam.slikeKategorije}${kategorija.naziv}.png" alt="${kategorija.naziv}"> 
                            </div>
                            <div class="caption">
                                <h3>${kategorija.naziv}</h3>
                                <p><a href="kategorije?${kategorija.idKategorija}" class="btn btn-default btnPregledProizvoda" role="button">Klikni za pregled proizvoda</a></p>
                            </div>
                        </div> 
                    </c:forEach>
                </div>
            </div>
        </div>           
    </body>
</html>