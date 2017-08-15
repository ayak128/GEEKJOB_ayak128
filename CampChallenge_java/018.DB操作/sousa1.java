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

// データベース操作に利用するクラスをインポート
import java.sql.*;

/**
 *
 * @author guest1Day
 */
public class sousa1 extends HttpServlet {

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

            // Class.forNameメソッドを利用し、libフォルダにあるMysql用のJDBCドライバのインスタンスを生成
            // このインスタンス生成と同時にDriverManagerにセットされる
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // DriverManagerのgetConnectionメソッドで、DBへの接続を取得
            // 接続情報はConnectionクラスとして返却されるため、Connectionクラスの変数（db_con）で受ける
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KATAGIRI_db", "AYAKATAGIRI", "ayak128");

            // SQL文を実行するためにpreparedStatementを取得
            // ConnectionのpreparedStatementメソッドにSQL文を渡す
            // このときSQL文の中に条件となる値の代わりに「?」を配置する
            // さらにpreparedStatementメソッドの戻り値を受け取る
            db_st = db_con.prepareStatement("select * from user where age = ?");
            // preparedStatementメソッドから受け取ったPreparedStatementに対し、
            //「?」部分に適用する情報を設定していく（setIntで整数を設定）
            // (1,30)→1番目の「?」に整数を設定という意味
            // age=?なので、ageが30のデータを取得→田中実　(1,37)にすれば鈴木茂
            db_st.setInt(1, 30);

            // PreparedStatementのexecuteQueryメソッドを実行
            //「?」が実際の値に置き換わったSQL文がデータベースに実行される
            // executeQueryの場合、実行結果をResultSetとして返却してくれる。受け取る
            db_data = db_st.executeQuery();
            // ResultSetからSQLの実行結果を取り出し表示
            // nextメソッドでデータの有無を確認し、while文でデータがある限り取得し続ける
            // getStringメソッドは、1行のデータからnameカラムの情報を文字列として取得している
            while (db_data.next()) {
                out.print("名前：" + db_data.getString("name") + "<br>");
                out.print("ID："+ db_data.getInt("userID")+"<br>");
                out.print("誕生日："+ db_data.getString("birthday")+"<br>");
            }

            // データベースへの同時接続数は制限があるため、操作が完了して使わなくなったものは必ずclose
            db_data.close();
            db_st.close();
            db_con.close();

            // 例外クラス SQLException 発生した例外に応じてcatchの{}で処理を分ける
            // JDBCを使用してSQLを使用した際に問題が発生するとSQLExceptionが投げられる
        } catch (SQLException e_sql) {
            System.out.println("接続時にエラーが発生しました。" + e_sql.toString());
            // Exceptionは（SQLExceptionを含む）全ての例外が出たとき投げられる
            // Exceptionを一番上に書くと何が原因かわからなくなるので、SQLExceptionを先に記述する
        } catch (Exception e) {
            System.out.println("エラーが発生しました。"+ e.toString());
        // finallyは例外の有無に関係なく、実施したい処理
        } finally {
            // データベースの操作が開始したあと、closeする前にエラーが発生したら開きっぱなしになって困る
            // db_conの中が空でない（＝開きっぱなし、または使用中）なら、close
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e_con) {  // 全てのエラー（閉められなかった、みたいな）
                    System.out.println(e_con.getMessage());  // getMessageでエラーメッセージを呼び出す
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
