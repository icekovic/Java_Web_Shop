package kontroler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Kupac;
import util.Repozitorij;

public class UspjesnaRegistracijaController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String email = request.getParameter("email");
        String adresa = request.getParameter("adresa");
        String korisnickoIme = request.getParameter("korisnickoIme");
        String lozinka = request.getParameter("lozinka");
        
        Kupac kupac = new Kupac();
        kupac.setIme(ime);
        kupac.setPrezime(prezime);
        kupac.setEmail(email);
        kupac.setAdresa(adresa);
        kupac.setKorisnickoIme(korisnickoIme);
        kupac.setLozinka(lozinka);
        
        Repozitorij.umetniKupca(kupac);
        session.setAttribute("kupac", kupac);
        request.getRequestDispatcher("view/uspjesnaRegistracija.jsp").forward(request, response);
        
    }
}
