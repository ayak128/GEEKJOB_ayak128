/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;

/**
 *
 * @author guest1Day
 */
public abstract class Human {

    // カードの合計値を計算して返す　手札の公開
    abstract public int open();

    // カードを自分の手札にセットする
    // DealerとUserそれぞれにsetCardを用意
    // カードをセットするだけだからvoidでよい
    abstract public void setCard(ArrayList<Integer> Hand);

    // 「自分の合計値」からもっとカードを引く必要があるかチェック
    // チェックするのでboolean
    abstract public boolean checkSum();

    // 自分の手札を管理する　DealerとUserそれぞれに管理させる
    // ArrayListを利用するときは通常の変数宣言とは違いnew演算子を利用する
    protected ArrayList<Integer> myCards = new ArrayList<Integer>();
}
