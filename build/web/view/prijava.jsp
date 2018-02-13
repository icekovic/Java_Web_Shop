<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/stilovi.css">
        <link rel="stylesheet"  href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <title>Prijava</title>
    </head>
    <body>
        <form action="provjeraRazinePrijave" method="post" onsubmit="return validirajFormu(this);">
            <div class="container padding-top">
                <div class="col-md-offset-5 padding-bottom-20">
                    <div>
                        <a href="home" class="btn btn-default btnKategorije linkKategorije">Naslovnica</a>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading headingRegistracija">
                        Prijava
                    </div>
                    <div class="panel-body">
                        <div class="col-md-10 col-md-offset-2">
                            <div class="col-md-6 col-md-offset-1">
                                <table class="table table-borderless table-responsive">                                  
                                    <tr>
                                        <td>Korisničko ime</td>
                                        <td>
                                            <input type="text" class="form-control" name="korisnickoIme" id="korisnickoIme" required="true" autofocus="true" placeholder="Korisničko ime...">
                                            <div id="korisnickoImeGreska"></div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Lozinka</td>
                                        <td>
                                            <input type="password" class="form-control" name="lozinka" required="true" id="lozinka" placeholder="Lozinka...">
                                            <div id="lozinkaGreska"></div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><button  type="submit" class="btn btn-success btnPrijava">Prijavi se</button></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>                   
                </div>
            </div>
        </form>
    </body>
</html>