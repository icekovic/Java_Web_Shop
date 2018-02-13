<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/stilovi.css">
        <link rel="stylesheet"  href="bootstrap/css/bootstrap.min.css">
        <title>Registracija</title>
    </head>
    <body>
        <form action="uspjesnaRegistracija" method="post">
            <div class="container padding-top">
                <div class="col-md-offset-5 padding-bottom-20">
                    <div>
                        <a href="home" class="btn btn-default btnKategorije linkKategorije">Naslovnica</a>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading headingRegistracija">
                        Registracija
                    </div>
                    <div class="panel-body">
                        <div class="col-md-10 col-md-offset-2">
                            <div class="col-md-6 col-md-offset-1">
                                <table class="table table-borderless table-responsive">
                                    <tr>
                                        <td class="">Ime</td>
                                        <td><input type="text" class="form-control" required="true" name="ime" id="ime" autofocus="true" placeholder="Ime..."></td>
                                    </tr>
                                    <tr>
                                        <td>Prezime</td>
                                        <td><input type="text" class="form-control" required="true" name="prezime" id="prezime" placeholder="Prezime..."></td>
                                    </tr>
                                    <tr>
                                        <td>Email</td>
                                        <td><input type="text" class="form-control" required="true" name="email" id="email" placeholder="Email..."></td>
                                    </tr>
                                    <tr>
                                        <td>Adresa</td>
                                        <td><input type="text" class="form-control" required="true" name="adresa" id="adresa" placeholder="Adresa..."></td>
                                    </tr>
                                    <tr>
                                        <td>Korisničko ime</td>
                                        <td><input type="text" class="form-control" required="true" name="korisnickoIme" id="korisnickoIme" placeholder="Korisničko ime..."></td>
                                    </tr>
                                    <tr>
                                        <td>Lozinka</td>
                                        <td><input type="password" class="form-control" required="true" name="lozinka" id="lozinka" placeholder="Lozinka..."></td>
                                    </tr>
                                    <tr>
                                        <td>Ponovite lozinku</td>
                                        <td>
                                            <input type="password" class="form-control" required="true" onchange="provjeraLozinke();" name="ponovljenaLozinka" id="ponovljenaLozinka" placeholder="Ponovite lozinku...">
                                            <label id="lblProvjeraLozinke" class="label label-danger lblProvjeraLozinke hidden">Lozinke se ne poklapaju!</label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><button  type="submit" class="btn btn-success btnRegistracija">Registriraj se</button></td>
                                    </tr>                                  
                                </table>
                            </div>
                        </div>
                    </div>                   
                </div>
            </div>
        </form>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function ()
            {
                $('#ponovljenaLozinka').keyup(function ()
                {
                    if($(this).val() === $('#lozinka').val())
                    {
                        $('#lblProvjeraLozinke').addClass('hidden');
                    }
                    else
                    {
                        $('#lblProvjeraLozinke').removeClass('hidden');
                    }
                });
            });
        </script>
    </body>
</html>
