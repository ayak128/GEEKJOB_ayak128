<%-- 
    Document   : sousa11-1
    Created on : 2017/08/17, 17:53:14
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
        <form action="sousa11_2" method="post">
            <center>
                <br><br><br><br><br><br>
                更新したい情報のIDを教えてください<br><br>
                <input type="numner" name="id" size="10" value="例：1（半角）"><br><br>
                
                ID以外の情報を更新します！<br>下記に更新したい内容を入力してください<br><br>
                名前<br><input type="text" name="name" value="例：山田太郎"><br><br>
                電話番号<br><input type="text" name="tell" size="25" value="例：012-3456-7890（半角）"><br><br>
                年齢<br><input type="text" name="age" size="10" value="例：30（半角）"><br><br>
                誕生日<br><input type="text" name="birthday" value="例：2017-08-17（半角）"><br><br>
                
                <input type="submit" name="btnSubmit" value="送信する">
                <input type="reset" name="reset" value="リセット">
            </center>
        </form>
    </body>
</html>
