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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 *
 * @author guest1Day
 */
public class sousa13_4 extends HttpServlet {

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

            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            //「getSession」でセッションの取り出し
            HttpSession session = request.getSession();
            //「setAttribute」で初期値の設定（名前：check　値：null）
            session.setAttribute("check", null);

            // ServletContextの取り出し　サーブレットに必要なオブジェクトなどを取り出したりする
            ServletContext context = this.getServletContext();
            // 「getRequestDispatcher」というメソッドを使い、
            // 「RequestDispatcher」というクラスのインスタンスを取り出す
            // ページの移動を管理するオブジェクト
            // サーブレットでページを移動する場合は、指定のページに移動するための
            // RequestDispatcherインスタンスを取得する
            RequestDispatcher dispatcher = context.getRequestDispatcher("/sousa13-1.jsp");

            ServletContext context2 = this.getServletContext();
            RequestDispatcher dispatcher2 = context.getRequestDispatcher("/sousa13-2.jsp");

            String name = request.getParameter("name");
            String user = request.getParameter("userID");
            String pass = request.getParameter("password");

            Class.forName("com.mysql.jdbc.Driver");
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KATAGIRI_db", "AYAKATAGIRI", "ayak128");

            // 入力フォームが空文字なら、checkの中がnullから「kara」という文字になり、
            // 入力フォームへ移動（ログイン失敗）
            if (name.equals("") || user.equals("") || pass.equals("")) {
                session.setAttribute("check", "kara");
                // 取り出したRequestDispatcherの「forward」メソッドを実行することでページの移動を実行
                // このとき、requestとresponseを引数に渡す
                // これでクライアント側では、サーブレットから指定のJSPページに自動的に移動する
                // つまり、未入力の内容があれば最初のページに戻る
                dispatcher.forward(request, response);

            } else {
                db_st = db_con.prepareStatement("select*from userlog where name = ? and userID = ? and password = ?");
                db_st.setString(1, name);
                db_st.setString(2, user);
                db_st.setString(3, pass);

                db_data = db_st.executeQuery();

                boolean tf = false;

                // SQLの実行結果を取り出し、データがある限り取得
                // 下記は、データがある→「tf = true」→名前の情報をセッションに持たせて
                // 商品情報登録ページに移動（ログイン成功）
                while (db_data.next()) {
                    tf = true;
                    session.setAttribute("check", request.getParameter("name"));  
                    dispatcher2.forward(request, response);
                }
                // 入力内容が空ではないが、DB内で検索した結果見つからない場合、
                // checkの中がnullから「mozi」になり、入力フォームへ移動（ログイン失敗）
                if (tf == false) {
                    session.setAttribute("check", "mozi");
                    dispatcher.forward(request, response);
                }
            }

            db_con.close();
            db_st.close();
            db_data.close();

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
