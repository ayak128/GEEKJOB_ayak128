package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する DB接続系はDBManagerクラスに一任 基本的にはやりたい1種類の動作に対して1メソッド
 *
 * @author hayashi-s
 */
public class UserDataDAO {

    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance() {
        return new UserDataDAO();
    }

    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void insert(UserDataDTO ud) throws SQLException {

        Connection con = null;
        PreparedStatement st = null;

        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * データの検索処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();

            // sqlに全件表示のための記述を代入
            String sql = "SELECT * FROM user_t";

            boolean flag = false;

            // 名前が空文字でない場合、
            // sqlに「SELECT * FROM user_t WHERE name like ?」を代入し、trueに
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
            }

            // 生年がnullではない場合、次のif文へ
            // falseの場合、名前が未入力なので「部分一致検索」
            // sqlに「SELECT * FROM user_t WHERE birthday like ?」を代入し、trueに
            // trueの場合、名前が入力済みなので「名前と生年をAND検索」
            // sqlに「SELECT * FROM user_t WHERE name like ? AND birthday like ?」を代入
            if (ud.getBirthday() != null) {
                if (!flag) {
                    sql += " WHERE birthday like ?";
                    flag = true;
                } else {
                    sql += " AND birthday like ?";
                }
            }

            // 種別が0でない場合、次のif文へ
            // falseの場合、名前と生年が未入力なので「部分一致検索」
            // sqlに「SELECT * FROM user_t WHERE type like ?」を代入
            // trueの場合、それぞれの検索文が代入される
            // 名前と生年が入力済み「SELECT * FROM user_t WHERE name like ? AND birthday like ? AND type like ?」
            // 名前が入力済み「SELECT * FROM user_t WHERE name like ? AND type like ?」
            // 生年が入力済み「SELECT * FROM user_t WHERE birthday like ? AND type like ?」
            if (ud.getType() != 0) {
                if (!flag) {
                    sql += " WHERE type like ?";
                } else {
                    sql += " AND type like ?";
                }
            }

            if (!flag) {
                sql += "";
            }

            // sql文を反映させる
            st = con.prepareStatement(sql);

            // sql文にname、birthday、typeが含まれているかチェック
            boolean name = sql.contains("name");
            boolean birthday = sql.contains("birthday");
            boolean type = sql.contains("type");

            if (name && birthday && type) {
                st.setString(1, "%" + ud.getName() + "%");
                st.setString(2, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                st.setInt(3, ud.getType());
            } else if (name && birthday) {
                st.setString(1, "%" + ud.getName() + "%");
                st.setString(2, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");

            } else if (name && type) {
                st.setString(1, "%" + ud.getName() + "%");
                st.setInt(2, ud.getType());

            } else if (birthday && type) {
                st.setString(1, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                st.setInt(2, ud.getType());

            } else if (name) {
                st.setString(1, "%" + ud.getName() + "%");

            } else if (birthday) {
                st.setString(1, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");

            } else if (type) {
                st.setInt(1, ud.getType());

            } else {
            }

            ResultSet rs = st.executeQuery();

            // 検索結果（resultUd）を入れるArrayListの作成
            ArrayList<UserDataDTO> UDD = new ArrayList<UserDataDTO>();

            while (rs.next()) {
                UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt("userID"));
                resultUd.setName(rs.getString("name"));
                resultUd.setBirthday(rs.getDate("birthday"));
                resultUd.setTell(rs.getString("tell"));
                resultUd.setType(rs.getInt("type"));
                resultUd.setComment(rs.getString("comment"));
                resultUd.setDate(rs.getTimestamp("newDate"));

                UDD.add(resultUd);
            }
            System.out.println("search completed");

            return UDD;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();

            String sql = "SELECT * FROM user_t WHERE userID = ?";

            st = con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());

            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setDate(rs.getTimestamp(7));

            System.out.println("searchByID completed");

            return resultUd;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     *
     * @param ud
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public UserDataDTO update(UserDataDTO ud) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();

            // ユーザーのデータを更新（IDで更新）
            st = con.prepareStatement("UPDATE user_t set name = ?, birthday = ?, tell = ?, type = ?, comment = ?, newDate = ? where userID = ?");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            Date n = new Date();
            String n1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(n);
            Timestamp now = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(n1).getTime());
            st.setTimestamp(6, now);
            st.setInt(7, ud.getUserID());
            st.executeUpdate();

            // 更新したユーザー情報を取得
            st = con.prepareStatement("SELECT * FROM user_t where userID = ?");
            st.setInt(1, ud.getUserID());
            ResultSet rs = st.executeQuery();

            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt("userID"));
            resultUd.setName(rs.getString("name"));
            resultUd.setBirthday(rs.getDate("birthday"));
            resultUd.setTell(rs.getString("tell"));
            resultUd.setType(rs.getInt("type"));
            resultUd.setComment(rs.getString("comment"));
            resultUd.setDate(rs.getTimestamp("newDate"));

            System.out.println("update completed");
            return resultUd;

        } catch (SQLException e_sql) {
            System.out.println(e_sql.getMessage());
            throw new SQLException(e_sql);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            throw new Exception(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public void delete(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();

            // ユーザーのデータ削除（IDで削除）
            st = con.prepareStatement("DELETE FROM user_t where userID = ?");
            st.setInt(1, ud.getUserID());
            st.executeUpdate();

        } catch (SQLException e_sql) {
            System.out.println(e_sql.getMessage());
            throw new SQLException(e_sql);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
