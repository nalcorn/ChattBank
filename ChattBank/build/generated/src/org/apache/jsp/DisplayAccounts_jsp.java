package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Business.Account;
import Business.Customer;

public final class DisplayAccounts_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!--=======================================================================\n");
      out.write("\n");
      out.write("Class: Java III\n");
      out.write("Quarter: Spring 2016\n");
      out.write("Instructor: Ron Enz\n");
      out.write("Description:  ChattBank Lab 8\n");
      out.write("Due: 01/22/2016\n");
      out.write("Author Nicholas Alcorn\n");
      out.write("\n");
      out.write("\n");
      out.write("By turning in this code, I Pledge:\n");
      out.write("1. That I have completed the programming assignment independently.\n");
      out.write("2. I have not copied the code from a student or any source.\n");
      out.write("3. I have not given my code to any student.\n");
      out.write("\n");
      out.write("-=======================================================================-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"index.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Account Information</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 Customer c1 = (Customer)request.getSession().getAttribute("customer"); 
      out.write("\n");
      out.write("        <h1>Account information for customer ID: ");
      out.print( c1.getCustId() );
      out.write("</h1>\n");
      out.write("        <h1>");
      out.print( c1.getCustFirstName() );
      out.write(' ');
      out.print( c1.getCustLastName() );
      out.write("</h1>\n");
      out.write("        <h2>");
      out.print( c1.getCustAddress() );
      out.write("</h2>\n");
      out.write("        <h2>");
      out.print( c1.getCustEmail() );
      out.write("</h2>\n");
      out.write("        <table id=\"t01\">\n");
      out.write("            ");
 for(int i =1; i<=c1.getCount(); i++){ 
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>Account</td>\n");
      out.write("                <td>");
      out.print( c1.getAcctNoAt(i-1) );
      out.write("</td>\n");
      out.write("            </tr> \n");
      out.write("            <tr>\n");
      out.write("                <td>Type</td>\n");
      out.write("                <td>");
      out.print( c1.getTypeAt(i-1) );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Balance</td>\n");
      out.write("                <td>");
      out.print( c1.getBalanceAt(i-1) );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr><td style=\"line-height:10px;\" colspan=3>&nbsp;</td></tr>\n");
      out.write("            <tr><td style=\"line-height:10px;\" colspan=3>&nbsp;</td></tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </table>\n");
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
