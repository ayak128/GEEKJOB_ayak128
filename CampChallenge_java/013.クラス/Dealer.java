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
public class Dealer extends Human {

    // 整数を格納するArrayListを作成
    ArrayList<Integer> cards = new ArrayList<Integer>();

    // コンストラクタでcardsに全てのトランプを持たせる
    // ここが山札（13枚×4種類で52枚）
    public Dealer() {
        // iが4より小さいか等しいうちは繰り返す
        for (int i = 1; i <= 4; i++) {
            // jが13より小さいか等しいうちは繰り返す
            for (int j = 1; j <= 13; j++) {
                // jの数が10より小さいか等しいならjの値をそのまま追加
                // jの数が10より大きい（11、12、13）なら、「10」を追加
                if (j <= 10) {
                    cards.add(j);
                } else {
                    cards.add(10);
                }
            }
        }
    }

    Random rand = new Random();

    // 山札（cards）からランダムで2枚のカードを引き、ArrayListにして返却
    public ArrayList<Integer> deal() {

        // 整数を格納するArrayListを作成
        ArrayList<Integer> dealCard = new ArrayList<>();

        // iが2より小さいか等しいうちは繰り返す（まずは山札から2枚引く）
        // [58行目]cardsの要素数（最初は52）を取得し、nextIntメソッドで1枚引いてindexに代入
        // nextIntメソッド == int型が取り得る範囲でのint型乱数を取得する
        // [59行目]cardsから引いたindex（取得したint型乱数）を取得し、dealCardsに追加
        // 取得した乱数を2度引かないよう削除　結果をdealCardに返す
        for (int i = 1; i <= 2; i++) {
            int Index = rand.nextInt(cards.size());
            dealCard.add(cards.get(Index));
            cards.remove(Index);
        }
        return dealCard;  // dealCardの中身は取得した乱数2つが入っている
    }

    // 山札（cards）からランダムで1枚のカードを引き、ArrayListにして返却
    public ArrayList<Integer> hit() {

        // 整数を格納するArrayListを作成
        ArrayList<Integer> hitCard = new ArrayList<>();

        int Index = rand.nextInt(cards.size());
        hitCard.add(cards.get(Index));
        cards.remove(Index);
        return hitCard;  // hitCardの中身は取得した乱数1つが入っている
    }

    // 継承クラスはHumanクラス内のabstractメソッドを全て継承しなければならない
    // カードの合計値を計算して返すopenメソッド　手札の公開
    @Override
    public int open() {
        int total = 0;
        // 0から始まり、iがmyCardsの要素数より小さいうちは繰り返す
        // つまり、myCardsの中身を全て確認し終わるまで繰り返す（最初は2枚だから2回）
        // myCradsのi番目の要素を取得してtotalと足し、全て足した数をtotalへ代入
        // 条件式の中にArrayListの変数を使いたいときは開始時の数に注意
        for (int i = 0; i < myCards.size(); i++) {
            total = total + myCards.get(i);
        }
        return total;
    }

    // 「自分の合計値」からもっとカードを引く必要があるかチェック
    // totalが16より小さいか等しいならtrue、異なるならfalse
    @Override
    public boolean checkSum() {
        int total = open();
        if (total <= 16) {
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
