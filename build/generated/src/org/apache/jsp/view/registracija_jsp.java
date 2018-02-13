package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registracija_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/stilovi.css\">\n");
      out.write("        <link rel=\"stylesheet\"  href=\"bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <title>Registracija</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"uspjesnaRegistracija\" method=\"post\">\n");
      out.write("            <div class=\"container padding-top\">\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading headingRegistracija\">\n");
      out.write("                        Registracija\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body col-lg-4 col-md-4 col-xs-6\">\n");
      out.write("                        <table class=\"table table-borderless tablicaRegistracija\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Ime</td>\n");
      out.write("                                <td><input type=\"text\" class=\"form-control\" name=\"ime\" id=\"ime\" autofocus=\"true\" placeholder=\"Ime...\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Prezime</td>\n");
      out.write("                                <td><input type=\"text\" class=\"form-control\" name=\"prezime\" id=\"prezime\" autofocus=\"true\" placeholder=\"Prezime...\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Email</td>\n");
      out.write("                                <td><input type=\"text\" class=\"form-control\" name=\"email\" id=\"email\" autofocus=\"true\" placeholder=\"Email...\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Adresa</td>\n");
      out.write("                                <td><input type=\"text\" class=\"form-control\" name=\"adresa\" id=\"adresa\" autofocus=\"true\" placeholder=\"Adresa...\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Korisničko ime</td>\n");
      out.write("                                <td><input type=\"text\" class=\"form-control\" name=\"korisnickoIme\" id=\"korisnickoIme\" autofocus=\"true\" placeholder=\"Korisničko ime...\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Lozinka</td>\n");
      out.write("                                <td><input type=\"text\" class=\"form-control\" name=\"lozinka\" id=\"lozinka\" autofocus=\"true\" placeholder=\"lozinka...\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Ponovite lozinku</td>\n");
      out.write("                                <td><input type=\"text\" class=\"form-control\" name=\"ponovljenaLozinka\" id=\"ponovljenaLozinka\" autofocus=\"true\" placeholder=\"Ponovite lozinku...\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td><button  type=\"submit\" class=\"btn btn-success\">Registriraj se</button></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
