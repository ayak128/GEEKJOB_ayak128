<%-- 
    Document   : challenge16-5
    Created on : 2017/08/04, 15:24:19
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
        <form action ="challenge16-5-2.jsp" method="get">
            <h3>素因数分解をしてみよう</h3>
            数値を入力してください<br>
            <input type="number" name="number"><br><br>
            
            <input type="submit" name="btnSubmit" value="送信">
            <input type="reset" name="rstSubmit" value="リセット">
        </form>
    </body>
</html>
