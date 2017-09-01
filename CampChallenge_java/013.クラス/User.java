/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author guest1Day
 */
public class User extends Human {

    // 継承クラスはHumanクラス内のabstractメソッドを全て継承しなければならない
    // カードの合計値を計算して返すopenメソッド　手札の公開
    // myCards（自分の手札を管理する）
    @Override
    public int open() {
        int total = 0;
        for (int i = 0; i < myCards.size(); i++) {
            total += myCards.get(i);
        }
        return total;
    }

    // 「自分の合計値」からもっとカードを引く必要があるかチェック
    // totalが20より小さいか等しいならtrue、異なるならfalse
    @Override
    public boolean checkSum() {
        int total = open();
        if (total <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // カードを自分の手札にセットする
    // Handに引いたカードが入ってきたら、Handの要素数分すべてをmyCardsに追加する
    @Override
    public void setCard(ArrayList<Integer> Hand) {
        for (int i = 0; i < Hand.size(); i++) {
            myCards.add(Hand.get(i));
        }
    }
}
