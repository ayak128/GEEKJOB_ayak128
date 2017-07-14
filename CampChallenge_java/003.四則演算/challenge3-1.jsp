<%-- 
    Document   : challenge3-1
    Created on : 2017/07/14, 14:22:40
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
            
            final int BASE = 10;
            int num = 5;
            
            out.print(++num);     //num+1 = 6
            out.print(--num);     //num-1 = 5
            
            out.print(BASE*num);  //BASE×num = 50
            out.print(BASE/num);  //BASE÷num = 2
            
            out.print(num++);     //printしてから+1 = 5
            out.print(num--);     //printしてから-1 = 6
            
            out.print(num);       //num = 5
            
        %>
        
    </body>
</html>
