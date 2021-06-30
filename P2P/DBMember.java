package P2P;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class DBMember extends DBConnect {
    // mode = 0: 登入; mode = 1: 註冊
    public boolean Connection(String account, String password, int mode, String statement) {
        boolean result = false;
        String sql = "select * from " + "`" + "t_member_data" + "`"; // 選擇資料表
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement st = con.createStatement();
            if (mode == 1) {
                st.executeUpdate(statement);
            }

            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                // 以遍歷資料表的方式比對用戶資料，因此 Comparison 要放在迴圈內，而非迴圈之後，
                // 不然就會收到 null 而無法比對
                if (mode == 0) {
                    result = Comparison(rs.getString("MemberAccount"),
                            rs.getString("MemberPassword"), account, password);
                    if (result) break; // 當有多筆資料在資料表時，會不斷遍歷用戶資料直到最後一筆，才將結果回傳
                    // 若無此條件判斷式，會造成只有資料表中最後一筆資料恆真
                } else if (mode == 1) {
                    result = Comparison(rs.getString("MemberAccount"), account);
                    if (result) break;
                }
            }

            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // 確認登入狀態是否成功
    public boolean Comparison(String rsAccount, String rsPassword, String account, String password) {
        return account.equals(rsAccount) && password.equals(rsPassword);
    }

    // 確認註冊狀態是否成功
    public boolean Comparison(String rsAccount, String account) {
        return account.equals(rsAccount);
    }

    // 將用戶密碼進行 SHA-256 編碼
    public String SHA256_Password(String password) {
        byte[] encodedPW = null;
        try {
            // 編碼過程以 byte[] 型別進行
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            encodedPW = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return bytesToHexString(encodedPW);
    }

    // 將 SHA-256 編碼的 byte[] 型別轉成字串
    public String bytesToHexString(byte[] encodedHash) {
        StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
        for (int i = 0; i < encodedHash.length; i++) {
            String hexBit = Integer.toHexString(0xff & encodedHash[i]);
            if (hexBit.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hexBit);
        }

        return hexString.toString();
    }
}
