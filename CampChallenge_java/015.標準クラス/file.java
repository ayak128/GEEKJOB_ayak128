/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.*;

/**
 *
 * @author guest1Day
 */
public class file {

    public static void main(String[] args) throws IOException {
        // ファイルオープン
        File fp = new File("myprofile.txt");
        // FileWriter インスタンス作成
        FileWriter fw = new FileWriter(fp);
        // 書き込み
        // （）の内容がファイルパス（myprofile.txt）の中に書き込まれた
        fw.write("片桐彩です。神奈川県出身です。");
        // ファイルクローズ
        fw.close();
    }
}
