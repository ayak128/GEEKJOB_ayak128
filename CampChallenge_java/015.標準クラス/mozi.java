/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author guest1Day
 */
public class mozi {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "かたぎりあや";
        // 氏名のバイト数取得
        // 指定した文字コードで文字のバイト数を求めるにはgetBytesメソッドを使用
        // getBytesメソッドの引数には文字コードを指定する
        System.out.println(name.getBytes("Unicode").length);
        System.out.println(name.getBytes("UTF-8").length);
        System.out.println(name.getBytes("Shift-JIS").length);
        // 引数を指定しない場合はプラットフォームの文字コードが指定される
        System.out.println(name.getBytes().length);
        // 氏名の文字数取得
        System.out.print(name.length());
    }
}
