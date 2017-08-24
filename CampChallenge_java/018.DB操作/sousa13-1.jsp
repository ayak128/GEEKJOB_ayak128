<%-- 
    Document   : sousa13-1
    Created on : 2017/08/18, 19:33:35
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
    </head>
    <body>
        <%
            // session.getAttributeでセッションから「check」の取り出し
            // getAttributeで取り出された値はObjectインスタンスになっているので、Stringに型変換
            // checkの中身はnamenonakami→つまりフォームの入力内容を確認している
            String nakami = (String) session.getAttribute("check");
            if (nakami == "kara") {
                out.print("ログイン失敗しました。<br><br>");
                out.print("ヒント：未入力の項目があります。<br><br>");
            } else if (nakami == "mozi") {
                out.println("ログイン失敗しました。<br><br>");
                out.print("ヒント：入力内容が間違っています。<br><br>");
            } else if (nakami == null) {
                out.print("ようこそ、ゲストさん！<br><br>");
            } else if (nakami == "logout") {
                out.print("ログアウトしました。<br><br>");
            }
        %>
        <form action="sousa13_4" method="post">

            お名前<br><input type="text" name="name" value="片桐彩"><br><br>
            ログインID（半角数字）<br><input type="text" name="userID" value="1"><br><br>
            パスワード（半角英数字）<br><input type="text" name="password" value="ayakata128"><br><br><br>
            <input type="submit" name="btnSubmit" value="ログイン">
            <input type="reset" name="rstSubmit" value="リセット">
        </form>    
    </body>
</html>
