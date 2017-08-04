<%-- 
    Document   : challenge16-4-2
    Created on : 2017/08/04, 11:00:07
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
                // 文字コード指定
                request.setCharacterEncoding("UTF-8");

                // 最初からint型に型変換して、情報を取り出す
                // totalの情報を取り出してint型に型変換
                // Integerクラスで用意されているparseIntメソッドは、
                // 引数に指定された文字列を整数の値として解析しint型の値として返す
                int tl = Integer.parseInt(request.getParameter("total"));
                int ct = Integer.parseInt(request.getParameter("count"));
                int tp = Integer.parseInt(request.getParameter("type"));
                
                // 商品種別毎に
                switch (tp) {
                case 1:
                    out.print("雑貨が選択されています。<br>");
                    break;
                case 2:
                    out.print("生鮮食品が選択されています。<br>");
                    break;
                case 3:
                    out.print("その他が選択されています。<br>");
                    break;
            }
                // 1つ当たりの値段（総額÷個数）
                int ichi = tl / ct;
                out.print("お買いもの総額は" + tl + "円、1つ当たりのお値段は" + ichi + "円です。<br>");

                if (tl >= 5000) {
                    // 小数を整数にする型変換　処理の前に変換したい型を指定
                    int point = (int) (tl * 0.05);
                    out.print("今回は" + point+ "ポイント付与されます。");
                } else if (tl >= 3000) {
                    int point = (int) (tl * 0.04);
                    out.print("今回は" + point + "ポイント付与されます。");
                } else {
                    out.print("ポイント付与は総額3000円以上です。今回は付きません。");
                }
            

        %>
    </body>
</html>
