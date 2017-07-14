<%-- 
    Document   : challenge5-3
    Created on : 2017/07/14, 16:37:25
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
            
            char type = 'A';
            
            switch(type){
              case 'A':
                  out.print("英語");
                  break;
                  
              case 'あ':
                  out.print("日本語");
                  break;
                  
              default:
                  break;
          }
            
        %>
    </body>
</html>
