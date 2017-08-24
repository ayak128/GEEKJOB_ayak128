<%-- 
    Document   : sousa13-2
    Created on : 2017/08/23, 12:24:57
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
        商品情報登録ページ<br><br><br>
        
        <%
            String nakami = (String) session.getAttribute("check");
            if (nakami == "kara") {
                out.print("商品登録失敗しました。<br><br>");
                out.print("ヒント：未入力の項目があります。<br><br>");
            } else if (nakami == "mozi") {
                out.println("商品登録失敗しました。<br><br>");
                out.print("ヒント：入力内容が間違っています。<br><br>");
            } else {
                out.print("こんにちは。" + nakami +"さん。<br><br>");
                out.print("新しい商品を登録できます。※数字は半角のみ<br><br>");

            }
        %>
        
        <form action="sousa13_2" method="post">
            品番　　 <input type="text" name="hinban" value="1"><br><br>
            商品名　<input type="text" name="syouhin" value="酒"><br><br>
            個数　　 <input type="text" name="kosuu" value="2"><br><br>
            価格　　 <input type="text" name="kakaku" value="200"><br><br>
            
            <input type="submit" name="btnSubmit" value="登録">
            <input type="reset" name="rstSubmit" value="リセット">
        </form>
        
        <form action="sousa13_3" method="post">
            <br><br>現在、登録されている商品一覧を確認できます<br><br>
            <input type="submit" name="btnSubmit" value="商品一覧">
        </form>
        
        <form action="sousa13_5" method="post">
            <br><br>商品情報を削除したい場合は、品番を指定してください<br><br>
            品番　<input type="text" name="delete" value="1"><br><br>
            <input type="submit" name="btnSubmit" value="削除">
        </form>
        
        <form action="sousa13-1.jsp" method="post">
            <input type="submit" name="submit" value="ログアウト<%session.setAttribute("check", "logout");%>">
        </form>
        
    </body>
</html>
