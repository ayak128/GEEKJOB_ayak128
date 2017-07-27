/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
// Humanクラスの宣言
class Human {

    // フィールド変数nameとageを宣言
    public String name = "";
    public int age = 0;

    // 引数n、aに指定された値を上記のふたつのフィールド変数にセットするメソッド
    public void setHuman(String n, int a) {  // ()の中は引数n、a

        // 引数に指定されたn、aと、フィールド変数name、ageを区別するため
        // フィールド変数name、ageを「this.name」「this.age」と指定
        this.name = n;  // 引数n
        this.age = a;   // 引数a
    }

    public void prtHuman() {
        // System～を使うとブラウザ上には表示されない
        // ↓のGlassFish Server内に出る
        System.out.print(name + "です。年齢は" + age + "です。");
    }
}
// class1というクラス
public class class1 extends HttpServlet {

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
        //↑class1内ではoutの概念?があるが、Humanクラスの中にはないから使えない
        // class1とHumanは互いに中身を知らない
        
            // Humanのインスタンスを生成。Humanのできることをclass1内でもできる
            Human hito = new Human();
            hito.setHuman("片桐", 27);
            hito.prtHuman();
        }
    }

    /* TODO output your page here. You may use following sample code. */
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
