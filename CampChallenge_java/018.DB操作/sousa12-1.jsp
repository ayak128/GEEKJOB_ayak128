<%-- 
    Document   : sousa12-1
    Created on : 2017/08/17, 18:23:26
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
        <form action="sousa12_2" method="post">
            <center>
                <br><br><br><br><br><br><br><br>
                検索したい情報の「名前・年齢・誕生日」を入力してください<br><br>    
                
                名前<br><input type="text" name="name" value="山田太郎"><br><br>
                年齢<br><input type="text" name="age" size="10" value="30"><br><br>
                誕生日<br><input type="text" name="birthday" value="2017-08-17"><br><br>
                
                <input type="submit" name="btnSubmit" value="検索する">
                <input type="reset" name="reset" value="リセット">
            </center>
        </form>
    </body>
</html>
