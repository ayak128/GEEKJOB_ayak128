<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("resultDetailData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <h1>ユーザー情報削除確認</h1>

            <!--修正）質問の仕方を変更-->
            このレコードを本当に削除しますか？<br><br>
            <!--修正）対象の全データを表示するためIDを追加-->
            ユーザーID：<%= udd.getUserID()%><br>
            名前：<%= udd.getName()%><br>
            生年月日：<%= udd.getBirthday()%><br>
            種別：<%= jh.exTypenum(udd.getType())%><br>
            電話番号：<%= udd.getTell()%><br>
            自己紹介：<%= udd.getComment()%><br>
            登録日時：<%= udd.getNewDate()%><br><br>

            <form action="DeleteResult" method="POST">
                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <input type="submit" name="YES" value="はい" style="width:100px">
            </form><br>
            <form action="resultdetail.jsp" method="POST">
                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                <input type="submit" name="NO" value="いいえ" style="width:100px">
            </form>
        </div>
    </body>
</html>
