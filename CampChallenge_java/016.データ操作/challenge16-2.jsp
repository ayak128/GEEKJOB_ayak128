<%-- 
    Document   : challenge16-2
    Created on : 2017/08/03, 19:22:32
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
        <%
            // 文字コード指定
            request.setCharacterEncoding("UTF-8");

            // 情報の取り出しと表示
            out.print("【氏名】" + request.getParameter("name") + "<br>");
            out.print("【性別】" + request.getParameter("gender") + "<br>");
            out.print("【趣味】" + request.getParameter("hobby"));

        %>
    </body>
</html>
