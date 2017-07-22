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

import java.util.Date;  //占いの処理
import java.util.Random;  //占いの処理
import javax.servlet.RequestDispatcher;  //JSPを呼び出すため
import org.camp.servlet.ResultData;  //作成したJavaBeans


/**
 *
 * @author guest1Day
 */
public class FortuneTelling extends HttpServlet {

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
        //型 [] 変数名 = { 情報1,情報2 };の形式は、型 変数名 []　でもよい
        String luckList [] = {"大吉","中吉","吉","半吉","末小吉","凶","小凶","半凶","末凶","凶","大凶"};
        
        //乱数を生成　Randomクラスを利用
        Random rand = new Random();
        //乱数取得
        Integer index = rand.nextInt(luckList.length);
        //「http://localhost:8080/challenge10/FortuneTelling」でアクセス
        
        //占い結果を持ちまわるため、作成したResultデータのインスタンスを生成
        ResultData data = new ResultData();
        //ResultDataクラスのsetterを利用し、実施日付と運勢を記録
        data.setD(new Date());  
        data.setLuck(luckList[index]);
        //request.setAttributeメソッドで、占い結果をリクエストスコープに登録する
        request.setAttribute("DATA",data);
        //スライドのように(result)と書かなくても、下記のように書けばよい
        //「WEB-INFの中のJSPフォルダの中のFortuneTelling.jsp」という意味
        //(result)にするなら、「final String result = "WEB-INF/jsp/FortuneTellingResult.jsp";」を
        //↓の行より前に書かないといけない
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/FortuneTellingResult.jsp");
        //RequestDispatcherクラス利用して、ServletクラスからJSPへ処理を移行する
        rd.forward(request,response);
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FortuneTelling1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>今日のあなたの運勢は  "+luckList[index]+" </h1>");
            out.println("</body>");
            out.println("</html>");
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
