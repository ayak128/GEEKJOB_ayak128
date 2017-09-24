<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="javax.servlet.http.HttpSession"%> 
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>) hs.getAttribute("resultData");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <div align="center">
            <h1>検索結果</h1>

            <!--修正）該当データ無しの場合の表示-->
            <% if (udd.size() == 0 || udd == null) { %>
            該当するユーザー情報がありません<br><br>
            <% } %>

            <table border=1>
                <tr>
                    <th>名前</th>
                    <th>生年</th>
                    <th>種別</th>
                    <th>登録日時</th>
                </tr>

                <!--該当するユーザー情報が存在する分、全て表示させる-->
                <%for (UserDataDTO value : udd) {%>
                <tr>
                    <!--<a href="ここの中がリンクになる<送信先にIDを届ける>">-->
                    <td><a href="ResultDetail?id=<%= value.getUserID()%>"><%= value.getName()%></a></td>
                    <td><%= value.getBirthday()%></td>
                    <td><%= value.getType()%></td>
                    <td><%= sdf.format(value.getNewDate())%></td>
                </tr>
                <%}%>
            </table><br>
            <%=jh.home()%>
        </div>
    </body>
</html>
