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

public class TimeStamp {
    public static void main(String[] args) throws ParseException{
        // SimpleDateFormatクラスの作成
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // 文字列を日付に変換
        Date d = sdf.parse("2016/01/01 00:00:00");
        // getTimeメソッドを利用し、dのタイムスタンプ（ある日以降の総ﾐﾘ秒）の情報を取得
        System.out.print(d.getTime());
        
        // System.out.print(d);なら「Fri Jan 01 00:00:00 JST 2016」と表示される
    }
}
