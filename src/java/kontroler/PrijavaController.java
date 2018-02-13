package kontroler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrijavaController extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userPath = request.getServletPath();
        
        if(userPath.equals("/prijava") || userPath.equals("/kupac") || userPath.equals("/admin"))
        {
            userPath = "/prijava";
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
        
    }
}
