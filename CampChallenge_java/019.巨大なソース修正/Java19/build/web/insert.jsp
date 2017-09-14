<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udbs = (UserDataBeans) hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
        <form action="insertconfirm" method="POST">
            名前:
            <input type="text" name="name" placeholder="例）山田　太郎" value="<%if (udbs != null) {%><%= udbs.getName()%><% } %>">
            <br><br>

            生年月日:　
            <select name="year">
                <!--再入力のときは前回入力した値を保持-->
                <option value="">----</option>
                <%
                    for (int i = 1950; i <= 2010; i++) {
                        String y = String.valueOf(i);  //数値を文字列に型変換
%>
                <option value="<%=i%>"
                        <%if (udbs != null && udbs.getYear().equals(y)) {%>
                        <%=Integer.parseInt(udbs.getYear())%> selected <% }%>><%=i%></option>
                <% } %>
            </select>年
            <select name="month">
                <option value="">--</option>
                <%
                    for (int i = 1; i <= 12; i++) {
                        String m = String.valueOf(i);
                %>
                <option value="<%=i%>"
                        <%if (udbs != null && udbs.getMonth().equals(m)) {%>
                        <%=Integer.parseInt(udbs.getMonth())%> selected <% }%> ><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value="">--</option>
                <%
                    for (int i = 1; i <= 31; i++) {
                        String d = String.valueOf(i);
                %>
                <option value="<%=i%>"
                        <%if (udbs != null && udbs.getDay().equals(d)) {%>
                        <%=Integer.parseInt(udbs.getDay())%> selected <% }%> ><%=i%></option>
                <% }%>
            </select>日
            <br><br>

            <!--初回、udbs == nullなので、右側の（）の中はスルーされる-->
            <!--2回目はudbs != nullなので、右側の（）の中も見てくれる-->
            <!--右側の（）は「getType()がnullじゃない」＋「getType()が1」ならcheckedが入る-->
            種別:
            <br>
            <input type="radio" name="type" value="1"
                   <%if (udbs != null && (udbs.getType() != null && udbs.getType().equals("1"))) {%> checked <%}%>>エンジニア<br>
            <input type="radio" name="type" value="2"
                   <%if (udbs != null && (udbs.getType() != null && udbs.getType().equals("2"))) {%> checked <%}%>>営業<br>
            <input type="radio" name="type" value="3"
                   <%if (udbs != null && (udbs.getType() != null && udbs.getType().equals("3"))) {%> checked <%}%>>その他<br>
            <br>

            電話番号:
            <input type="text" name="tell" placeholder="例）012-3456-7890" value="<%if (udbs != null) {%><%=udbs.getTell()%><% } %>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" placeholder="例）はじめまして"><%if (udbs != null) {%><%=udbs.getComment()%><% }%></textarea><br><br>
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
