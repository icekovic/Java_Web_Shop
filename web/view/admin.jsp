<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/stilovi.css">
        <link rel="stylesheet"  href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <title>Admin stranica</title>
    </head>
    <body>
        <div class="container-fluid padding-top">
            <div class="container padding-top">
                <div class="panel panel-default">
                    <form action="admin" method="post">
                        <div class="panel-heading headingPretraga">
                            Pretraga
                        </div>
                        <div class="panel-body">
                            <div class="col-md-10 col-md-offset-2">
                                <div class="col-md-6 col-md-offset-1">
                                    <table class="table table-borderless table-responsive">                                  
                                        <tr>
                                            <td>Ime</td>
                                            <td><input type="text" class="form-control" name="imePretraga" id="imePretraga" autofocus="true"></td>
                                        </tr>
                                        <tr>
                                            <td>Prezime</td>
                                            <td><input type="text" class="form-control" name="prezimePretraga" id="prezimePretraga"></td>
                                        </tr>
                                        <tr>
                                            <td>Vrijeme kupnje</td>
                                            <td><input type="text" class="form-control" name="vrijemeKupnjePretraga" id="vrijemeKupnjePretraga"></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td><button  type="submit" class="btn btn-success btnPrijava">Pretraži</button></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>       
                    </form>

                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading headingAdmin">
                    Sve kupnje
                    <a href="odjava" class="lblOdjava">Odjavite se</a>
                </div>
                <div class="panel-body">
                    <table class="table table-borderless table-responsive">
                        <thead>
                            <tr>
                                <td>Ime</td>
                                <td>Prezime</td>
                                <td>Vrijeme kupnje</td>
                                <td>Proizvod</td>
                                <td>Cijena</td>
                                <td>Način plaćanja</td>
                            </tr>
                        </thead>
                        <tbody
                            <c:forEach items="${sveKupnje}" var="kupnja">
                                <tr>
                                    <td>${kupnja.imeKupca}</td>
                                    <td>${kupnja.prezimeKupca}</td>
                                    <td>${kupnja.vrijemeKupnje}</td>
                                    <td>${kupnja.nazivProizvoda}</td>
                                    <td>${kupnja.cijenaProizvoda} kuna</td>
                                    <td>${kupnja.nacinPlacanja}</td>
                                </tr>
                            </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
