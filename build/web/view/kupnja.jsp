<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/stilovi.css">
        <link rel="stylesheet"  href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <title>Kupnja</title>
    </head>
    <body>
        <div>
            <h1 class="text-center">Odabrani proizvodi</h1>
        </div>
        <form action="potvrda" method="post">
            <div class="container-fluid padding-top">
                <div class="navigacija">
                    <nav class="navbar navbar-default navigacija">
                        <div class="container-fluid">
                            <div class="collapse navbar-collapse">
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
                    <div class="panel-heading headingKupnja">
                        Proizvodi za kupnju
                    </div>
                    <div class="panel-body">
                        <table class="table table-borderless table-responsive">
                            <tr class="header">
                                <th>Naziv</th>
                                <th>Detalji</th>
                                <th>Cijena</th>
                            </tr>
                            <c:forEach var="stavka" items="${kosarica.stavke}" varStatus="iter">

                                <c:set var="proizvod" value="${stavka.proizvod}"/>

                                <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                                    <td>${proizvod.naziv}</td>

                                    <td>
                                        ${proizvod.detalji}
                                    </td>
                                    <td>
                                        ${stavka.ukupnaCijena} kuna
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td></td>
                                <td></td>
                                <td><label>Ukupno: ${kosarica.ukupnaCijena} kuna</label></td>
                            </tr>
                        </table>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading headingNacinPlacanja">
                        Način plaćanja
                    </div>
                    <div class="panel-body">
                        <table class="table table-borderless table-responsive">
                            <tr>
                                <td><input type="radio" name="nacinPlacanja" value="Gotovina">Gotovina - pouzeće</td>
                            </tr>
                            <tr>
                                <td><input type="radio" name="nacinPlacanja" value="PayPal">Paypal</td>
                            </tr>
                            <tr>
                                <td><input type="submit" class="btn btn-sm btnKupi" value="Kupi"></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
