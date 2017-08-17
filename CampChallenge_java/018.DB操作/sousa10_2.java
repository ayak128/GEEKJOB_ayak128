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
import java.sql.*;

/**
 *
 * @author guest1Day
 */
public class sousa10_2 extends HttpServlet {

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
// profileIDで指定したレコードを削除できるフォームを作成        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            // 文字コード指定
            request.setCharacterEncoding("UTF-8");

            // 情報の取り出し
            // 入力された値（ID）を整数として扱いたいのでString→intに型変換
            int pid = Integer.parseInt(request.getParameter("id"));
            out.print("今回、削除するのは【profilesID：" + pid + "】です。<br><br>");

            // 接続確認
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KATAGIRI_db", "AYAKATAGIRI", "ayak128");
            if (db_con != null) {
                out.print("接続成功しました。<br><br>");
            }

            // 入力された値（pid）を削除するよう?の中に指定
            db_st = db_con.prepareStatement("delete from profiles where profilesID = ?");
            db_st.setInt(1, pid);
            
            // deleteしたのでexecuteUpdateする　更新した数の確認
            int num = db_st.executeUpdate();
            out.print("今回削除したのは" + num + "人分の情報です。<br><br>");

            // SQL文の実行
            db_st = db_con.prepareStatement("select*from profiles");
            db_data = db_st.executeQuery();

            // SQL実行結果の表示　変数ではなく、カラム名を記述する
            while (db_data.next()) {
                out.print("現在、登録されている情報は以下のとおりです。<br><br>");
                out.print("ID：" + db_data.getInt("profilesID") + "<br>");
                out.print("名前：" + db_data.getString("name") + "<br>");
                out.print("電話番号：" + db_data.getString("tel") + "<br>");
                out.print("年齢：" + db_data.getInt("age") + "<br>");
                out.print("誕生日：" + db_data.getString("birthday") + "<br><br>");
            }
            
            db_con.close();
            db_st.close();
            db_data.close();
            
        } catch (SQLException e_sql) {
            System.out.println(e_sql.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                db_con.close();
            } catch (Exception e_con) {
                System.out.println(e_con.getMessage());
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
