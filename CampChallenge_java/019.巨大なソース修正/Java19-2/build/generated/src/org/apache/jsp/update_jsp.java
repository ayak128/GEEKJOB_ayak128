package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import jums.UserDataDTO;
import jums.JumsHelper;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("resultDetailData");
    // Date型のbirthdayをyear、month、dayに分ける/Calemderクラスの形成
    Calendar birthday = Calendar.getInstance();
    // Date型をCalemderに変換
    birthday.setTime(udd.getBirthday());

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS変更画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"UpdateResult\" method=\"POST\">\n");
      out.write("            名前:\n");
      out.write("            <!--修正）名前が表示されるよう記述-->\n");
      out.write("            <input type=\"text\" name=\"name\" value=\"");
      out.print( udd.getName());
      out.write("\">\n");
      out.write("            <br><br>\n");
      out.write("\n");
      out.write("            生年月日:　\n");
      out.write("            <!--バラバラにした年月日をそれぞれ表示されるよう記述-->\n");
      out.write("            <select name=\"year\">\n");
      out.write("                <option value=\"\">----</option>\n");
      out.write("                ");
 for (int i = 1950; i <= 2010; i++) {
      out.write("\n");
      out.write("                <option value=\"");
      out.print(i);
      out.write('"');
      out.write(' ');
if (birthday.get(Calendar.YEAR) == i) {
      out.write(" selected ");
}
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </select>年\n");
      out.write("            <select name=\"month\">\n");
      out.write("                <option value=\"\">--</option>\n");
      out.write("                ");
 for (int i = 1; i <= 12; i++) {
      out.write("\n");
      out.write("                <option value=\"");
      out.print(i);
      out.write('"');
      out.write(' ');
if (birthday.get(Calendar.MONTH) == i) {
      out.write(" selected ");
}
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </select>月\n");
      out.write("            <select name=\"day\">\n");
      out.write("                <option value=\"\">--</option>\n");
      out.write("                ");
 for (int i = 1; i <= 31; i++) {
      out.write("\n");
      out.write("                <option value=\"");
      out.print(i);
      out.write('"');
      out.write(' ');
if (birthday.get(Calendar.DAY_OF_MONTH) == i) {
      out.write(" selected ");
}
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </select>日\n");
      out.write("            <br><br>\n");
      out.write("\n");
      out.write("            種別:\n");
      out.write("            <br>\n");
      out.write("            <!--修正）if文の記述-->\n");
      out.write("            ");
 for (int i = 1; i <= 3; i++) {
      out.write("\n");
      out.write("            <input type=\"radio\" name=\"type\" value=\"");
      out.print(i);
      out.write('"');
if (udd.getType() == i) {
                    out.print("checked");
                }
      out.write('>');
      out.print(jh.exTypenum(i));
      out.write("<br>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            電話番号:\n");
      out.write("            <!--修正）電話番号が表示されるよう追記-->\n");
      out.write("            <input type=\"text\" name=\"tell\" value=\"");
      out.print( udd.getTell());
      out.write("\">\n");
      out.write("            <br><br>\n");
      out.write("\n");
      out.write("            自己紹介文\n");
      out.write("            <br>\n");
      out.write("            <!--修正）自己紹介が表示されるよう追記-->\n");
      out.write("            <textarea name=\"comment\" rows=10 cols=50 style=\"resize:none\" wrap=\"hard\">");
      out.print( udd.getComment());
      out.write("</textarea><br><br>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" name=\"btnSubmit\" value=\"更新する\">\n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("        ");
      out.print(jh.home());
      out.write("\n");
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
