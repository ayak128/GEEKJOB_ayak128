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
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= udbs.getName()%><br>
        生年月日:<%= udbs.getYear() + "年" + udbs.getMonth() + "月" + udbs.getDay() + "日"%><br>
        種別:<%= udbs.getType()%><br>
        電話番号:<%= udbs.getTell()%><br>
        自己紹介:<%= udbs.getComment()%><br><br>
        以上の内容で登録しました。<br>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
