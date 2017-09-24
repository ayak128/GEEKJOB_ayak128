package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {

            HttpSession hs = request.getSession();

            // リクエストパラメータの文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");

            // 修正）アクセスルートのチェック
            String accesschk = request.getParameter("ac");
            if (accesschk == null || (Integer) hs.getAttribute("ac") != Integer.parseInt(accesschk)) {
                throw new Exception("不正なアクセスです");
            }

            // 更新画面での入力情報を取得してUserDataBeansに格納
            UserDataBeans udbs = new UserDataBeans();

            udbs.setName(request.getParameter("name"));
            udbs.setYear(request.getParameter("year"));
            udbs.setMonth(request.getParameter("month"));
            udbs.setDay(request.getParameter("day"));
            udbs.setType(request.getParameter("type"));
            udbs.setTell(request.getParameter("tell"));
            udbs.setComment(request.getParameter("comment"));

            // 格納されている詳細情報の中からユーザーIDを取り出し、変数IDに代入
            UserDataDTO udd = (UserDataDTO) hs.getAttribute("resultDetailData");
            int ID = udd.getUserID();

            // DTOオブジェクトにマッピング。DB専用のパラメータに変換
            // ID以外の情報が入ってるudbsと、IDが入ってるupdateDataを一緒に
            UserDataDTO updateData = new UserDataDTO();
            updateData.setUserID(ID);
            udbs.UD2DTOMapping(updateData);

            // 更新したユーザー情報をresultUpdateDataに格納
            // 次の画面で更新結果を表示させるだけなのでリクエストスコープに格納
            UserDataDTO resultUpdateData = UserDataDAO.getInstance().update(updateData);
            request.setAttribute("resultUpdateData", resultUpdateData);

            // ID検索によって導き出された情報をresultDetailDataに格納
            // 次の画面から詳細画面に戻るとき使う
            UserDataDTO resultDetailData = UserDataDAO.getInstance().searchByID(updateData);
            hs.setAttribute("resultDetailData", resultDetailData);

            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
