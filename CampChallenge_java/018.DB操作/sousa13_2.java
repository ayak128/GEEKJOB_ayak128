/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author guest1Day
 */
public class sousa13_2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
// 入力フォームの内容判断いろいろ
        Connection db_con = null;
        PreparedStatement db_st = null;

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            //「getSession」でセッションの取り出し
            HttpSession session = request.getSession();
            //「setAttribute」で初期値の設定（名前：check　値：最初のJSPで入力された名前）
            session.setAttribute("check", request.getParameter("name"));

            ServletContext context = this.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/sousa13-2.jsp");// 商品登録ページ

            String s_id = request.getParameter("hinban");
            String s_name = request.getParameter("syouhin");
            String s_kazu = request.getParameter("kosuu");
            String s_kane = request.getParameter("kakaku");

            // 商品登録フォームが空文字なら、checkの中がkaraになり商品登録フォームへ移動（登録失敗）
            if (s_id.equals("") || s_name.equals("")
                    || s_kazu.equals("") || s_kane.equals("")) {
                session.setAttribute("check", "kara");
                dispatcher.forward(request, response);
            }
            // 空文字じゃないけど入力があった場合、品番・個数・価格フォームに入力されたのが、
            // 数値か文字かを判断するisNumberメソッドの呼び出し
            // 数値じゃなければ、checkの中がmoziになり商品登録フォームへ移動（登録失敗）
            if (true != isNumber(s_id, s_kazu, s_kane)) {
                session.setAttribute("check", "mozi");
                dispatcher.forward(request, response);
            }

            Class.forName("com.mysql.jdbc.Driver");
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KATAGIRI_db", "AYAKATAGIRI", "ayak128");

            db_st = db_con.prepareStatement("insert into syouhinlog(id,name,number,price)values(?,?,?,?)");
            db_st.setString(1, s_id);
            db_st.setString(2, s_name);
            db_st.setString(3, s_kazu);
            db_st.setString(4, s_kane);

            db_st.executeUpdate();

            out.print("今回、登録した情報は以下の通りです。<br><br>");
            out.print("品番：" + s_id + "<br>");
            out.print("商品名：" + s_name + "<br>");
            out.print("個数：" + s_kazu + "<br>");
            out.print("価格：" + s_kane + "<br><br>");

            // 前の画面に戻る
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<form action=\"sousa13-2.jsp\" method=\"post\">");
            out.println("<input type=\"button\" value=\"前の画面に戻る\" onClick=\"history.back()\"><br><br>");
            out.println("</body>");
            out.println("</html>");
            
            db_con.close();
            db_st.close();
            
        } catch (SQLException e_sql) {
            System.out.println("接続時にエラー発生：" + e_sql.getMessage());
        } catch (Exception e) {
            System.out.println("エラー発生：" + e.getMessage());
        } finally {
            try {
                db_con.close();
            } catch (Exception e_con) {
                System.out.println("エラーが発生：" + e_con.getMessage());
            }
        }
    }

    // 文字としてわたってきた引数num1,2,3を数値に変換できたらtrueを返す
    // 数値に変換できなくて例外発生ならfalseを返す
    // 例）入力内容が「aaa」だと、数値に変換できないからfalseになる
    // NumberFormatExceptionは、文字通り数値のフォーマットに関する例外
    public boolean isNumber(String num1, String num2, String num3) {
        try {
            Integer.parseInt(num1);
            Integer.parseInt(num2);
            Integer.parseInt(num3);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
