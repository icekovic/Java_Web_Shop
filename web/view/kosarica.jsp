<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/stilovi.css">
        <link rel="stylesheet"  href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <title>Košarica</title>
    </head>
    <body>
        <div>
            <h1 class="text-center">Košarica</h1>
        </div>
        <div class="container-fluid padding-top">
            <div class="navigacija">
                <nav class="navbar navbar-default navigacija">
                    <div class="container-fluid">
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <c:if test="${!empty kupac}">
                                    <li class="lblPrijavljenKupac">Prijavljeni ste kao <a href="kupac" class="prijavljenkupac">${kupac.ime} ${kupac.prezime}</a></li>
                                    </c:if>
                                    <c:if test="${empty kupac}">
                                    <li><a href="registracija">Registrirajte se</a></li>
                                    <li><a href="prijava">Prijavite se</a></li>
                                    </c:if>
                                <li role="presentation">
                                    <c:if test="${!empty kosarica && kosarica.kolicina != 0}">                  
                                        <c:url var="url" value="pregledKosarice">
                                            <c:param name="isprazni" value="true"/>
                                        </c:url>

                                        <a href="${url}">Isprazni košaricu</a>
                                    </c:if>

                                    <c:set var="value">
                                        <c:choose>
                                            <c:when test="${!empty odabranaKategorija}">
                                                kategorije
                                            </c:when>
                                            <c:otherwise>
                                                home
                                            </c:otherwise>
                                        </c:choose>
                                    </c:set>
                                </li>
                                <li role="presentation">
                                    <c:url var="url" value="${value}"/>
                                    <a href="${url}">Nastavak kupnje</a>
                                </li>
                                <li role="presentation">
                                    <c:if test="${!empty kosarica && kosarica.kolicina != 0}">
                                        <a href="<c:url value='kupnja'/>" class="bubble hMargin">Plaćanje</a>
                                    </c:if> 
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>

            <div class="col-md-offset-5 padding-bottom-20">
                <div>
                    <a href="home" class="btn btn-default btnKategorije linkKategorije">Naslovnica</a>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading headingKosarica">
                    Košarica
                </div>
                <div class="panel-body">
                    <c:if test="${!empty kosarica && kosarica.kolicina != 0}">
                        <table class="table table-borderless table-responsive">
                            <thead>
                                <tr class="header">
                                    <th>Naziv</th>
                                    <th>Cijena</th>
                                    <th>Detalji</th>
                                    <th>Količina</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="stavka" items="${kosarica.stavke}" varStatus="iter">

                                    <c:set var="proizvod" value="${stavka.proizvod}"/>

                                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                                        <td>${proizvod.naziv}</td>

                                        <td>
                                            ${stavka.ukupnaCijena} kuna
                                        </td>
                                        <td>
                                            ${proizvod.detalji}
                                        </td>

                                        <td>
                                            <form action="azurirajKosaricu" method="post">
                                                <input type="hidden" name="proizvodId" value="${proizvod.idProizvod}">
                                                <input type="text" maxlength="2" size="2" value="${stavka.kolicina}" name="kolicina" style="margin:5px">
                                                <input type="submit" name="submit" value="Ažuriraj" class="btn btn-sm btnAzurirajKolicinu">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table> 
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
