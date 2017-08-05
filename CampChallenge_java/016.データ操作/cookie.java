/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class cookie extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            // 当日の日時で情報作成
            Date now = new Date();
            // SimpleDateFormatクラスの作成（日付書式）
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // nowの中身を表示
            out.print("現在の時刻は、" + sdf.format(now) + "　です。<br>");
            
            // Cookieの作成（情報の書き込み）
            // データの名前はLastlogin、中身は当日の日時
            // cookieは利用者のPCに保存される
            Cookie c = new Cookie("Lastlogin", sdf.format(now));
            // Cookieに反映
            response.addCookie(c);
            // Cookieの中身を取得
            // getCookiesメソッドはCookieクラスの配列を返却
            // 自分が利用したい情報を探す
            // addCookieとgetCokieは連動していない（タイムラグがある）から、
            // 初回のアクセスでは最終ログインが出てこない
            Cookie[] cs = request.getCookies();

            // csとnullが等しくないなら
            if (cs != null) {
                // iがcsの要素数分より小さいうちは繰り返す
                for (int i = 0; i < cs.length; i++) {
                    // csのi番目　Lastloginというクッキー情報を探している
                    // Cookieクラスで用意されているメソッドを確認
                    // getName()は、Cookieの名前を返す
                    // getValue()は、Cookieの値を返す
                    // 返した名前と探している名前が一緒ならCookieの中身を返す
                    if (cs[i].getName().equals("Lastlogin")) {
                        out.print("最後ログインは、" + cs[i].getValue() + "　です。");
                        break;
                    }
                }
            }
        }
    }


    /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet cookie</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet cookie at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
