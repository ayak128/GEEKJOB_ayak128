package base;

/**
 *
 * @author hayashi-s
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/katagiri_db", "AYAKATAGIRI", "ayak128");
            System.out.println("DBConnected!!");
            return con;

            // 「IllegalArgumentException」は不正な引数、または不適切な引数をメソッドに渡したことを示すための例外
            // 「ClassNotFoundException」は存在しないクラスを指定した場合に投げられる。
        } catch (ClassNotFoundException e) {
            throw new IllegalMonitorStateException();
        } catch (SQLException e) {
            throw new IllegalMonitorStateException("接続時にエラーが発生しました。");
        }
    }
}
