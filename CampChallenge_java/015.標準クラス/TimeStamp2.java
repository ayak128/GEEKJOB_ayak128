/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class TimeStamp2 {

    public static void main(String[] args) throws ParseException {
        // SimpleDateFormatクラスの作成
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ↑の文字列を日付に変換
        Date d = sdf.parse("2016-11-04 10:00:00");
        // タイムスタンプの作成　printlnにすると出力のところで改行される
        System.out.println(d.getTime());
        // dのデータを表示
        System.out.print(sdf.format(d));
    }
}
