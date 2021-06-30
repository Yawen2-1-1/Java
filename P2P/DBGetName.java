package P2P;

import java.sql.*;

public class DBGetName extends DBConnect {
    public String getName(String account) {
        String name = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // 從資料表 `t_member_data` 中搜尋與會員帳號相符的會員姓名
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement st = con.createStatement();
            String sql = "select * from `t_member_data`";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("MemberAccount").equals(account)) {
                    name = rs.getString("MemberName");
                    break;
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

        return name;
    }
}
