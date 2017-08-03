<%-- 
    Document   : challenge16-1
    Created on : 2017/08/03, 18:31:57
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
        <form action="./test.jsp" method="post">
            【氏名】<input type="text" name="name"><br><br>
            【性別】<input type="radio" name="gender">男
            <input type="radio" name="gender">女
            <input type="radio" name="gender">その他<br><br>
            【趣味】<br>
            <textarea name="hobby" cols="50" rows="10"></textarea><br><br>
            <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>
