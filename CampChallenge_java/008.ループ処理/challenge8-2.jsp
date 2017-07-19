<%-- 
    Document   : challenge8-2
    Created on : 2017/07/18, 17:39:33
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
            
            String name = "A";                 //name=A
                    for(int i=1;i<30;i++){     //1が30より小さいうちは繰り返す
                        name = name + "A";     //A+A　name=AA　実行後i+1
                    }
                    out.print(name);
        
        %>
    </body>
</html>
