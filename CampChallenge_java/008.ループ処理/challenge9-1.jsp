<%-- 
    Document   : challenge9-1
    Created on : 2017/07/19, 16:12:51
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
            
            int num = 1000;   //num=1000
            int count = 0;    //最後表示するカウント数　最初は0
            while(num>100){   //numが100より大きいうちは繰り返す
                num = num/2;  //1000/2 =500　num=500
                count++;      //countに+1
            }
            out.print(count+"回ループしました");
        
        %>
    </body>
</html>
