<%-- 
    Document   : challenge16-3
    Created on : 2017/08/03, 19:59:52
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="challenge16-2.jsp" method="post">
            <hr color="black">
            <font color="blue">【氏名】</font>
            <input type="text" name="name"><br><br>
            <font color="blue">【性別】</font>
            <input type="radio" name="gender" value="男">
            <font color="blue">男</font>
            <input type="radio" name="gender" value="女">
            <font color="blue">女</font>
            <input type="radio" name="gender" value="その他">
            <font color="blue">その他</font><br><br>
            <font color="blue">【趣味】</font><br>
            <textarea name="hobby" cols="50" rows="10"></textarea><br><br>
            <input type="checkbox" name="chkTest">
            <font color="blue"> 入力情報を送信します </font><br><br>
            <input type="submit" name="btnSubmit" value="送信">
            <input type="reset" name="rstSubmit" value="リセット">
            <hr color="black">
        </form>

    </body>
</html>
