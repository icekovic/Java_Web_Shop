package kontroler;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Kupac;
import model.Kupnja;
import util.Repozitorij;

public class AdminController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("kupac");
        List<Kupnja> sveKupnje = Repozitorij.dohvatiSveKupnje();
        session.setAttribute("sveKupnje", sveKupnje);
        request.getRequestDispatcher("view/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   
    {
        HttpSession session = request.getSession();
        String imePretraga = request.getParameter("imePretraga");
        String prezimePretraga = request.getParameter("prezimePretraga");
        List<Kupnja> pretragaPoKupcu = Repozitorij.pretraziPoKupcu(imePretraga, prezimePretraga);
        session.setAttribute("imePretraga", imePretraga);
        session.setAttribute("prezimePretraga", prezimePretraga);
        session.setAttribute("pretragaPoKupcu", pretragaPoKupcu);
        request.getRequestDispatcher("view/pretragaKupca.jsp").forward(request, response);
    }
}
