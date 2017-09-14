<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udbs = (UserDataBeans) hs.getAttribute("udb");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <%  // 種別以外の入力情報がすべて空文字でなければ登録確認を表示
            if (!udbs.getName().equals("") && !udbs.getYear().equals("") && !udbs.getMonth().equals("")
                    && !udbs.getDay().equals("") && udbs.getType() != null
                    && !udbs.getTell().equals("") && !udbs.getComment().equals("")) {

        %>
        <h1>登録確認</h1>
        名前:<%= udbs.getName()%><br>
        生年月日:<%= udbs.getYear() + "年" + udbs.getMonth() + "月" + udbs.getDay() + "日"%><br>
        種別:<%= udbs.getType()%><br>
        電話番号:<%= udbs.getTell()%><br>
        自己紹介:<%= udbs.getComment()%><br><br>
        上記の内容で登録します。よろしいですか？<br>

        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>"><br>
            <input type="submit" name="yes" value="はい"><br>
        </form>
        <form action="insert" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>"><br>
            <input type="submit" name="no" value="いいえ"><br>
        </form>

        <%
            // 名前・年・月・日・種別・電話番号・自己紹介のどれかが空文字なら
        } else {
            out.print("不完全な項目があります。以下の項目を確認してください。<br><br>");
            if (udbs.getName().equals("")) {
                out.print("・名前<br>");
            }
            if (udbs.getYear().equals("")) {
                out.print("・年<br>");
            }
            if (udbs.getMonth().equals("")) {
                out.print("・月<br>");
            }
            if (udbs.getDay().equals("")) {
                out.print("・日<br>");
            }
            if (udbs.getType() == null) {
                out.print("・種別<br>");
            }
            if (udbs.getTell().equals("")) {
                out.print("・電話番号<br>");
            }
            if (udbs.getComment().equals("")) {
                out.print("・自己紹介<br>");
            }%>
        <form action="insert" method="POST">
            <br><input type="submit" name="no" value="登録画面に戻る">
        </form>
        <%}%>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
