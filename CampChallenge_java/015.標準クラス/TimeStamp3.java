/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class TimeStamp3 {

    public static void main(String[] args) throws ParseException {
        // SimpleDateFormatクラスの作成
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ↑の文字列を日付に変換
        Date d = sdf.parse("2015-01-01 00:00:00");
        Date d2 = sdf.parse("2015-12-31 23:59:59");
        // タイムスタンプを取得し、差（ミリ秒）を計算
        // タイムスタンプの中身はlongなので数字としても扱える
        long total = (d2.getTime() - d.getTime());
        // 計算結果を表示
        System.out.print("差は" + total +"です");
        //「System.out.print(d2.getTime() - d.getTime());」でもよい
    }
}
