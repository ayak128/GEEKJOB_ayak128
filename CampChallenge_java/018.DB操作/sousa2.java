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
public class sousa2 extends HttpServlet {

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

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KATAGIRI_db", "AYAKATAGIRI", "ayak128");
            if (db_con != null) {
                out.print("接続成功しました。<br>");  // 接続の確認
            }
            
            db_st = db_con.prepareStatement("insert into profiles(profilesID,name,tel,age,birthday)values(?,?,?,?,?)");
            // 前回の課題「テーブルの作成とinsert」で作成したもの↓
            // (profilesID int,name varchar(255),tell varchar(255),age int,birthday date)

            db_st.setInt(1, 6);
            db_st.setString(2, "大谷");
            db_st.setString(3, "333-333-3333");
            db_st.setInt(4, 77);
            db_st.setString(5, "3000-03-03");

            // SQLの実行にはexecuteQueryを実施していたが、INSERT/UPDATE/DELETEの場合はexecuteUpdateを利用する
            // 変数 = PreparedStatement変数.executeUpdate();
            // ↑これを実行するとSQLにより、更新された行数が返却される
            int num = db_st.executeUpdate();
            out.print("更新された行数は" + num + "行です。<br><br>");  // 1行更新したので「1」が表示
            
            // age=77の情報を検索
            db_st = db_con.prepareStatement("select*from profiles where age = 77");
            // SQL文の実行　実行結果をResultSetとして返却
            db_data = db_st.executeQuery();
            
            while (db_data.next()) {
                out.print("ID：" + db_data.getInt("profilesID") + "<br>");
                out.print("名前：" + db_data.getString("name") + "<br>");
                out.print("電話番号：" + db_data.getString("tel") + "<br>");
                out.print("年齢：" + db_data.getInt("age") + "<br>");
                out.print("誕生日：" + db_data.getString("birthday") + "<br><br>");
            }
            // ↑を実行するたびに大谷が増えるが、今回の課題（処理）的には問題無い

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
