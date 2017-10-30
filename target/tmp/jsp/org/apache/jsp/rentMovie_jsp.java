package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;

public final class rentMovie_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("  <title>Added a drink</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      com.example.servletjspdemo.domain.Movie movie = null;
      synchronized (session) {
        movie = (com.example.servletjspdemo.domain.Movie) _jspx_page_context.getAttribute("movie", PageContext.SESSION_SCOPE);
        if (movie == null){
          movie = new com.example.servletjspdemo.domain.Movie();
          _jspx_page_context.setAttribute("movie", movie, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("movie"), request);
      out.write('\r');
      out.write('\n');
      com.example.servletjspdemo.service.StorageService storage = null;
      synchronized (application) {
        storage = (com.example.servletjspdemo.service.StorageService) _jspx_page_context.getAttribute("storage", PageContext.APPLICATION_SCOPE);
        if (storage == null){
          storage = new com.example.servletjspdemo.service.StorageService();
          _jspx_page_context.setAttribute("storage", storage, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");

  String availableMovie[] = request.getParameterValues("buy");
  Double totalPrice = (Double) session.getAttribute("totalPrice");
  if (totalPrice == null) {
    totalPrice = 0.0;
  }
  String basket = (String) session.getAttribute("basket");
  if (basket == null) {
    basket = "";
  }
  for (String chosenMovie : availableMovie) {
    int amount = Integer.parseInt(request.getParameter(chosenMovie));
    if (amount < 1){
      out.println("<h2>Can't buy " + chosenMovie + ", you tried to buy more then in stock or 0</h2>");
      continue;
    }
    Double price = storage.rentMovie(chosenMovie, amount);
    if(price == 0.0){
      out.println("<h2>Can't buy " + chosenMovie + ", you tried to buy more then in stock</h2>");
      continue;
    }
    totalPrice += amount * price;
    basket += amount + " x " + chosenMovie + " " + amount * price + " zł<br/>";
    out.println("<h2>You bought " + amount + " x " + chosenMovie + "</h2>");
  }
  session.setAttribute("basket", basket);
  session.setAttribute("totalPrice", totalPrice);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<p>\r\n");
      out.write("  <a href=\"index.jsp\">Show all drinks</a>\r\n");
      out.write("</p>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
