/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word;

/**
 *
 * @author guest1Day
 */
public class mozi3 {
    public static void main(String[] args){
        String word1 = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        // word1の「I」を「い」に置き換える
        String word2 = word1.replace("I","い");
        // word2の「U」を「う」に置き換える
        String word3 = word2.replace("U","う");
        
        System.out.print(word3);
    }
}
