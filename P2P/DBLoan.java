package P2P;

import java.sql.*;
import java.time.LocalDate;

public class DBLoan extends  DBConnect {
    // mode 1: 在 `t_application` 中進行搜尋; mode 2: 在 `t_member_info` 中進行搜尋
    public boolean LoanCaseOperation (String applicationID, String statement, int mode) {
        boolean exist = false;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement st = con.createStatement();
            st.executeUpdate(statement);
            String sql = null;
            if (mode == 1) {
                sql = "select * from `t_application`";
            } else if (mode == 2) {
                sql = "select * from `t_loancaseinfo`";
            }

            ResultSet rs = st.executeQuery(sql);

            if (mode == 1) {
                while (rs.next()) {
                    if (rs.getString("ApplicationID").equals(applicationID)) {
                        exist = true;
                        break;
                    }
                }
            } else if (mode == 2) {
                while (rs.next()) {
                    if (rs.getString("CaseNo").equals(applicationID)) {
                        exist = true;
                        break;
                    }
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

        return exist;
    }

    // 取得借款當日的日期
    public LocalDate getLoanDate () {
        LocalDate loanDate = LocalDate.now();
        return loanDate;
    }
}
