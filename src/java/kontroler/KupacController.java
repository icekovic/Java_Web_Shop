package kontroler;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Kupac;
import model.Kupnja;
import util.Repozitorij;

public class KupacController extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Kupac kupac = (Kupac) session.getAttribute("kupac");
        List<Kupnja> kupnje = Repozitorij.dohvatiKupnjePojedinogKupca(kupac.getIdKupac());
        session.setAttribute("kupnje", kupnje);
        request.getRequestDispatcher("view/profilKupca.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException          
    {
        
    }
}
