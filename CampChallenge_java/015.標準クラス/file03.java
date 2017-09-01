/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author guest1Day
 */
// 
public class file03 {

    public static void main(String[] args) throws IOException {

        // 開始時間を取得
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // ファイルオープン　ファイルパス（logfile.txt）
        // もともと（logfile.txt）というファイルが存在すればそこに書き込むが、
        // 無ければ作って、そこに書き込んでくれる
        // ←書き込まれた内容は「プロジェクト」の隣の「ファイル」で確認できる
        File fp = new File("logfile.txt");
        FileWriter fw = new FileWriter(fp);

        // ()の内容（開始時間＋開始）をファイルパスの中に書き込み
        fw.write(sdf.format(now) + "　開始\n");  // \nで改行

        // 文字列を格納するLinkedList
        LinkedList<String> link = new LinkedList<>();

        // addメソッドを使った場合、最後に追加される
        // （logfile.txt）の中に「開始　処理　終了」を書き込むイメージ
        // System.out.println(link)と記述すると（logfile.txt）の中には書き込まれない
        link.add("ん");
        link.add("に");
        link.add("ち");
        fw.write(link.toString() + "\n");
        // .toString()で文字に型変換（linkの中身は文字だけどLinkedListはStringじゃない）

        fw.write("最初と最後に文字を追加します。\n");
        link.addFirst("こ");
        link.addLast("は");
        fw.write(link.toString() + "\n");

        fw.write("2番目と3番目の文字を置き換えます。\n");
        link.set(2, "ば");
        link.set(3, "ん");
        fw.write(link.toString() + "\n");

        fw.write("3番目の文字を削除します。\n");
        link.remove(4);
        fw.write(link.toString() + "\n");

        fw.write("「こ」について検索します。\n");
        fw.write("「こ」のインデックス番号は【" + link.indexOf("こ") + "】です。\n");

        fw.write("最初の文字を取得および削除します。\n");
        link.pollFirst();

        fw.write("現在、列の先頭の文字は【" + link.getFirst() + "】です。\n");
        fw.write("現在、列の要素数は【" + link.size() + "】です。\n");
        fw.write("列の中身を表示します→" + link + "\n");

        fw.write("列の要素を全て削除します。\n");
        link.clear();
        fw.write("最終的な列の要素数は【" + link.size() + "】です。\n");

        fw.write(sdf.format(now) + "　終了");
        fw.close();

        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        // readLineメソッドでは文字を1行ずつまとめて読んでくれる==改行(\n)以降は読まない
        // このメソッドを使うとまず先頭の1行を読み、自動的に読み込む位置が次の行に移る
        // 繰り返しこのメソッドを実行すると、ファイルの先頭から最後まで順にテキストを読む
        // readLineメソッドは、ファイルを最後まで読み込むとnullを返す
        // ↓の「all = br.readLine();」を書かないとnullを求めて永遠に読み続ける
        String all = br.readLine();
        while (all != null) {
            System.out.println(all);
            all = br.readLine();  // ここで次の行を読み込む
        }
        br.close();
    }
}
