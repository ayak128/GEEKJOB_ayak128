/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author guest1Day
 */
public class Blackjack1 extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            // BlackJackを全自動で行い、勝敗を決める
            // 今回のルール：1の値は「1」で固定（11にはならない）
            out.print("BlackJackを開始します。<br><br>");

            // DealerとUserのインスタンス   
            Dealer dealer = new Dealer();
            User user = new User();

            // 手札の配布と合計値の確認
            dealer.setCard(dealer.deal());
            user.setCard(dealer.deal());
            out.print("Dealerに最初配られた手札　" + dealer.myCards + "<br>");
            out.print("合計：" + dealer.open() + "<br><br>");
            out.print("Userに最初配られた手札　" + user.myCards + "<br>");
            out.print("合計：" + user.open() + "<br><br>");

            // Dealerのhitの判断　17以上になるまでhitしないといけない
            // checkSumがtrueならhitメソッドを呼び、1枚引いたカードをDealerに持たせる
            int dealercount = 0;
            while (dealer.checkSum() == true) {
                dealer.setCard(dealer.hit());
                dealercount++;  // hitした数だけカウントをまわす
            }
            if (dealercount == 0) {
                out.print("合計が17以上なので、もうカードは引けません。<br>");
                out.print("Dealerの手札　" + dealer.myCards + "<br>");
                out.print("合計：" + dealer.open() + "<br><br>");
            } else {
                out.print("Dealer hit　" + dealercount + "回<br>");
                out.print("Dealerの手札　" + dealer.myCards + "<br>");
                out.print("合計：" + dealer.open() + "<br><br>");
            }

            // Userのhitの判断　21を超えなければ何度でもhit可能
            // checkSumがtrueならhitメソッドを呼び、1枚引いたカードをuserに持たせる
            int usercount = 0;
            while (user.checkSum() == true) {
                user.setCard(dealer.hit());
                usercount++;  // hitした数だけカウントをまわす
            }
            if (usercount == 0) {
                out.print("Userの手札　" + user.myCards + "<br>");
                out.print("合計：" + user.open() + "<br><br>");
            } else {
                out.print("User hit　" + usercount + "回<br>");
                out.print("Userの手札　" + user.myCards + "<br>");
                out.print("合計：" + user.open() + "<br><br>");
            }
            
            String coment = "";
            String coment2 = "";

            // bustの判断
            if (user.open() >= 22 && dealer.open() >= 22) {
                coment = ("DerlerもUserもBUSTしました。引き分けです。<br>");
                out.print(coment);
                return;
            } else if (user.open() >= 22) {
                coment = ("UserがBUSTしました。Userの負けです。<br>");
                out.print(coment);
                return;
            } else if (dealer.open() >= 22) {
                coment = ("DealerがBUSTしました。Derlerの負けです。<br>");
                out.print(coment);
                return;
            }

            // 勝ち負けの判断
            if (user.open() > dealer.open()) {
                coment2 = ("Userの勝ちです。<br><br>");
            } else if (user.open() == dealer.open()) {
                coment2 = ("引き分けです。<br><br>");
            } else {
                coment2 = ("Userの負けです。<br><br>");
            }
            out.print(coment2);
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
