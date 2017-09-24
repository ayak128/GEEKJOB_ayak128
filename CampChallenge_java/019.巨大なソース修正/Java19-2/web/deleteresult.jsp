<%@page import="jums.JumsHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
        <div align="center">
            <h1>削除確認</h1>
            削除しました。<br><br>
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <%=jh.searchresult()%>
        </div>
    </body>
</html>
