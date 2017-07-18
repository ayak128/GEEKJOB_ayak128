<%-- 
    Document   : challenge7-1
    Created on : 2017/07/18, 14:47:44
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
        <%@ page import="java.util.HashMap" %>
        <%
            HashMap<String,String> user = new HashMap<String,String>();
            
            user.put("1","AAA");
            user.put("hello","world");
            user.put("soeda","33");
            user.put("20","20");
            
            out.print(user);
            
        %>
    </body>
</html>
