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
public class sousa12_2 extends HttpServlet {

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

        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            // 文字コード指定
            request.setCharacterEncoding("UTF-8");

            // 情報の取り出し
            // 入力された年齢を文字として扱い部分一致させたいのでintに型変換はしない
            // 数値に%はないので部分一致検索はできない
            String nm = request.getParameter("name");
            String ag = request.getParameter("age");
            String bd = request.getParameter("birthday");

            String you = (nm + "／" + ag + "／" + bd);
            out.print("下記の内容で検索します。<br>【" + you + "】<br><br>");

            if (nm.equals("") && ag.equals("") && bd.equals("")) {
                out.print("検索できません。<br>前の画面に戻り、検索したい内容を入力してください。");
                return;  // void（引数無し）のときは「return;」のみで離脱できる
            }else{
                out.print("お探しの情報は下記の通りです。<br><br>");
            }
            
            Class.forName("com.mysql.jdbc.Driver");
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KATAGIRI_db", "AYAKATAGIRI", "ayak128");

            // 接続確認
            if (db_con != null) {
                out.print("接続成功しました。<br><br>");
            }

            // ?の中に検索したい内容が入るよう変数を指定　複数の情報を更新する場合はカンマで区切る
            // where句　複数条件の指定　andで「両方の条件を満たす」 orなら「どちらかの条件を満たすか」
            db_st = db_con.prepareStatement("select*from profiles where name like ? and age like ? and birthday like ?");
            db_st.setString(1, "%" + nm + "%");
            db_st.setString(2, "%" + ag + "%");
            db_st.setString(3, "%" + bd + "%");

            // ?が置き換わったものSQL文がデータベースに実行される
            db_data = db_st.executeQuery();

            boolean tf = false;

            while (db_data.next()) {
          //      out.print("お探しの情報は以下の通りです。<br>");
                out.print("ID：" + db_data.getInt("profilesID") + "<br>");
                out.print("名前：" + db_data.getString("name") + "<br>");
                out.print("電話番号：" + db_data.getString("tel") + "<br>");
                out.print("年齢：" + db_data.getInt("age") + "<br>");
                out.print("誕生日：" + db_data.getString("birthday") + "<br><br>");
                tf = true;
            }
            if (tf == false) {
                out.print("お探しの情報は見つかりませんでした。");
            }

            db_con.close();
            db_st.close();
            db_data.close();

        } catch (SQLException e_sql) {
            System.out.println(e_sql.getMessage());
        } catch (Exception e) {
            System.out.println("エラーが発生しました。");
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
