<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/stilovi.css">
        <link rel="stylesheet"  href="bootstrap/css/bootstrap.min.css">
        <script src="../bootstrap/js/jquery-3.2.1.min.js"></script>
        <title>Proizvodi</title>
    </head>
    <body>
        <div>
            <h1 class="text-center">Popis proizvoda</h1>
        </div>
        <div class="container-fluid padding-top">
            <div class="navigacija">
                <nav class="navbar navbar-default navigacija">
                    <div class="container-fluid">
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <c:if test="${!empty kupac}">
                                    <li class="lblPrijavljenKupac">Prijavljeni ste kao <a href="kupac" class="prijavljenkupac">${kupac.ime} ${kupac.prezime}</a></li>
                                    <li><a href="<c:url value="pregledKosarice"></c:url>">Pregledaj košaricu</a></li>
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

            <div class="row">
                <div class="col-lg-2">
                    <div class="divKategorije">
                        <table class="table table-responsive table-borderless">
                            <c:forEach var="kategorija" items="${kategorije}">
                                <c:choose>
                                    <c:when test="${kategorija.naziv == odabranaKategorija.naziv}">
                                        <div class="categoryButton" id="selectedCategory">
                                            <tr>
                                                <td><a class="btn btn-default odabranaKategorija">${kategorija.naziv}</a></td>                                               
                                            </tr>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td>
                                                <a href="kategorije?${kategorija.idKategorija}" class="btn btn-default sveKategorije">${kategorija.naziv}</a>
                                            </td>                                           
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="col-md-offset-6 padding-bottom-20">
                    <div>
                        <a href="home" class="btn btn-default btnKategorije linkKategorije">Naslovnica</a>
                    </div>
                </div>
                <div class="col-lg-10">
                    <div class="divProizvodi">
                        <div class="panel panel-default">
                            <div class="panel-heading headingProizvodi">
                                ${odabranaKategorija.naziv}
                            </div>
                            <table class="table table-bordered table-responsive">
                                <thead>
                                    <tr>
                                        <td>Naziv</td>
                                        <td>Detalji</td>
                                        <td>Cijena</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${proizvodi}" var="proizvod">
                                        <tr>
                                            <td>${proizvod.naziv}</td>
                                            <td>${proizvod.detalji}</td>
                                            <td>${proizvod.cijena} kuna</td>
                                            <td>
                                                <form action="dodajProizvod" method="post">
                                                    <input type="hidden" name="proizvodId" value="${proizvod.idProizvod}">
                                                    <input type="submit" name="submit" value="Dodaj u košaricu" class="btn btn-sm btnDodajuKosaricu">
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>                           
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
