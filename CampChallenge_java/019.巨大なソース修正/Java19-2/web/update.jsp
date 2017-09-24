<%@page import="java.util.Calendar"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("resultDetailData");
    // Date型のbirthdayをyear、month、dayに分ける/Calendarクラスの形成
    Calendar birthday = Calendar.getInstance();
    // Date型をCalendarに変換
    birthday.setTime(udd.getBirthday());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
        <div align="center">
            <h1>ユーザー情報変更</h1>

            <form action="UpdateResult" method="POST">
                名前:
                <!--修正）名前が表示されるよう記述-->
                <input type="text" name="name" value="<%= udd.getName()%>">
                <br><br>

                生年月日:　
                <!--修正）バラバラにした年月日をそれぞれ表示されるよう記述-->
                <select name="year">
                    <option value="">----</option>
                    <% for (int i = 1950; i <= 2010; i++) {%>
                    <option value="<%=i%>" <%if (birthday.get(Calendar.YEAR) == i) {%> selected <%}%>><%=i%></option>
                    <% } %>
                </select>年
                <select name="month">
                    <option value="">--</option>
                    <% for (int i = 1; i <= 12; i++) {%>
                    <option value="<%=i%>" <%if (birthday.get(Calendar.MONTH) + 1 == i) {%> selected <%}%>><%=i%></option>
                    <% } %>
                </select>月
                <select name="day">
                    <option value="">--</option>
                    <% for (int i = 1; i <= 31; i++) {%>
                    <option value="<%=i%>" <%if (birthday.get(Calendar.DAY_OF_MONTH) == i) {%> selected <%}%>><%=i%></option>
                    <% } %>
                </select>日
                <br><br>

                種別:
                <br>
                <% for (int i = 1; i <= 3; i++) {%>
                <input type="radio" name="type" value="<%=i%>"<%if (udd.getType() == i) {
                        out.print("checked");
                    }%>><%=jh.exTypenum(i)%><br>
                <% }%>
                <br>

                電話番号:
                <!--修正）電話番号が表示されるよう記述-->
                <input type="text" name="tell" value="<%= udd.getTell()%>">
                <br><br>

                自己紹介文
                <br>
                <!--修正）自己紹介が表示されるよう記述-->
                <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udd.getComment()%></textarea><br><br>

                <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
                <input type="submit" name="btnSubmit" value="更新する">
            </form><br>
            <!--修正）検索結果詳細へ-->
            <%=jh.resultdetail()%>
        </div>
    </body>
</html>
