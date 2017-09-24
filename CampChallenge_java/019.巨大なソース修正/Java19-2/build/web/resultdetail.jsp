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
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <div align="center">
            <h1>詳細情報</h1>

            <!--修正）ID表示の追記-->
            ユーザーID：<%= udd.getUserID()%><br>
            名前：<%= udd.getName()%><br>
            生年月日：<%= udd.getBirthday()%><br>
            種別：<%= jh.exTypenum(udd.getType())%><br>
            電話番号：<%= udd.getTell()%><br>
            自己紹介：<%= udd.getComment()%><br>
            登録日時：<%= udd.getNewDate()%><br><br>

            <form action="Update" method="POST">
                <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>" >
                <input type="submit" name="update" value="変更" style="width:100px">
            </form><br>
            <form action="Delete" method="POST">
                <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>" >
                <input type="submit" name="delete" value="削除" style="width:100px">
            </form><br>
            <!--修正）検索結果画面へ-->
            <%=jh.searchresult()%>
        </div>
    </body>
</html>
