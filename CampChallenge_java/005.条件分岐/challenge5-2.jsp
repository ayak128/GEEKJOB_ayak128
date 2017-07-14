<%-- 
    Document   : challenge5-2
    Created on : 2017/07/14, 16:22:08
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
            
            int type = 1;
            
            switch(type){
                case 1:
                    out.print("one");      //1の場合「one」を表示
                    break;
                
                case 2:
                    out.print("two");      //2の場合「two」を表示
                    break;
                case 3:
                    out.print("想定外");   //その他の場合「想定外」を表示
                    break;
                    
            }
        %>
    </body>
</html>
