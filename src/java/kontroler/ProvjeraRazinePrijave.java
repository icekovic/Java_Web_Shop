package kontroler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Kupac;
import util.Repozitorij;

public class ProvjeraRazinePrijave extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String korisnickoIme = request.getParameter("korisnickoIme");
        String lozinka= request.getParameter("lozinka");
        
        Kupac kupac = Repozitorij.dohvatiKupca(korisnickoIme, lozinka);
        Admin admin = Repozitorij.dohvatiAdminPodatke(korisnickoIme, lozinka);
        boolean korisnikPostoji = Repozitorij.provjeriKorisnickePodatke(korisnickoIme, lozinka);
        boolean adminPostoji = Repozitorij.provjeriAdminPodatke(korisnickoIme, lozinka);
        
        if(adminPostoji)
        {
            session.setAttribute("adminPostoji", adminPostoji);
            session.setAttribute("admin", admin);
            session.removeAttribute("korisnikPostoji");
            session.removeAttribute("kupac");
        }
        
        else if(korisnikPostoji)
        {
            session.setAttribute("korisnikPostoji", korisnikPostoji);
            session.setAttribute("kupac", kupac);
            session.removeAttribute("admin");
            session.removeAttribute("adminPostoji");
        }

        request.getRequestDispatcher("view/provjeraRazinePrijave.jsp").forward(request, response);
    }
}
