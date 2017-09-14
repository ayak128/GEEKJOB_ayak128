package jums;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * insertresultと対応するサーブレット フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 *
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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

        // セッションスタート
        HttpSession hs = request.getSession();
        UserDataBeans udbs = (UserDataBeans) hs.getAttribute("udb");
        request.setCharacterEncoding("UTF-8");

        try {
            String accesschk = request.getParameter("ac");
            if (accesschk == null || (Integer) hs.getAttribute("ac") != Integer.parseInt(accesschk)) {
                throw new Exception("不正なアクセスです");
            }

            // UserDataDTOを利用し、取得した入力情報をuddに格納
            UserDataDTO udd = new UserDataDTO();

            udd.setName(udbs.getName());
            // 年月日を正しく格納するためDateに型変換　SimpleDateFormatの作成
            // 年月日（文字列）をparseで日付に変換し、Date型のbirthdayに代入
            // DTOのsetBirthday()メソッドを利用して、uddにセット
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = sdf.parse(udbs.getYear() + "-" + udbs.getMonth() + "-" + udbs.getDay());
            udd.setBirthday(birthday);
            // 種別（文字列）をint型に変換して、DTOのsetType()メソッドを利用して、uddにセット
            udd.setType(Integer.parseInt(udbs.getType()));
            udd.setTell(udbs.getTell());
            udd.setComment(udbs.getComment());

            // DBへデータの挿入
            UserDataDAO.getInstance().insert(udd);

            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);

        } catch (Exception e) {
            // データ挿入に失敗したらエラーページにエラー文を渡して表示
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
