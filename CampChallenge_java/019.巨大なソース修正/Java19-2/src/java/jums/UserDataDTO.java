package jums;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ユーザー情報を持ちまわるJavaBeans データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 *
 * @version 1.00
 * @author hayashi-s
 */
// 修正）JavaBeansの必要条件である「implements Serializable」を追記
public class UserDataDTO implements Serializable {

    // 修正）引数無しのコンストラクタを追記
    public UserDataDTO() {
    }

    private int userID;
    private String name;
    private Date birthday;
    private String tell;
    private int type;
    private String comment;
    // 修正）TimestampをDate型に変更
    private Date newDate;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // 修正）TimestampをDate型に変更
    public Date getNewDate() {
        return newDate;
    }

    public void setDate(Timestamp newDate) {
        this.newDate = newDate;
    }

//    void setDate(Timestamp timestamp) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
