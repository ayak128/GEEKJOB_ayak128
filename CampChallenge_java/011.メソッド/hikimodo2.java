/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class hikimodo2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList<ArrayList> myprofile() {
        ArrayList<String> data1 = new ArrayList<String>();  //Stringを入れられるArrayList
        ArrayList<String> data2 = new ArrayList<String>();
        ArrayList<String> data3 = new ArrayList<String>();

        ArrayList<ArrayList> prof = new ArrayList<ArrayList>();    //ArrayListを入れられるArrayList 
        data1.add("ID1");
        data1.add("片桐");
        data1.add("1990.1.28");
        data1.add(null);  //data1.set(4,null);→何も入れていないところを更新はできない
        prof.add(data1);  //profの0番目にArrayListの↑のdata1を追加
        //prof[0] = data1 {ID、名前、生年月日、住所}

        data2.add("ID2");
        data2.add("黒澤");
        data2.add("1990.1.29");
        data2.add("埼玉県");
        prof.add(data2);  //profの1番目にArrayListの↑のdata2を追加
        //prof[1] = data2 {ID、名前、生年月日、住所}

        data3.add("ID3");
        data3.add("田中");
        data3.add("1990.1.30");
        data3.add("千葉県");
        prof.add(data3);  //profの2番目にArrayListの↑のdata3を追加
        //prof[2] = data3 {ID、名前、生年月日、住所}

        return prof;  //profの内容をメソッドに返す
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            ArrayList<ArrayList> mozi = myprofile();

            // 固定長は長さが決まっているから.lengthでよいが、
            // ArrayListは可変長なのでsize()
            // iがmoziの要素数3（人間の数）より小さいうちは繰り返す
            for (int i = 0; i < mozi.size(); i++) {

                // ひとり分の情報を取り出す（getでmoziのi番目を取得）
                // 取得した要素をoneDataに代入
                // oneDataの要素数は4（ID、名前、生年月日、住所）
                // 配列の中身（文字）を入れるからString
                ArrayList<String> oneData = mozi.get(i);
                
                // ひとり分の情報を回す
                // jが1から始まり（0はIDなので表示させない）、
                // oneDataの要素数4より小さいうちは繰り返す
                for (int j = 1; j < oneData.size(); j++) {
                    // oneDataの要素=nullを満たしたらcontinueする
                    if (oneData.get(j) == null) {
                        continue;
                    // nullじゃなければoneDataのj番目を表示
                    } else {
                        out.print(oneData.get(j) + "<br>");
                    }  // continueからここに飛んでくる。ループの先頭に戻る

                }
            }
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
