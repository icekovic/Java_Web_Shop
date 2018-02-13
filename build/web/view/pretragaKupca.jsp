<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/stilovi.css">
        <link rel="stylesheet"  href="bootstrap/css/bootstrap.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet'  type='text/css'>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <title>Pretraga</title>
    </head>
    <body>
        <div class="container-fluid padding-top">
            <div class="panel panel-default">
                <div class="panel-heading headingAdmin">
                    Kupac ${imePretraga} ${prezimePretraga} ima slijedeće kupnje
                    <a href="prijava" class="lblOdjava">Odjavite se</a>
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
                    <c:forEach items="${pretragaPoKupcu}" var="pretraga">
                        <tr>
                            <td>${pretraga.imeKupca}</td>
                            <td>${pretraga.prezimeKupca}</td>
                            <td>${pretraga.vrijemeKupnje}</td>
                            <td>${pretraga.nazivProizvoda}</td>
                            <td>${pretraga.cijenaProizvoda} kuna</td>
                            <td>${pretraga.nacinPlacanja}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
