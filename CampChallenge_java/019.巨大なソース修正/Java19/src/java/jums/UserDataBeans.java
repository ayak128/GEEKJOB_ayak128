    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

// javabeansのルール
// java.io.Serializableを実装している
// クラスはpublicでパッケージに所属している 
// publicで引数のないコンストラクタ（初期化処理）を持つ 
// フィールドは隠匿化（カプセル化・private）されている
// getter/setterをもつ

import java.io.Serializable;

/**
 *
 * @author guest1Day
 */
// クラス名の後ろに「implements Serializable」を追記し、シリアライズ※1可能にする
// ※1メモリ上のデータを変換し、ファイルに保存＆ネットワークに送信できるようにする
public class UserDataBeans implements Serializable{
    
    // publicで引数のないコンストラクタ　{}の中は記述なし
    public UserDataBeans(){}
    
    // フィールドの作成と隠匿化（private）/宣言と同時に初期化
    private String name1 = "";
    private String year1 = "";
    private String month1 = "";
    private String day1 = "";
    private String type1 = "";
    private String tell1 = "";
    private String comment1 = "";
    
    // getterとは、あるフィールドから情報を取り出すメソッド
    // getterの命令規則：getで開始し、以降の単語の頭文字を大文字にして宣言
    // ただし、booleanの場合は「is」で開始する
    public String getName(){
        return this.name1;
    }
    
    public String getYear(){
        return this.year1;
    }
    
    public String getMonth(){
        return this.month1;
    }
    
    public String getDay(){
        return this.day1;
    }
    
    public String getType(){
        return this.type1;
    }
    
    public String getTell(){
        return this.tell1;
    }
    
    public String getComment(){
        return this.comment1;
    }
    
    // setterとは、あるフィールドへ情報を格納するメソッド
    // setterの命令規則：setで開始し、以降の単語の頭文字を大文字にして宣言
    public void setName(String name){
        this.name1 = name;
    }
    
    public void setYear(String year){
        this.year1 = year;
    }
    
    public void setMonth(String month){
        this.month1 = month;
    }
    
    public void setDay(String day){
        this.day1 = day;
    }
    
    public void setType(String type){
        this.type1 = type;
    }
    
    public void setTell(String tell){
        this.tell1 = tell;
    }
    
    public void setComment(String comment){
        this.comment1 = comment;
    }
}
