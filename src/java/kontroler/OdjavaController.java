package kontroler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OdjavaController extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        if(session.getAttribute("kupac") != null)
        {
            session.removeAttribute("kupac");
            session.removeAttribute("kupacPostoji");
        }
        else if(session.getAttribute("admin") != null)
        {
            session.removeAttribute("admin");
            session.removeAttribute("adminPostoji");
        }
        
        request.getRequestDispatcher("view/odjava.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
    }
}
