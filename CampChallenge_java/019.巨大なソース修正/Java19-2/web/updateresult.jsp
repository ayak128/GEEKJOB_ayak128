<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    // 更新結果表示にのみ利用するため、リクエストスコープから取得
    UserDataDTO udd = (UserDataDTO) request.getAttribute("resultUpdateData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <div align="center">
            <h1>変更結果</h1><br>
            
            名前：<%= udd.getName()%><br>
            生年月日：<%= udd.getBirthday()%><br>
            種別：<%= jh.exTypenum(udd.getType())%><br>
            電話番号：<%= udd.getTell()%> <br>
            自己紹介：<%= udd.getComment()%><br><br>
            以上の内容で登録しました。<br><br><br>
            <!--修正）検索詳細画面へ-->
            <%=jh.resultdetail()%>
        </div>
    </body>

</html>
