/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable; //インターフェイスを実装
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class ResultData implements Serializable {
    private Date d;       //フィールド。privateがあるので隠匿化
    private String luck;  //フィールド。privateがあるので隠匿化
    
    public ResultData () {}
    
    public Date getD(){  //情報を取得
    return d;
}
    public void setD(Date d){  //日付をset
        this.d = d;
    }
    public String getLuck(){  //Luckを取り出す処理
        return luck;
    }
    public void setLuck(String luck){
        this.luck = luck;
    }
}

