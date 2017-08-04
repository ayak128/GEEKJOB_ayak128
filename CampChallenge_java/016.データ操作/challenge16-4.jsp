<%-- 
    Document   : challenge16-4
    Created on : 2017/08/04, 10:32:46
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
        <form action="challenge16-4-2.jsp" method="get">

             総額 <input type="number" name="total"><br><br>
             個数 <input type="number" name="count"><br><br>

            <input type="radio" name="type" value=1 checked="checked"> 雑貨<br>
            <input type="radio" name="type" value=2> 生鮮食品<br>
            <input type="radio" name="type" value=3> その他<br><br>
            
            <input type="submit" name="btnSubmit" value="送信">
            <input type="reset" name="rstSubmit" value="リセット">
            
        </form>
    </body>
</html>
