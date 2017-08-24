/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 *
 * @author guest1Day
 */
public class sousa13_3 extends HttpServlet {

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

// 登録情報一覧
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KATAGIRI_db", "AYAKATAGIRI", "ayak128");

            // 全件取得する際、idの番号順になるよう実行
            db_st = db_con.prepareStatement("select*from syouhinlog order by id");
            db_data = db_st.executeQuery();
            
            out.print("登録商品一覧です。<br><br>品番順に表示します。<br><br>");
            
            boolean tf = false;
            
            while (db_data.next()) {
                out.print("品番：" + db_data.getInt("id") + "<br>");
                out.print("商品名：" + db_data.getString("name") + "<br>");
                out.print("個数：" + db_data.getInt("number") + "<br>");
                out.print("価格：" + db_data.getInt("price") + "<br><br>");
                tf = true;
            }
            
            if(tf == false){
            out.print("現在、登録されている商品はありません。<br><br>");
            }

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
            db_data.close();
            
        } catch (SQLException e_sql) {
            System.out.println("接続時にエラーが発生しました。" + e_sql.toString());
        } catch (Exception e) {
            System.out.println("エラーが発生しました。" + e.toString());
        } finally {
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
                }
            }
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
