<%-- 
    Document   : challenge8-1
    Created on : 2017/07/18, 16:04:13
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
            //最終的にintで扱えない範囲の数値になるのでlongを使用
            long total = 1;          //total=1
            for(int i=0;i<20;i++){   //0が20より小さいうちは繰り返す
                total = total*8;
            }
            out.print(total);
            
        %>
    </body>
</html>
