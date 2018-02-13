<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Razina prijave</title>
        <link rel="stylesheet" href="bootstrap/css/stilovi.css">
        <link rel="stylesheet"  href="bootstrap/css/bootstrap.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet'  type='text/css'>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid padding-top">
            <div class="col-md-10 col-md-offset-4">
                <c:if test="${not empty korisnikPostoji && korisnikPostoji != null}">
                    Prijavljeni ste kao korisnik <a href="home" class="btn btn-default btnPrijavaKupac">Započnite kupovinu</a>
                </c:if>
                <c:if test="${not empty adminPostoji && adminPostoji != null}">
                    Prijavljeni ste kao admin <a href="admin" class="btn btn-default btnPrijavaAdmin">Pregledajte sve kupnje</a>
                </c:if>
            </div>
        </div>
    </body>
</html>