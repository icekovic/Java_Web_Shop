package kontroler;

import util.Repozitorij;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Kategorija;
import model.Kosarica;
import model.Kupac;
import model.Proizvod;
import model.Stavka;

public class HomeController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        Kategorija odabranaKategorija;
        List<Proizvod> proizvodi;

        if (userPath.equals(("/home")))
        {
            List<Kategorija> kategorije = Repozitorij.dohvatiKategorije();
            request.setAttribute("kategorije", kategorije);
        }
        else if (userPath.equals(("/kategorije")))
        
        {
            List<Kategorija> kategorije = Repozitorij.dohvatiKategorije();
            session.setAttribute("kategorije", kategorije);

            String kategorijaID = request.getQueryString();
            if (kategorijaID != null)
            {
                odabranaKategorija = Repozitorij.dohvatiKategoriju(Integer.parseInt(kategorijaID));
                proizvodi = Repozitorij.dohvatiProizvode(Integer.parseInt(kategorijaID));
                session.setAttribute("odabranaKategorija", odabranaKategorija);
                session.setAttribute("proizvodi", proizvodi);
            }
        }
        else if (userPath.equals(("/pregledKosarice")))
        {
            String isprazni = request.getParameter("isprazni");
            if ((isprazni != null) && isprazni.equals("true"))
            {
                Kosarica kosarica = (Kosarica) session.getAttribute("kosarica");
                kosarica.isprazniKosaricu();
            }
            userPath = "/kosarica";
        }
        else if (userPath.equals("/kupnja"))
        {        
            if(session.getAttribute("kupac") != null)
            {
                userPath = "/kupnja";
            }
            else
            {
                userPath = "/prijava";
            }
        }
        
        else if(userPath.equals("/registracija"))
        {
            userPath = "/registracija";
        }
        
        String url = "view" + userPath + ".jsp";

        try
        {
            request.getRequestDispatcher(url).forward(request, response);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        Kosarica kosarica = (Kosarica) session.getAttribute("kosarica");

        if (userPath.equals("/dodajProizvod"))
        {
            if (kosarica == null)
            {
                kosarica = new Kosarica();
                session.setAttribute("kosarica", kosarica);
            }
            String proizvodId = request.getParameter("proizvodId");
            if (!proizvodId.isEmpty())
            
            {
                Proizvod proizvod = Repozitorij.dohvatiProizvod(Integer.parseInt(proizvodId));
                kosarica.dodajStavku(proizvod);
            }
            userPath = "/kategorije";
        }
        else if (userPath.equals(("/azurirajKosaricu")))
        {
            String proizvodId = request.getParameter("proizvodId");
            String kolicina = request.getParameter("kolicina");
            Proizvod proizvod = Repozitorij.dohvatiProizvod(Integer.parseInt(proizvodId));
            kosarica.azuriraj(proizvod, kolicina);
            userPath = "/kosarica";
        }
        else if (userPath.equals("/potvrda"))
        {
            if(session.getAttribute("kupac") != null)
            {
                kosarica = (Kosarica) session.getAttribute("kosarica");
                Kupac kupac = (Kupac)  session.getAttribute("kupac");
                String nacinPlacanja = request.getParameter("nacinPlacanja");  
                Timestamp vrijemeKupnje = new Timestamp(System.currentTimeMillis());
                
                int kupnjaId = Repozitorij.umetniKupnju(kupac.getIdKupac(), nacinPlacanja, vrijemeKupnje);
                
                for(Stavka stavka : kosarica.getStavke())
                {
                    Repozitorij.umetniStavku(kupnjaId, stavka.getProizvod().getIdProizvod());
                }
            }
            userPath = "/potvrda";
        }
        
        String url = "view" + userPath + ".jsp";

        try
        {
            request.getRequestDispatcher(url).forward(request, response);
        }
        catch (Exception ex)       
        {
            ex.printStackTrace();
        }
    }
}