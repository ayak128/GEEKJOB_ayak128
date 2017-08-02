/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class Time {
    public static void main(String[] args){
    // 今日の日付作成
    Date now = new Date();
    // SimpleDateFormatの作成
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 現在の時間を表示
    System.out.print(sdf.format(now));
    }
}
