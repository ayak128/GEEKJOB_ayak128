<%-- 
    Document   : session2
    Created on : 2017/08/05, 15:03:43
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // 文字コード指定
    request.setCharacterEncoding("UTF-8");

    // セッションの取得
    HttpSession hs = request.getSession();
    // セッションへデータの書き込み
    //「Nameという名前、中身はname」をセッションに登録
    hs.setAttribute("Name", request.getParameter("name"));
    hs.setAttribute("Gender", request.getParameter("gender"));
    hs.setAttribute("Hobby", request.getParameter("hobby"));
    
    // セッションからデータ読み出し
    // セッションから読み出した情報がStringの中へ
    String Username = (String) hs.getAttribute("Name");
    String Usergender = (String) hs.getAttribute("Gender");
    String Userhobby = (String) hs.getAttribute("Hobby");
    
    String aaa = "";
    String bbb = "";
    String ccc = "";
    
    // 読み出したGenderが空でなければ
    if (hs.getAttribute("Gender") != null) {
        // Genderと男性を比較し、一緒ならaaaにchecked
        if(hs.getAttribute("Gender").equals("男性")){
            aaa = "checked";
        }
        // Genderと女性を比較し、一緒ならbbbにchecked
        if(hs.getAttribute("Gender").equals("女性")){
            bbb = "checked";
        }
        // Genderとその他を比較し、一緒ならcccにchecked
        if(hs.getAttribute("Gender").equals("その他")){
            ccc = "checked";
        }
    }
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="session2.jsp" method="post">
            お名前　<input type="text" name="name" value=<% if(Username != null) {out.print(Username);} else {out.print("");} %>><br><br>
            性別<input type="radio" name="gender" value="男性" <%=aaa%>>男性
            <input type="radio" name="gender" value="女性" <%=bbb%>>女性
            <input type="radio" name="gender" value="その他" <%=ccc%>>その他<br><br>
            趣味を書いてください<br>
            <textarea name="hobby" cols="50" rows="10"><% if(Userhobby != null) {out.print(Userhobby);} else {out.print("");} %></textarea><br><br>
            <input type="checkbox" name="check">　入力内容は保存されます<br><br>
            <input type="submit" name="btnSubmit" value="送信">
            <input type="reset" name="rst" value="リセット">
        </form>
    </body>
</html>
